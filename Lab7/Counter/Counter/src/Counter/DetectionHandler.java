package Counter;

public abstract class DetectionHandler {
	public Counter counter;
	
	public DetectionHandler(Counter counter) {
		this.counter = counter;
	}
	
	abstract void detect();
}
