package Controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Common.Configuration;

public class SocketController {

	private Socket socket;
	private PrintWriter pw;
	
	public SocketController() {
		
		try {
			
			socket = new Socket(Configuration.SERVER_IP, Configuration.SERVER_PORT);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendCommand(String command) {
		
		pw.println(command);
		pw.flush();
		
	}
}
