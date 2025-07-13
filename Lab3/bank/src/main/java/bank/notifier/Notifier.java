package bank.notifier;

abstract class Notifier {
	NotifyingSubject subject;
	abstract void update(); 
}
