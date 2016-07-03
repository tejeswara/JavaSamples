package com.java.sample.code.threads;

class RunnableThread implements Runnable {
	@Override
	public void run() {
		System.out.println("I am runnable thread");
	}
}

class Threadclass extends Thread {
	public void run() {
		System.out.println("I am a thread class");
	}
}

public class SimpleThreads {
	public static void main(String[] args) {
		new Thread(new RunnableThread()).start();
		new Threadclass().start();
	}
}
