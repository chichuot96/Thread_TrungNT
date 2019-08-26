package vn.topica.itlab4.thread.ex1;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Create Lamp has property status and index
 */
public class Lamp {
	public enum Status{
		ON,
		OFF
	}
	public Status st;
	private int index;
	//create automatic index
	private static final AtomicInteger count = new AtomicInteger(0);
	public Lamp() {
		this.st=Status.values()[(int)(Math.random()*Status.values().length)];//random value Status ON or OFF
		this.index=count.incrementAndGet();
	}
	public Status getSt() {
		return this.st;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setSt(Status status) {
		this.st=status;
	}
	public String toString() {
		return "lamp "+this.index+ " status "+this.st;
	}

}




