package CameraApp;

public class CameraRecord {
	String licensePlate;
	String cameraId;
	double speed;

	public CameraRecord(String cameraId, String licensePlate, double vehicleSpeed) {
		this.licensePlate = licensePlate;
		this.cameraId = cameraId;
		this.speed = speed;
	}

	public void checkStatus() {
		System.out.println(this.toString());
		DetectionHandler handler = new UnregisterDetectionHandler(this);
		handler.detect();
		System.out.println();
	}

	@Override
	public String toString() {
		return "Camera=" + this.cameraId + "\tplate=" + this.licensePlate + "\tspeed=" + this.speed;
	}
}
