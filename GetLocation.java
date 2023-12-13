import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.Color.*;
import javax.swing.JComponent.*;

public class GetLocation extends Frame
{
	JComboBox city,area,days;
	JButton save;
	Font f1;
	LoginEvent	ml = new LoginEvent(this);
	GetLocation()
	{
		super("Result");
		setLayout(new FlowLayout());
		setBounds(0,0,1000,800);
		
		f1 = new Font("Times",Font.BOLD,25);
		
		String[] cityName = {"City","Rajkot","Ahemdabad","Morbi","Jasdan","Jamnagar"};
		String[] cityarea = {"area"};
		String[] day = {"days","1","2","3","4","5","6","7","8","9","10"};
		city = new JComboBox(cityName);
		area = new JComboBox(cityarea);
		days = new JComboBox(day);
		save = new JButton("save");
		
		add(city);
		add(area);
		add(days);
		add(save);
		city.setFont(f1);
		days.setFont(f1);
		area.setFont(f1);
		save.setFont(f1);
		
		
		save.setBounds(200,400,150,50);
		setBackground(Color.DARK_GRAY);
		city.addActionListener(ml);
		area.addActionListener(ml);
		days.addActionListener(ml);
		save.addActionListener(ml);
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					dispose();
				}
			});
	}
	public static void main(String args[])
	{
		GetLocation mf = new GetLocation();
		mf.setVisible(true);
			
	}
}