package Counter;


public class IncrementCommand implements ICounterCommand {

	private Counter counter;

	public IncrementCommand(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void execute() {
		counter.increment();
	}
}
