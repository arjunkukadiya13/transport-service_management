//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;



public class MasterFrame extends JFrame
{
	MenuBar mb1;
	Menu m1,m2,m3,m4;
	Font f1;
	MenuItem mi1,mi2;
	//JButton taxiButton;
	LoginEvent ml = new LoginEvent(this);
	MasterFrame()
	{
		super("Main Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		setContentPane(new JLabel(new ImageIcon("C:\\tr2.jpg")));
		setSize(1000,800);
		setVisible(true);
		f1 = new Font("Times",Font.BOLD,15);
		mb1 = new MenuBar();
		m1 = new Menu("Vechiles");
		
		mi1 = new MenuItem("Taxi");
		mi2 = new MenuItem("Truck");
		
		setBackground(Color.GRAY);
		
		
		mi1.setFont(f1);
		mi2.setFont(f1);
		
		
		//m1.setFont(f1);
		//mb1.setFont(f1);
		

		m1.add(mi1);
		m1.add(mi2);
		
		
		
		mb1.add(m1);
		
		setMenuBar(mb1);

		mi1.addActionListener(ml);
		mi2.addActionListener(ml);
		
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public static void main(String s[])
	{
		MasterFrame  mf = new MasterFrame ();
		mf.setVisible(true);
		
	}
	
}