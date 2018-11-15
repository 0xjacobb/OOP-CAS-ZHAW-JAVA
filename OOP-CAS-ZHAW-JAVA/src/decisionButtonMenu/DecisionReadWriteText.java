package decisionButtonMenu;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * eine Klasse, welche die Einträge (Entscheidungen) in der 
 * Liste als Text in eine Textdatei schreiben und aus der Datei zurück in die Liste einlesen kann
 */


public class DecisionReadWriteText {
	
	private ArrayList<String> answers;
	private String path = "src/answers.txt";
	
	public DecisionReadWriteText(ArrayList<String> answers) {
		this.answers = answers;
	}

	public void writeTextFile() throws IOException {
		try {
			FileWriter newFile = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(newFile);
			for(String str: answers) {
				writer.write(str);
				writer.newLine();
			}
		
			writer.close();
			
		} catch (IOException e)	{
			e.printStackTrace();	
		}
	}
	
	public void readTextFile() throws IOException {
		
	    try {
	    	File myFile = new File (path);
	    	FileReader fileReader = new FileReader(myFile);
	    	BufferedReader reader = new BufferedReader(fileReader);
	    	String line = null;
	    	
	    	while ((line = reader.readLine()) != null){
	    		System.out.println(line);
			}
				reader.close();
		} 
	    
	    catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		   
	}

}
