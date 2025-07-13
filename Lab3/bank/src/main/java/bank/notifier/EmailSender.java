package bank.notifier;

public class EmailSender extends Notifier {
	
	public EmailSender(NotifyingSubject ns) {
		this.subject = ns;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Email Sender: \t" + subject.msg);
	}

}
