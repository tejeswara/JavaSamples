package com.java.sample.code.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private BlockingQueue<String> queue;
	public Producer(BlockingQueue<String> q) {
		queue = q;
	}
	@Override
	public void run() {
		try {
			while(true) { queue.put((String)produce()); Thread.sleep(1000);}
		} catch(InterruptedException e) {
			System.out.println("Producer Interrupted");
		}
	}
	Object produce() {
		return new String("Hello Produced by " + Thread.currentThread().getName());
	}
}
class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	public Consumer(BlockingQueue<String> q) {
		queue = q;
	}
	@Override
	public void run() {
		try {
			while(true) { consume(queue.take()); Thread.sleep(1000); }
		} catch(InterruptedException e) {
			System.out.println("Consumer Interrupted");
		}
	}
	void consume(Object o) {
		System.out.println(o+ " Consumed by " + Thread.currentThread().getName());
	}
}
public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
	}
}
