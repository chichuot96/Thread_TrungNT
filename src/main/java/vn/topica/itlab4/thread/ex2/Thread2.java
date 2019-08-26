package vn.topica.itlab4.thread.ex2;
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

	public void run() {
		System.out.println("Thread 2 is running...");
		//make thread loop infinitely
		while(true) {
			for(int i=0;i<listStore.size();i++) {
				//check any lamp has status OFF or REPAIR
				if(listStore.get(i).getSt()==Lamp.Status.OFF||listStore.get(i).getSt()==Lamp.Status.REPAIR) {
					System.out.println("Thread 2 : Move "+listStore.get(i).toString() + " from Store to Trash");
					//add Lamp to TRASH 
					listTrash.add(listStore.get(i));
					listStore.remove(i--);//remove from STORE

				}
			}
			//check list lamp in STORE 
			for(int j=0;j<listStore.size();j++) {
				System.out.println("Store : " + listStore.get(j).toString());
			}
			try {
				Thread.sleep(200);//thread sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
