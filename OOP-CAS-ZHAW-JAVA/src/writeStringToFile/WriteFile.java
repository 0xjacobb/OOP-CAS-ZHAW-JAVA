package writeStringToFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		
		try {
		    FileWriter writer = new FileWriter("src/duda.txt");
		    writer.write("Hallo, du da!");
		    
		    writer.close();
		    }
		catch (IOException ex){
		    ex.printStackTrace();
		}
	}
}

