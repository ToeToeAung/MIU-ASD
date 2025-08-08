package CameraApp;

import java.util.Arrays;

public class UnregisterDetectionHandler extends DetectionHandler {

	String[] unregistered = { "XYZ1234", "ZYX4321" };

	public UnregisterDetectionHandler(CameraRecord record) {
		super(record);
	}

	@Override
	void detect() {
		if (Arrays.asList(unregistered).contains(this.record.licensePlate)) {
			System.out.println("Unregistered detected!");
		} else {
			DetectionHandler nextHandle = new UnpaidDetectionHandler(this.record);
			nextHandle.detect();
		}
	}
}
