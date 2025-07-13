package bank.notifier;

public class LoggerSubject extends NotifyingSubject {

	public LoggerSubject() {
		this.msg = "Logger: " + msg;
	}
}

