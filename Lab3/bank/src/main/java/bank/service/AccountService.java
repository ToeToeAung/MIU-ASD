package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.notifier.EmailSubject;
import bank.notifier.EmailSender;
import bank.notifier.Logger;
import bank.notifier.LoggerSubject;
import bank.notifier.NotifyingSubject;
import bank.notifier.SMSSubject;
import bank.notifier.SMSSender;

public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private NotifyingSubject emailSubject = new EmailSubject();
	private NotifyingSubject smsSubject= new SMSSubject();
	private NotifyingSubject loggerSubject = new LoggerSubject();
	
	public AccountService(){
		accountDAO=new AccountDAO();
		new Logger(loggerSubject);
		new EmailSender(emailSubject);
		new SMSSender(smsSubject);
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);		

		emailSubject.setMsg("A New account created: " + accountNumber + " for " + customerName);
		emailSubject.notifyObservers();

		
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		
		notifyAccountChanges("Deposit " + amount + " to account " + accountNumber);

	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		
		notifyAccountChanges("Withdraw " + amount + " from account " + accountNumber);

	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		
		notifyAccountChanges("Transfer funds " + amount + " from account " + fromAccountNumber + " to account " + toAccountNumber);

	}
	
	private void notifyAccountChanges(String msg) {
		loggerSubject.setMsg(msg);
		smsSubject.setMsg(msg);
		loggerSubject.notifyObservers();
		smsSubject.notifyObservers();
	}
}
