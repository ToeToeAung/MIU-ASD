package customers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;


@Service
@EnableAsync
public class CustomerRatingService {
	
	@Async
	@org.springframework.context.event.EventListener
	public void onEvent(NewCustomerEvent event) {
		System.out.println("Customer Rating Service: " + event);
	}
}
