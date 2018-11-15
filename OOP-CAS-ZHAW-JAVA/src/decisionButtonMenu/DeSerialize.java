package decisionButtonMenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeSerialize {
	
	private String path;
	ArrayList<String> array;
	
	public DeSerialize(String path) {
		this.path = path;
		
	}
	
	public void deSerialize() throws FileNotFoundException, IOException {
		
	    try (FileInputStream fis = new FileInputStream (path);
	    	    ObjectInputStream ois = new ObjectInputStream (fis))     
	    {
			array = (ArrayList<String>) ois.readObject();
		} 
	    
	    catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	   
		
	    for (int i=0; i<array.size(); i++) {
	    	System.out.println("WORT: " + array.get(i));
        }
	}

}
