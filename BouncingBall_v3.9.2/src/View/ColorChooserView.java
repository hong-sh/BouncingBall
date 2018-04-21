package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorChooserView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JColorChooser tcc;
	private JLabel banner;
	
	public ColorChooserView() {
		super(new BorderLayout());
		
		banner = new JLabel("Choose Ball Color", JLabel.CENTER);
		banner.setForeground(Color.yellow);
		banner.setBackground(Color.BLACK);
		banner.setOpaque(true);
		banner.setFont(new Font("SansSerif", Font.BOLD, 24));
		banner.setPreferredSize(new Dimension(100, 65));
		
		JPanel bannerPanel = new JPanel(new BorderLayout());
		bannerPanel.add(banner, BorderLayout.CENTER);
		bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));
		
		tcc = new JColorChooser(banner.getForeground());
		tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
		
		add(bannerPanel, BorderLayout.CENTER);
		add(tcc, BorderLayout.PAGE_END);
		
	}
	
}
