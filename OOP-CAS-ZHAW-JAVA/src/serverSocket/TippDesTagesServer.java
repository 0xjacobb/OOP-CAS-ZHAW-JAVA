package serverSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * Kann auchmit telnet angeschaut werden. 
 * 1. Java Programm laufen lassen
 * 2. Im Terminal "telnet localhost 4242" eingeben und man bekommt die Tipps zurück (auch in Konsole)
 */

public class TippDesTagesServer {
	
	String[] tippListe = {"Nehme kleiner Bisse", "Sali Walti", "Du bist schön"};
	
	public void los() {
		try (ServerSocket serverSock = new ServerSocket(4242)) 
		{
			while(true) {
				Socket sock = serverSock.accept();
		        PrintWriter writer = new PrintWriter(sock.getOutputStream()); 
		        String tipp = getTipp();
		        writer.println(tipp);
		        writer.close();
		        System.out.println(tipp);
		    }
			
		 } catch(IOException ex){
			ex.printStackTrace();
		} 
	}
	
	private String getTipp() {
		int random = (int) (Math.random() * tippListe.length);
		return tippListe[random];
	}
	
	public static void main(String[] args) {
		TippDesTagesServer server = new TippDesTagesServer();
		server.los();

	}

}
