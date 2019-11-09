/*
 * Created Date: 2019-10-17
 * Subject: AES256, ÀÚ¹Ù °¡»ó µ¥½ºÅ©Åé È¯°æ(Java virtual desktop environment), 
 * 			HTTP Åë½Å(Http Communication)
 * Filename: Program.java
 * Author: Dodo (rabbit.white@daum.net)
 * Description:
 * 
 * 
 * Reference:
 * 
 */
package com.jasper;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jasper.application.JFrameLayout;
import com.jasper.view.MainFrm;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Program extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program frame = new Program();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Program() {
		setTitle("\uBB3C\uB958\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CustomDesktopPane desktopPane = new CustomDesktopPane();  
	    Container contentPane = getContentPane();  
	    
	    desktopPane.setBounds(10, 45, 1240, 655);
	    contentPane.add(desktopPane, BorderLayout.CENTER);
	    
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setBounds(0, 0, 1280, 30);
	    contentPane.add(menuBar);
	    
	    JMenu mnNFileMenu = new JMenu("ÆÄÀÏ(F)");
	    mnNFileMenu.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
	    mnNFileMenu.setMnemonic('F');
	    menuBar.add(mnNFileMenu);
	    
	    JMenuItem mntmQuitItem = new JMenuItem("Á¾·á(Quit)");
	    mntmQuitItem.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    mntmQuitItem.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
	    mnNFileMenu.add(mntmQuitItem);
	    	    
	    desktopPane.display(desktopPane);
	 
	    JFrameLayout layout = new JFrameLayout();
	    layout.centerLayout(this);
	    Point p = layout.getPoint();
	    setLocation(p.x, p.y);
		
	}


	class CustomDesktopPane extends JDesktopPane  
	{  
		private static final long serialVersionUID = 1L;
		
		private int x = 30;
		private int y = 50;
		public void display(CustomDesktopPane dp)   
		{  
		
			JInternalFrame jframe = new MainFrm();
			  
			jframe.setBounds(x, y, 400, 400);
			
			Container c1 = jframe.getContentPane();
			c1.add(new JLabel("I love my country"));  
			dp.add( jframe );  
			jframe.setVisible(true);         
			y += 85;  
			
		}  
	}
}