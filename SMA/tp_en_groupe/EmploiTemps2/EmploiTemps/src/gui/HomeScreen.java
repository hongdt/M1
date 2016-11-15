package gui;

/*
 * @(#)HomeScreen.java
 */

import javax.swing.*;
import javax.swing.border.*;


import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class HomeScreen extends TTGSModule {
	
	JPanel pl = new JPanel();

	/**
	 * HomeScreen Constructor
	 */
	public HomeScreen(TTGS ttgs) {
		// Set the title for this demo, and an icon used to represent this
		// demo inside the com.TTGS app.
		super(ttgs, "HomeScreen", "toolbar/Home16.png");
		// Set the layout manager.

		JPanel p = getDemoPanel();
		p.setBorder(new LineBorder(Color.DARK_GRAY));
		p.setLayout(new BorderLayout());
		p.setBackground(Color.white);
		JPanel psub = new JPanel();
		psub.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
		psub.setBackground(Color.white);
		psub.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20, 10, 20, 10);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		psub.add(pl, c);
		c.gridx = 50;
	
		c.gridx = 10;
		psub.add(new JLabel(createImageIcon("Logo33.gif")), c);
		c.gridy = 20;
		c.anchor = GridBagConstraints.SOUTH;

		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
	

		p.add(new JLabel(createImageIcon("toolbar/Title32.png")),
				BorderLayout.NORTH);
		p.add(psub, BorderLayout.CENTER);
		getTTGS().loadDemos();
	}

	private ImageIcon createImageIcon(String filename) {
		return getTTGS().createImageIcon(filename, "");
	}

	public JButton CreateButton(ImageIcon icn) {
		JButton jb = new JButton(icn);
		jb.setContentAreaFilled(false);
		jb.setBorderPainted(false);
		return jb;
	}

	public void openHelpWindow() {
		TTGSHelp dialog = new TTGSHelp(ttgs.getFrame());
		dialog.show();
	}

	public void showAboutBox() {
		ttgs.showAbout();
	}

	
	public void showExportBox() {
		URL img = getClass()
				.getResource("/resources/images/toolbar/Expo32.png");
		String s0 = "<html><body bgcolor=\"#ffffff\"><img src=\"" + img
				+ "\"></body></html>";
		MSGBOX("Export", s0, JOptionPane.PLAIN_MESSAGE);
	}

}
