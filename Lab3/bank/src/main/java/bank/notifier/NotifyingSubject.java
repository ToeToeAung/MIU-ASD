package bank.notifier;

import java.util.*;

public class NotifyingSubject {
	private List<Notifier> observerList;
	
	String msg;
			
	public void notifyObservers() {
		this.observerList.stream().forEach(e -> e.update());
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void attach(Notifier n) {
		if (null == observerList)
			observerList = new ArrayList<Notifier>();
		this.observerList.add(n);
	}
}
