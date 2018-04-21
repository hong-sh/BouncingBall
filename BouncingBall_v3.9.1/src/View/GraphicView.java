package View;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import Common.Configuration;
import Model.Oval;

public class GraphicView extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Oval> ovalList;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setSize(Configuration.GRAPHICVIEW_WIDTH, Configuration.GRAPHICVIEW_HEIGHT);

		if (ovalList != null) {
			
			for(int i=0; i<ovalList.size(); i++) {
				Oval oval = ovalList.get(i);
				g.setColor(oval.getOvalColor());
				g.fillOval(oval.getOvalX(), oval.getOvalY(), oval.getOvalWidth(), oval.getOvalHeight());
			}
		}
	}
	
	

	public void drawBall(ArrayList<Oval> ovalList) {

		this.ovalList = ovalList;
		this.repaint();
	}

}
