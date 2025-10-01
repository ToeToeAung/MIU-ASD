package customers;

public class NewCustomerEvent {
	private Message message;

	public NewCustomerEvent(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "New Customer Event [message=" + message + "]";
	}
}
