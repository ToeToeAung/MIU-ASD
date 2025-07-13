package bank.notifier;

public class SMSSubject extends NotifyingSubject {

	public SMSSubject() {
		this.msg = "SMS: " + msg;
	}

}
