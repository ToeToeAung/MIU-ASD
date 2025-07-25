package customers;

import java.util.Iterator;
import java.util.List;

public class SkipIterator implements Iterator<Customer> {
	private List<Customer> list;
	private Iterator<Customer> it;
	
	public SkipIterator(List<Customer> list) {
		this.list = list;
		this.it = this.list.iterator();
	}

	@Override
	public boolean hasNext() {
		if (it.hasNext())
			return true;
		return false;
	}

	@Override
	public Customer next() {
		return it.next();
	}
	
	public void skipIterate() {
		while(it.hasNext()) {
			System.out.println(it.next());			
			if (it.hasNext())
				it.next();
		}
	}

}
