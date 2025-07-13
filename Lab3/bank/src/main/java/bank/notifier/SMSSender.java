package bank.notifier;

public class SMSSender extends Notifier {
	public SMSSender(NotifyingSubject nd) {
		this.subject = nd;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("SMSSender:\t" + subject.msg);
	}

}
