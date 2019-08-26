package vn.topica.itlab4.thread.ex1;

import java.util.List;
/*
 * Exercise 1: 
 * @Author: Nguyen Minh Chi - IT Lab4
 */
public class Main {

	public static void main(String[] args) {
		List<Lamp> listStore=Store.getStore();//create list STORE to store Lamp 
		List<Lamp> listTrash=Trash.getTrash();//create list TRASH to store Lamp after removed from STORE
		
		Thread1 t1=new Thread1(listStore);//create Thread1 to create Lamp and add to STORE
		Thread2 t2=new Thread2(listStore,listTrash);//create Thread2 to remove Lamp has status OFF from STORE to TRASH
		//Thread run
		t1.start();
		t2.start();

		}
	}


