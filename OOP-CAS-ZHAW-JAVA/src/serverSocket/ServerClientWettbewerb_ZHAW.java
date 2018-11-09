package serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/*
 * Man musste vom trinat.org Port 9998 einje Frage holen und auf Port 9999 beantowrten.
 * Frage war: Was macht die Methode accept() der Klasse ServerSocket?
*/

public class ServerClientWettbewerb_ZHAW {
	
	public void los() {
		
		try (Socket s = new Socket("trinat.org", 9998))
		{
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream()); 
			BufferedReader reader = new BufferedReader(streamReader);
			String advice = reader.readLine(); 
			System.out.println(advice);
		    reader.close();
		    
		 } catch(IOException ex){ 
			 ex.printStackTrace();
		 } 
		
		try (Socket s2 = new Socket("trinat.org", 9999))
		{
	        PrintWriter writer = new PrintWriter(s2.getOutputStream()); 
	        String tipp = "Hört auf Clients und stellt die Verbindung her";
	        writer.println(tipp);
		    
		 } catch(IOException ex){ 
			 ex.printStackTrace();
		 } 
	}

	public static void main(String[] args) {
		TippDesTagesClient client = new TippDesTagesClient();
		client.los();

	}

}
