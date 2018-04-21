package Controller;

import java.awt.Color;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import Model.BallManager;
import Model.Command;
import View.BallView;

public class BallController {

	private BallView ballView;
	private BallManager ballManager;
	private SocketController socketController;

	public BallController() {

		ballView = new BallView();
		ballManager = new BallManager();
		socketController = new SocketController(this);
	}

	public static void main(String args[]) {
		BallController ballController = new BallController();
		ballController.ballControl();

	}

	private void ballControl() {

		while (true) {
			try {

				ballManager.increaseXY();
				ballView.drawBall(ballManager.ballTooval());

				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void changeGroupMove(String grouopName, boolean isMove) {
		ballManager.setGroupMove(grouopName, isMove);
	}

	public void addBall(String groupName) {
		ballManager.addBall(groupName);
	}

	public void removeBall(String groupName) {
		ballManager.removeBall(groupName);
	}

	public void addGroup(String groupName, Color groupColor) {
		ballManager.addGroup(groupName, groupColor);
	}

	public void removeGroup(String groupName) {
		ballManager.removeGroup(groupName);
	}

	public void recieveCommand(Command command) {

		String action = command.getAction();

		if (action.equals("groupAdd")) {
			this.addGroup(command.getGroupname(), new Color(Integer.parseInt(command.getGroupcolor())));
		} else if (action.equals("groupRemove")) {
			this.removeGroup(command.getGroupname());
		} else if (action.equals("start")) {
			this.changeGroupMove(command.getGroupname(), true);
		} else if (action.equals("stop")) {
			this.changeGroupMove(command.getGroupname(), false);
		} else if (action.equals("add")) {
			this.addBall(command.getGroupname());
		} else if (action.equals("remove")) {
			this.removeBall(command.getGroupname());
		}

	}

}
