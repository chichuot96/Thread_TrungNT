package vn.topica.itlab4.thread.ex1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * create Thread2 extends Thread to transfer all Lamp has status off from STORE to TRASH
 */
public class Thread2 extends Thread {
	//make list of Lamp synchronize
	List<Lamp> listStore=Collections.synchronizedList(new ArrayList<Lamp>());
	List<Lamp> listTrash=Collections.synchronizedList(new ArrayList<Lamp>());
	public Thread2(List<Lamp> listStore,List<Lamp> listTrash) {
		this.listStore=listStore;
		this.listTrash=listTrash;
	}
	@Override
	public void run() {
		System.out.println("Thread 2 is running...");
		//make thread loop infinitely
		while(true) {
			for(int i=0;i<listStore.size();i++) {
				//check any lamp has status OFF 
				if(listStore.get(i).getSt()==Lamp.Status.OFF) {
					System.out.println("Thread 2 : Remove "+listStore.get(i).toString() + " from STORE to TRASH");
					//add this Lamp to TRASH and remove from STORE
					listTrash.add(listStore.get(i));
					listStore.remove(i--);

				}
			}
			//check list Lamp in STORE
			for(int j=0;j<listStore.size();j++) {
				System.out.println("STORE : " + listStore.get(j).toString());
			}
			try {
				Thread.sleep(200);//sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
