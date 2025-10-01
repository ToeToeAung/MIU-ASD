package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.save(customer);
		Message msg = new Message("Welcome " + customer.getName() + " as a new customer", customer.getEmail()); 
		emailSender.sendEmail(msg);
		publisher.publishEvent(new NewCustomerEvent(msg));
	}
}
