//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;

public class LoginFrame extends Frame
{
	JButton loginButton,signin;
	JLabel l1;
	Font f1,f2;
	LoginEvent ml = new LoginEvent(this);
	LoginFrame()
	{
		super("Login Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		signin=new JButton("Login");
		l1 = new JLabel("Welcome to Service Managememt System");
		f1 = new Font("Times",Font.ITALIC,25);
		f2 = new Font("Times",Font.ITALIC,20);
		
		//setContentPane(new JLabel(new ImageIcon("C:\\project.jpg")));
		//setSize(500,500);
		//setVisible(true);
		
		add(signin);
		add(l1);
		l1.setFont(f1);
		signin.setFont(f1);
		signin.setBounds(400,500,150,50);
		l1.setBounds(50,100,500,50);
		
		setBackground(Color.CYAN);
		
		
		
		signin.addActionListener(ml);
		
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
		LoginFrame  mf = new LoginFrame ();
		mf.setVisible(true);
		
	}
	
}