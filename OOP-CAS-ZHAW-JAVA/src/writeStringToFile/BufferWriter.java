package writeStringToFile;

import java.io.BufferedWriter;
import java.io.IOException;

public class BufferWriter {

	public static void main(String[] args) {
		String path = "src/datei.txt";
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(path))))
		{
			long start = System.currentTimeMillis();
			
			for (int i = 0; i < 10_000_000; i++) { 
				buffer.write("a");
			}
			
			buffer.write(System.getProperty("line.separator") + " Ende"); 
			long stop = System.currentTimeMillis();
		    System.out.println("Zeit: " + (stop - start) + " millisekunden");
		    
		 } catch (IOException e){
			 e.printStackTrace();
		 }
	}
}
