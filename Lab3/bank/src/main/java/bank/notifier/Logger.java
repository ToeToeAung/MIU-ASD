package bank.notifier;


public class Logger extends Notifier{
	
	public Logger(NotifyingSubject ns) {
		this.subject = ns;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Logger: \t\t" + subject.msg);
	}
}

