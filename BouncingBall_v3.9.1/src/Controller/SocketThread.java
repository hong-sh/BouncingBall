package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.xml.sax.InputSource;

import Model.Command;
import Model.ObjectFactory;

public class SocketThread extends Thread {

	private Socket socket;
	private SocketController socketController;
	private JAXBContext jaxbContext;

	public SocketThread(Socket socket, SocketController socketController) {
		try {
			this.socket = socket;
			this.socketController = socketController;
			jaxbContext = JAXBContext.newInstance(Command.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			String stringCommand = "";

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while ((stringCommand = br.readLine()) != null) {
				try {
					
					Command command = (Command) jaxbContext.createUnmarshaller()
							.unmarshal(new InputSource(new StringReader(stringCommand)));
					socketController.recievedCommand(command);
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}