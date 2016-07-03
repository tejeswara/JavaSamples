package com.java.sample.code.patterns;

import java.util.ArrayList;
import java.util.List;

class Subject {
	private String state;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer o) {
		observers.add(o);
	}
	public void setState(String s) {
		state = s;
		notifyAllObservers();
	}
	private void notifyAllObservers() {
		for (Observer o : observers) {
			o.update(state);
		}
	}
}

abstract class Observer {
	protected Subject subject;
	public abstract void update(String s);
}

class HexObserver extends Observer {
	public HexObserver(Subject sub) {
		subject = sub;
		subject.attach(this);
	}
	public void update(String s) {
		System.out.println("Update hex observer new state of subject which is " + s);
	}
}

class DecimalObserver extends Observer {
	public DecimalObserver(Subject sub) {
		subject = sub;
		subject.attach(this);
	}
	public void update(String s) {
		System.out.println("Update decimal observer new state of subject which is " + s);
	}
}

// Observer pattern client class
public class ObserverPattern {
	public static void main(String[] args) {
		// Create subject
		Subject s = new Subject();
		
		// Attach subject while creating observers
		new HexObserver(s);
		new DecimalObserver(s);
		
		// Set new state to subject and notify observers
		s.setState("10");
		s.setState("15");
		s.setState("20");
	}
}
