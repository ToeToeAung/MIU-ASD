package customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}		
	
		AgeIterator ai = new AgeIterator(customers);
		while(ai.hasNext()) {
			System.out.println(ai.next());
		}		
		
		FilterIterator fi = new FilterIterator(customers);
		System.out.println("Filter by City Chicago");
		fi.filterByCity("Chicago");
		
		System.out.println("Filter by zipcode starts with 12");
		fi.filterByZipcode("12");
		

		SkipIterator si = new SkipIterator(customers);
		si.skipIterate();

	}

}
