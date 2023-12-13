//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;


public class LoginPage extends JFrame
{
	
	JButton submitButton;
	TextField name,mobileNo,email;
	Label forName,forMo,forEmail;
	Font f1;
	LoginEvent ml = new LoginEvent(this);
	LoginPage()
	{
		super("LoginPage Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		name = new TextField();
		mobileNo = new TextField();
		email = new TextField();
		f1 = new Font("Times",Font.BOLD,25);
		
		forName = new Label("Enter the Name:");
		forMo = new Label("Enter the Mobile no:");
		forEmail = new Label("Enter the Email address:");
		
		submitButton = new JButton("SUBMIT");
		
		add(name);
		add(mobileNo);
		add(email);
		forName.setFont(f1);
		forMo.setFont(f1);
		forEmail.setFont(f1);
		name.setFont(f1);
		mobileNo.setFont(f1);
		email.setFont(f1);
		add(forName);
		add(forMo);
		add(forEmail);
		submitButton.setFont(f1);
		add(submitButton);
		
		forName.setBounds(50,50,400,50);
		forMo.setBounds(50,150,400,50);
		forEmail.setBounds(50,250,400,50);
		
		name.setBounds(450,50,400,50);
		mobileNo.setBounds(450,150,400,50);
		email.setBounds(450,250,400,50);
		
		submitButton.setBounds(450,550,300,50);
		submitButton.addActionListener(ml);
		
		
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
		LoginPage  mf = new LoginPage();
		mf.setVisible(true);
		
	}
	
}
