package View;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import Common.Configuration;
import Model.Oval;

public class BallView {

	private JFrame jFrame;
	private GraphicView graphicView;
	
	public BallView() {
		
		jFrame = new JFrame("BouncingBall");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(Configuration.JFRAME_WIDTH, Configuration.JFRAME_HEIGHT);
		
		graphicView = new GraphicView();
		
		jFrame.getContentPane().add(graphicView, BorderLayout.CENTER);
		
		jFrame.setVisible(true);
	}
	
	public void drawBall(ArrayList<Oval> ovalList) {
		graphicView.drawBall(ovalList);
	}
	
}
