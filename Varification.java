//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;


public class Varification extends Frame
{
	JButton sub;
	TextField varify;
	Label l1;
	LoginEvent ml = new LoginEvent(this);
	Varification()
	{
		super("Taxi Frame");
		setLayout(null);
		setBounds(0,0,500,500);
		setBackground(Color.BLUE);
		
		l1 = new Label("Enter The OTP");
		varify = new TextField();
		sub=new JButton("Varify");
		add(l1);
		add(varify);
		add(sub);
		
		l1.setBounds(50,50,200,25);
		varify.setBounds(100,100,100,25);
		sub.setBounds(100,300,250,50);
		sub.addActionListener(ml);
		
		
		
		
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
		Varification  mf = new Varification();
		mf.setVisible(true);
		
	}
	
}