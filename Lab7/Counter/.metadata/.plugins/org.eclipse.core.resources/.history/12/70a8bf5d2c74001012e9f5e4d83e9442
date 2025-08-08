package Counter;

public class DecrementCommand implements ICounterCommand {

	private Counter counter;

	public DecrementCommand(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void execute() {
		this.counter.decrement();
	}
}
