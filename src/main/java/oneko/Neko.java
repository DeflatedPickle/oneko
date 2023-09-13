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

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Neko the cat.
 *
 * <p>This program loads in 32 images of Neko, and tests them. (to show you that they've been
 * loaded). Neko will chase you mouse cursor around the desktop. Once she's over it and the mouse
 * doesn't move she'll prepare to take a nap. If the mouse go's outside the desktop she will reach
 * the border and try to dig for it. She'll eventually give up, and fall asleep.
 *
 * @author Werner Randelshofer (adaption for desktop) Chris Parent (original code)
 * @version 1.0.1 2010-07-17 Fixes timers. Sets longer sleep times when the cat sleeps. <br>
 *     1.0 2010-07-16 Created.
 */
public class Neko {
  private final JFrame catbox;
  private JLabel freeLabel, boxLabel;
  private final NekoController controller;

  public Neko(JFrame catbox) {
    this.catbox = catbox;
    NekoSettings settings = new NekoSettings();
    initComponents();
    controller = new NekoController(settings, catbox, freeLabel, boxLabel);
    controller.moveCatInBox();
  }

  /** This method is called from within the constructor to initialize the form. */
  private void initComponents() {
    freeLabel = new JLabel();
    boxLabel = new JLabel();

    ((JPanel) catbox.getGlassPane()).add(boxLabel);
    catbox.getGlassPane().setVisible(true);

    catbox.addComponentListener(
        new ComponentAdapter() {
          public void componentMoved(ComponentEvent e) {
            controller.catboxMoved();
          }
        });

    catbox.addWindowListener(
        new WindowAdapter() {
          public void windowDeiconified(WindowEvent e) {
            controller.catboxDeiconified();
          }
        });
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(
        () -> {
          var catbox = new JFrame("猫");
          catbox.setSize(16 * 32, 9 * 32);
          catbox.setBackground(new Color(200, 200, 200, 255));
          catbox.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          catbox.setVisible(true);

          var menubar = new JMenuBar();
          var file = new JMenu("File");
          var neww = new JMenuItem("New");
          file.add(neww);
          menubar.add(file);
          catbox.setJMenuBar(menubar);

          new Neko(catbox);
        });
  }
}
