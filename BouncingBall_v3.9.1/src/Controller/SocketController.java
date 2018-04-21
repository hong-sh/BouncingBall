package Controller;

import java.io.IOException;
import java.net.ServerSocket;

import Common.Configuration;
import Model.Command;

public class SocketController {

	private BallController ballController;
	private ServerSocket serverSocket;

	public SocketController(BallController ballController) {

		this.ballController = ballController;

		try {

			serverSocket = new ServerSocket(Configuration.SERVER_PORT);
			new SocketThread(serverSocket.accept(), this).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recievedCommand(Command command) {
		ballController.recieveCommand(command);
	}

	

}
