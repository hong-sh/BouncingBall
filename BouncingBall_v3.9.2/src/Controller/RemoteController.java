package Controller;

import java.awt.Color;

import Model.JaxbCommand;
import View.ButtonView;

public class RemoteController {

	private ButtonView buttonView;
	private ActionController actionController;
	private SocketController socketController;
	private JaxbCommand jaxbCommand;
	
	public RemoteController() {
		
		buttonView = new ButtonView();
		actionController = new ActionController(this);
		buttonView.setActionController(actionController);
	}
	
	public static void main(String args[]) {
		RemoteController remoteController = new RemoteController();
		remoteController.remoteControl();
	}
	
	private void remoteControl() {
		
		jaxbCommand = new JaxbCommand();
		socketController = new SocketController();
	}
	
	public void changeGroupMove(String action, String groupName) {
		socketController.sendCommand(jaxbCommand.getXMLCommand(action, groupName));
	}
	
	public void addBall(String action, String groupName) {
		socketController.sendCommand(jaxbCommand.getXMLCommand(action, groupName));
	}
	
	public void removeBall(String action, String groupName) {
		socketController.sendCommand(jaxbCommand.getXMLCommand(action, groupName));
	}
	
	public void addGroup(String action, String groupName, Color groupColor) {
		socketController.sendCommand(jaxbCommand.getXMLCommand(action, groupName, groupColor));
		updateGroup(groupName, 1);
	}
	
	public void removeGroup(String action, String groupName) {
		socketController.sendCommand(jaxbCommand.getXMLCommand(action, groupName));
		updateGroup(groupName, 0);
	}
	
	private void updateGroup(String groupName, int command) {
		buttonView.updateGroup(groupName, command);
	}
	
	public void updateColorState(Color pickedColor) {
		buttonView.updateColorState(pickedColor);
	}
	
	public String getGroupText() {
		return buttonView.getGroupText();
	}
	
	public String getGroupName() {
		return buttonView.getGroupName();
	}
	
	public Color getGroupColor() {
		return buttonView.getGroupColor();
	}
	
	
}
