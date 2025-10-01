package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Value("smtp.mydomain.com")
	private String emailServer;
	@Autowired
	private Logger logger;
	
	public void sendEmail(Message msg) {
		System.out.println("EmailSender: sending \'" + msg.getContent() + "\' to " + msg.getEmail());
		logger.log("Email is sent: " + msg.toString());
	}
	
	public String getEmailServer() {
		return this.emailServer;
	}
}
