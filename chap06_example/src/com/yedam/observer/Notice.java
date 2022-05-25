package com.yedam.observer;

import java.util.ArrayList;
import java.util.List;

public class Notice {
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	public void notifyObservers(String msg) {
		for(Observer o: observers)
			o.receive(msg);
	}
}
