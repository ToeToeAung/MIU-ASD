package Counter;


public class OrangeDetectionHandler extends DetectionHandler {

	public OrangeDetectionHandler(Counter counter) {
		super(counter);
	}

	@Override
	void detect() {
		int c = counter.getCount();
		if (c >= 15 & c % 2 != 0 & (c != 17 | c != 19 | c != 12 | c != 13)) {
			System.out.println("Orange: Odd, more than 14, not equal 17, nor 19");
		}
	}
}
