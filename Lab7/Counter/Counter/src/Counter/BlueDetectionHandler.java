package Counter;

public class BlueDetectionHandler extends DetectionHandler {

	public BlueDetectionHandler(Counter counter) {
		super(counter);
	}

	@Override
	void detect() {
		int c = counter.getCount();
		if ((c % 2 != 0 & c < 15 & (c != 12 | c != 13)) | c == 17 | c == 19) {
			System.out.println("Blue: odd, less than 15, or equal 17 or 19");
		} else {
			DetectionHandler orange = new OrangeDetectionHandler(counter);
			orange.detect();
		}
	}
}
