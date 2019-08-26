package vn.topica.itlab4.thread.ex2;

import java.util.List;
/*
 * Exercise 2: 
 * @Author: Nguyen Minh Chi - IT Lab4
 */
public class Main {
	public static void main(String[] args) {
		List<Lamp> listStore=Store.getStore();//create list STORE to store Lamp 
		List<Lamp> listTrash=Trash.getTrash();//create list TRASH to store Lamp after removed from STORE
		Thread1 t1=new Thread1(listStore);//create Thread1 to create Lamp and add to STORE

		Thread2 t2=new Thread2(listStore,listTrash);//create Thread2 to remove Lamp has status REPAIR and OFF from STORE to TRASH

		Thread3 t3=new Thread3(listStore,listTrash);//create Thread3 to remove Lamp has status REPAIR and random Lamp has status of from TRASH to STORE
		//thread run
		t1.start();
		t2.start();
		t3.start();
		}
	}


