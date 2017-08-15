package lv.bc.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
* HelloWorldSwing.java requires no other files.
*/
import javax.swing.*;  

public class Menu {
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Language Learning App");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Add menu bar
	        //Where the GUI is created:
	        	JMenuBar menuBar;
	        	JMenu menu, submenu;
	        	JMenuItem menuItem;
	        	JRadioButtonMenuItem rbMenuItem;
	        	JCheckBoxMenuItem cbMenuItem;

	        	//Create the menu bar.
	        	menuBar = new JMenuBar();

	        	//Build the first menu.
	        	menu = new JMenu("A Menu");
	        	menu.setMnemonic(KeyEvent.VK_A);
	        	menu.getAccessibleContext().setAccessibleDescription(
	        	        "The only menu in this program that has menu items");
	        	menuBar.add(menu);

	        	//a group of JMenuItems
	        	menuItem = new JMenuItem("A text-only menu item",
	        	                         KeyEvent.VK_T);
	        	menuItem.setAccelerator(KeyStroke.getKeyStroke(
	        	        KeyEvent.VK_1, ActionEvent.ALT_MASK));
	        	menuItem.getAccessibleContext().setAccessibleDescription(
	        	        "This doesn't really do anything");
	        	menu.add(menuItem);

	        	menuItem = new JMenuItem("Both text and icon",
	        	                         new ImageIcon("images/middle.gif"));
	        	menuItem.setMnemonic(KeyEvent.VK_B);
	        	menu.add(menuItem);

	        	menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
	        	menuItem.setMnemonic(KeyEvent.VK_D);
	        	menu.add(menuItem);

	        	//a group of radio button menu items
	        	menu.addSeparator();
	        	ButtonGroup group = new ButtonGroup();
	        	rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
	        	rbMenuItem.setSelected(true);
	        	rbMenuItem.setMnemonic(KeyEvent.VK_R);
	        	group.add(rbMenuItem);
	        	menu.add(rbMenuItem);

	        	rbMenuItem = new JRadioButtonMenuItem("Another one");
	        	rbMenuItem.setMnemonic(KeyEvent.VK_O);
	        	group.add(rbMenuItem);
	        	menu.add(rbMenuItem);

	        	//a group of check box menu items
	        	menu.addSeparator();
	        	cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
	        	cbMenuItem.setMnemonic(KeyEvent.VK_C);
	        	menu.add(cbMenuItem);

	        	cbMenuItem = new JCheckBoxMenuItem("Another one");
	        	cbMenuItem.setMnemonic(KeyEvent.VK_H);
	        	menu.add(cbMenuItem);

	        	//a submenu
	        	menu.addSeparator();
	        	submenu = new JMenu("A submenu");
	        	submenu.setMnemonic(KeyEvent.VK_S);

	        	menuItem = new JMenuItem("An item in the submenu");
	        	menuItem.setAccelerator(KeyStroke.getKeyStroke(
	        	        KeyEvent.VK_2, ActionEvent.ALT_MASK));
	        	submenu.add(menuItem);

	        	menuItem = new JMenuItem("Another item");
	        	submenu.add(menuItem);
	        	menu.add(submenu);

	        	
	        	
	        	//Build File menu bar
	        	menu = new JMenu("File");
	        	
	        	menu.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						JMenu item = (JMenu) e.getSource();
					    item.setSelected(false);
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
						JMenu item = (JMenu) e.getSource();
						item.setSelected(true);
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// Auto-generated method stub
						
					}
				});
	        	menuBar.add(menu);
	        	
	        	menuItem = new JMenuItem("First topic");
	        	menuItem.addActionListener(new ActionListener() {
	        	    public void actionPerformed(ActionEvent e) {
	        	        System.out.println("You chose topic 1");
	        	    }
	        	});
	        	menu.add(menuItem);
	        	
	        	menuItem = new JMenuItem("Second topic");
	        	menuItem.addActionListener(new ActionListener() {
	        	    public void actionPerformed(ActionEvent e) {
	        	        System.out.println("You chose topic 2");
	        	    }
	        	});
	        	menu.add(menuItem);
	        	
	        	menuItem = new JMenuItem("etc.");
	        	menuItem.addActionListener(new ActionListener() {
	        	    public void actionPerformed(ActionEvent e) {
	        	        System.out.println("etc.");
	        	    }
	        	});
	        	menu.add(menuItem);
	        	
	        	menuItem = new JMenuItem("Exit");
	        	menuItem.addActionListener(new ActionListener() {
	        	    public void actionPerformed(ActionEvent e) {
	        	       System.exit(0);
	        	    }
	        	});
	        	menuItem.setMnemonic(KeyEvent.VK_E);
	        	menu.add(menuItem);
	        	
	        	
	        	frame.setJMenuBar(menuBar);
	       
	        //Display the window.
	        frame.setSize(400,400);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}
