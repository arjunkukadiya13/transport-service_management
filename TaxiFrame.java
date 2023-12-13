//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;

public class TaxiFrame extends JFrame
{
	JButton b1,b2;
	
	Font f1;
	LoginEvent ml = new LoginEvent(this);
	TaxiFrame()
	{
		super("Taxi Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		setContentPane(new JLabel(new ImageIcon("C:\\tx1.jpg")));
		setSize(1000,800);
		setVisible(true);
		b1 = new JButton("Get Taxi");
		b2 = new JButton("Back");
		
		f1 = new Font("Times",Font.ITALIC,25);
		
		add(b1);
		add(b2);
		
		
		b1.setFont(f1);
		b2.setFont(f1);
		b1.setBounds(400,500,150,50);
		b2.setBounds(400,600,150,50);
		
		
		setBackground(Color.CYAN);
		
		
		
		b1.addActionListener(ml);
		b2.addActionListener(ml);
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					dispose();
				}
			});
	}
	public static void main(String s[])
	{
		TaxiFrame  mf = new TaxiFrame();
		mf.setVisible(true);
		
	}
	
}