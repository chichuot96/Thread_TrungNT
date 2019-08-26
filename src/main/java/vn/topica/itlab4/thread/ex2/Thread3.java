package vn.topica.itlab4.thread.ex2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/*
 * create Thread3 extends Thread to remove Lamp has Status REPAIR and random Lamp has Status OFF from TRASH and add to STORE
 */
public class Thread3 extends Thread{
	//make list of Lamp synchronize
	List<Lamp> listStore=Collections.synchronizedList(new ArrayList<Lamp>());
	List<Lamp> listTrash=Collections.synchronizedList(new ArrayList<Lamp>());
	public Thread3(List<Lamp> listStore,List<Lamp> listTrash) {
		this.listStore=listStore;
		this.listTrash=listTrash;
	}
	
	public void run() {
		System.out.println("Thread 3 is running..");
		//make thread loop infinitely 
		while(true) {
			for(int i=0;i<listTrash.size();i++) {
				if(listTrash.get(i).getSt()==Lamp.Status.REPAIR) { //check Lamp has Status REPAIR
					System.out.println("Thread 3 : Move "+listTrash.get(i).toString() +" from Trash to Store ");
					listStore.add(listTrash.get(i));//add this Lamp to STORE
					listTrash.remove(i--);//remove this Lamp from TRASH
				}else {//random 0 or 1
					Random ran=new Random();
					if((ran.nextInt(2))==0) {
						listTrash.remove(i--);//random = 0 remove this Lamp (has Status = OFF) from TRASH 
					}else {//random = 1 : change Status of this Lamp to REPAIR
						listTrash.get(i).setSt(Lamp.Status.REPAIR);
						System.out.println("Thread 3 : Lamp "+listTrash.get(i).getIndex()+" change Status from OFF to REPAIR and move from Trash to Store ");
						listStore.add(listTrash.get(i));//add this Lamp to STORE
						listTrash.remove(i--);//remove this Lamp from TRASH
					}
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
