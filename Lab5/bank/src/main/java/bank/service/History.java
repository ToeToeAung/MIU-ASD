package bank.service;
import java.util.Stack;

import bank.command.DepositCommand;
import bank.command.ICommand;
import bank.command.TransferFundsCommand;
import bank.command.WithdrawCommand;
import bank.domain.Account;

public class History {
	public Stack<ICommand> cmddList = new Stack<>();
	public Stack<ICommand> undoList = new Stack<>();
	
	public void undo() {
		if (!cmddList.isEmpty()) {
			ICommand command = cmddList.pop();		
			ICommand newCommand = null;
			Account account = command.getAccount();
			double amount = command.getAmount();
			Account toAccount = command.getToAccount();

			switch (command.getClass().getSimpleName()) {
			case "DepositCommand":
				System.out.println("UNDO DEPOSIT");
				newCommand = new WithdrawCommand(account, amount);
				newCommand.execute();
			case "WithdrawCommand":
				System.out.println("UNDO WITHDRAW");
				newCommand = new DepositCommand(account, amount);
				newCommand.execute();
			case "TransferFundsCommand":
				System.out.println("UNDO TRANSFERFUNDS");				
				if (null != toAccount) {
					newCommand = new TransferFundsCommand(toAccount, account, amount, "undo the previous transfer");
					newCommand.execute();
				}
			default:
				break;
			}
			if (null != newCommand)
				undoList.push(newCommand);
		}
	}
	
	public void redo() {
		if (!cmddList.isEmpty()) {
			ICommand command = cmddList.peek();
			System.out.println("REDO " + command.getClass().getSimpleName());
			command.execute();
			cmddList.push(command);
		}
	}
	
	public void addCommand(ICommand command) {
		cmddList.push(command);
	}
}
