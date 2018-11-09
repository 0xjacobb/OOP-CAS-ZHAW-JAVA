package serverSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
