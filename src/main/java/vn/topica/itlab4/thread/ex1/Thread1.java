package vn.topica.itlab4.thread.ex1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * create Thread 1 extends thread to create and store Lamp to STORE
 */
public class Thread1 extends Thread {
	//make list of Lamp synchronize
	List<Lamp> listStore=Collections.synchronizedList(new ArrayList<Lamp>());
	
	public Thread1(List<Lamp> listStore) {
		this.listStore=listStore;
	}
	@Override
	public void run() {
		System.out.println("Thread 1 is running...");
		//make thread loop infinitely 
		while(true) {
			//each loop create a random number of Lamp and add to STORE
			int random=(int)(Math.random()*20+1);
			for(int i=0;i<random;i++) {
				Lamp lamp=new Lamp();//Create new lamp
				listStore.add(lamp);//add lamp to STORE
				System.out.println("Thread 1: Create new "+lamp.toString()+" and add to Store");
				try {
					Thread.sleep(100);//Thread sleep after create a Lamp 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		

	}
}
