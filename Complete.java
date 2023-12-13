//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;


public class Complete extends Frame
{
	
	Label l1,l2,l3;
	Font f1,f2;
	LoginEvent ml = new LoginEvent(this);
	Complete()
	{
		super("Taxi Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		setBackground(Color.CYAN);
		f1 = new Font("Times",Font.BOLD,45);
		f2 = new Font("Times",Font.BOLD,35);
		l1 = new Label("You will Get the vehcile in 30 Minute");
		l2 = new Label("Thank You");
		l3 = new Label(" ");
		add(l1);
		add(l2);
		add(l3);
		l1.setFont(f2);
		l3.setFont(f2);
		l2.setFont(f1);
		
		l1.setBounds(200,150,600,50);
		l3.setBounds(200,250,600,50);
		l2.setBounds(350,350,300,50);
		
		
		
		
		
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
		Complete  mf = new Complete();
		mf.setVisible(true);
		
	}
	
}