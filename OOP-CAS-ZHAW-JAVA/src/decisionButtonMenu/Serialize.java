package decisionButtonMenu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Serialize {
	
	private ArrayList<String> answers;
	private String path;
	
	public Serialize(String path, ArrayList<String> answers){
		this.answers = answers;
		this.path = path;	
		
	}
	public void serialize() {
		try (OutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos))
				{
					oos.writeObject(answers);
					oos.close();
				}
				
				catch (IOException e)
				{
					e.printStackTrace();	
				}
	}

}
