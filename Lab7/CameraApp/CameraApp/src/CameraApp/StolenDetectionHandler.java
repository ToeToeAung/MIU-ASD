package CameraApp;

public class StolenDetectionHandler extends DetectionHandler {

	public StolenDetectionHandler(CameraRecord record) {
		super(record);
	}

	@Override
	public void detect() {
		if (record.licensePlate.contains("ABC1234")) {
			System.out.println("Stolen detected!");
		} else {
			DetectionHandler nextHandle = new SpeedingDetectionHandler(record);
			nextHandle.detect();
		}
	}
}
