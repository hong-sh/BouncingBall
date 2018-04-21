package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import View.ColorChooserView;

public class ActionController implements ActionListener{

	private RemoteController ballController;
	
	public ActionController(RemoteController ballController) {
		this.ballController = ballController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("color")) {
			Color pickedColor = JColorChooser.showDialog(new ColorChooserView(), "choose ball color", Color.black);
			ballController.updateColorState(pickedColor);
		} else if(e.getActionCommand().equals("groupAdd")) {
			ballController.addGroup(e.getActionCommand(), ballController.getGroupText(), ballController.getGroupColor());
		} else if(e.getActionCommand().equals("groupRemove")) {
			ballController.removeGroup(e.getActionCommand(), ballController.getGroupText());
		} else {
			ballController.removeBall(e.getActionCommand(), ballController.getGroupName());
		}
	}

	
}
