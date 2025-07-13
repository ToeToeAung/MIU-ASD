package bank.notifier;

public class EmailSubject extends NotifyingSubject {

	public EmailSubject() {
		this.msg = "Email: " + msg;
	}

}
