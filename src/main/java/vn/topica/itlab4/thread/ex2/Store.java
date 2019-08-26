package vn.topica.itlab4.thread.ex2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/*
 * Class Store extends collection to store Lamp
 */
public class Store extends ArrayList<Lamp>{
	
	private final static List<Lamp> store = Collections.synchronizedList(new Store());
	
	public static List<Lamp> getStore() {
		return store;
	}
	

}
