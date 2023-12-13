//package servicemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.Color.*;


public class TruckFrame extends JFrame
{
	
	JButton b,bt1,bt2,bt3,bt4,bt5;
	Label l1;
	Font f1,f2;
	LoginEvent ml = new LoginEvent(this);
	TruckFrame()
	{
		super("Truck Frame");
		setLayout(null);
		setBounds(0,0,1000,800);
		setContentPane(new JLabel(new ImageIcon("C:\\tr1.jpg")));
		setSize(1000,800);
		setVisible(true);
		
		l1 = new Label("Which kind of truck you want");
		b = new JButton("back");
		bt1 = new JButton("Pickup Truck");
		bt2 = new JButton("Cement Truck");
		bt3 = new JButton("Fire Truck");
		bt4 = new JButton("Logging Trucks");
		bt5 = new JButton("Boat Haulage");
		
		
		f1 = new Font("Times",Font.BOLD,25);
		f2 = new Font("Times",Font.BOLD,20);
		
		add(l1);
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		add(b);
		
		l1.setFont(f1);
		bt1.setFont(f2);
		bt2.setFont(f2);
		bt3.setFont(f2);
		bt4.setFont(f2);
		bt5.setFont(f2);
		b.setFont(f2);
		
		
		bt1.setBounds(300,150,400,50);
		bt2.setBounds(300,225,400,50);
		bt3.setBounds(300,300,400,50);
		bt4.setBounds(300,375,400,50);
		bt5.setBounds(300,450,400,50);
		l1.setBounds(300,50,350,50);
		b.setBounds(350,575,300,50);
		b.setBackground(Color.RED);
		setBackground(Color.CYAN);
		
		b.addActionListener(ml);
		bt1.addActionListener(ml);
		bt2.addActionListener(ml);
		bt3.addActionListener(ml);
		bt4.addActionListener(ml);
		bt5.addActionListener(ml);

		
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
		TruckFrame  mf = new TruckFrame();
		//mf.setVisible(true);
		
	}
	
}