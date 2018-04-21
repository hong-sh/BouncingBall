package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Common.Configuration;
import Controller.ActionController;

public class ButtonView {

	private JFrame jFrame;

	private JButton groupColorButton;
	private JButton groupColorStateButton;
	private JTextField groupTextField;
	private JButton groupAddButton;
	private JButton groupRemoveButton;

	private JComboBox<String> groupComboBox;
	private DefaultComboBoxModel<String> groupNames;
	private JButton ballStartButton;
	private JButton ballStopButton;
	private JButton ballAddButton;
	private JButton ballRemoveButton;

	public ButtonView() {

		initLayout();
	}

	private void initLayout() {

		jFrame = new JFrame("BouncingBall");
		jFrame.setLayout(new GridLayout(2, 4));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(Configuration.JFRAME_WIDTH, Configuration.JFRAME_HEIGHT);

		groupNames = new DefaultComboBoxModel<String>();

		groupColorButton = new JButton("color");
		groupColorButton.setActionCommand("color");

		groupColorStateButton = new JButton();
		groupColorStateButton.setEnabled(false);
		groupColorStateButton.setBackground(Color.black);

		groupTextField = new JTextField(20);

		groupAddButton = new JButton("GA");
		groupAddButton.setActionCommand("groupAdd");

		groupRemoveButton = new JButton("GR");
		groupRemoveButton.setActionCommand("groupRemove");

		groupComboBox = new JComboBox<>();

		ballStartButton = new JButton("в║");
		ballStartButton.setActionCommand("start");

		ballStopButton = new JButton("бс");
		ballStopButton.setActionCommand("stop");

		ballAddButton = new JButton("add");
		ballAddButton.setActionCommand("add");

		ballRemoveButton = new JButton("remove");
		ballRemoveButton.setActionCommand("remove");

		jFrame.add(groupColorButton);
		jFrame.add(groupColorStateButton);
		jFrame.add(groupTextField);
		jFrame.add(groupAddButton);
		jFrame.add(groupRemoveButton);

		jFrame.add(groupComboBox);
		jFrame.add(ballStartButton);
		jFrame.add(ballStopButton);
		jFrame.add(ballAddButton);
		jFrame.add(ballRemoveButton);

		jFrame.setVisible(true);
	}

	public void setActionController(ActionController actionController) {

		groupColorButton.addActionListener(actionController);
		groupAddButton.addActionListener(actionController);
		groupRemoveButton.addActionListener(actionController);

		ballStartButton.addActionListener(actionController);
		ballStopButton.addActionListener(actionController);
		ballAddButton.addActionListener(actionController);
		ballRemoveButton.addActionListener(actionController);
	}

	public void updateColorState(Color pickedColor) {
		groupColorStateButton.setBackground(pickedColor);
	}

	public String getGroupText() {
		return groupTextField.getText();
	}

	public String getGroupName() {
		return (String) groupComboBox.getSelectedItem();
	}

	public Color getGroupColor() {
		return groupColorStateButton.getBackground();
	}

	public void updateGroup(String groupName, int command) {

		if (command == 1) {

			if (groupNames.getIndexOf(groupName) < 0) {
				groupNames.addElement(groupName);
				groupComboBox.setModel(groupNames);
				groupNames.setSelectedItem(groupName);
			}

		} else if (command == 0) {
			if (groupNames.getIndexOf(groupName) >= 0) {
				groupNames.removeElement(groupName);
				groupComboBox.setModel(groupNames);
				groupNames.setSelectedItem(groupNames.getElementAt(0));
			}
		}

	}

}
