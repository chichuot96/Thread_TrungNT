package vn.topica.itlab4.thread.ex2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 *Class Trash extends collection to save Lamps has status OFF 
 */
public class Trash extends ArrayList<Lamp>{
	//make list synchronize
	private final static List<Lamp> trash = Collections.synchronizedList(new Trash());
	
	public static List<Lamp> getTrash() {
		return trash;
	}

}
