/*
 * Copyright (c) 2023 DeflatedPickle
 * Copyright (c) 2019 Jerry Reno
 * Copyright (c) 2010 Werner Randelshofer
 *
 * This is public domain software, under the terms of the UNLICENSE
 * http://unlicense.org
 *
 * This is a desktop adaptation of the applet
 * JAVA NEKO V1.0 by Chris Parent, 1999.
 * http://mysite.ncnetwork.net/res8t1xo/class/neko.htm
 */

package oneko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.WindowConstants;

/**
 * Neko the cat.
 * <p>
 * This program loads in 32 images of Neko, and tests them. (to show you that
 * they've been loaded). Neko will chase you mouse cursor around the desktop.
 * Once she's over it and the mouse doesn't move she'll prepare to take a nap.
 * If the mouse go's outside the desktop she will reach the border and try
 * to dig for it. She'll eventually give up, and fall asleep.
 *
 * @author Werner Randelshofer (adaption for desktop)
 *		 Chris Parent (original code)
 * @version 1.0.1 2010-07-17 Fixes timers. Sets longer sleep times when the
 * cat sleeps.
 * <br>1.0 2010-07-16 Created.
 */
public class Neko {
	//
	//Constants
	private static Dimension MINSIZE=new Dimension(64,64);
	private static Dimension PRFSIZE=new Dimension(64*16,64*9);

	//
	// UI Components
	private JFrame catbox;
	private JLabel freeLabel,boxLabel;
	private NekoSettings settings;
	private NekoController controller;

	/** Creates new form Neko */
	public Neko() {
		settings=new NekoSettings();
		initComponents();
		controller=new NekoController(settings,catbox,freeLabel,boxLabel);
		setWindowMode();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 */
	private void initComponents() {
		catbox=new JFrame("猫");
		catbox.setBackground(new Color(200,200,200,255));
		catbox.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		freeLabel = new JLabel();
		boxLabel = new JLabel();

		catbox.getContentPane().add(boxLabel);
		catbox.pack();

		// We really don't want a layout manager messing with us.
		// Maybe this class should BE a layout manager.
		catbox.getContentPane().setLayout(new LayoutManager() {
			public void addLayoutComponent(String n,Component c) {}
			public void layoutContainer(Container p){}
			public Dimension minimumLayoutSize(Container p) { return MINSIZE;}
			public Dimension preferredLayoutSize(Container p) { return PRFSIZE;}
			public void removeLayoutComponent(Component c) {}
		});

		catbox.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				controller.catboxMoved();
			}
		});
		catbox.addWindowListener(new WindowAdapter() {
			public void windowDeiconified(WindowEvent e) {
				controller.catboxDeiconified();
			}
		});
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Neko();
			}
		});
	}

	public void setWindowMode()
	{
		catbox.setTitle("猫");
		catbox.setVisible(true);
		controller.moveCatInBox();
	}
}

