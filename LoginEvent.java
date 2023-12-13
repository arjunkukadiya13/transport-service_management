//set classpath=mail.jar;activation.jar;.;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.AWTEvent.*;
import java.io.File;
import java.util.regex.*;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

public class LoginEvent implements ActionListener
{
	
	LoginPage lp;
	LoginFrame lf;
	TaxiFrame tf;
	TruckFrame tf2;
	MasterFrame mf;
	GetLocation gl;
	Varification vf;
	Complete cm;
	Font fon;
	static String clientName,clientmobileNo,clientEmail;
	
	static int otp,rendomNo,i=5,check=0,getday,r;
	
	
	LoginEvent(LoginPage f)
	{
		this.lp=f;
	}
	LoginEvent(LoginFrame f)
	{
		this.lf=f;
	}
	LoginEvent(TaxiFrame f)
	{
		this.tf=f;
	}
	LoginEvent(TruckFrame f)
	{
		this.tf2=f;
	}
	LoginEvent(MasterFrame f)
	{
		this.mf=f;
	}
	LoginEvent(GetLocation f)
	{
		this.gl=f;
	}
	LoginEvent(Varification f)
	{
		this.vf=f;	
	}
	LoginEvent(Complete f)
	{
		this.cm=f;
	}
	
	public String toString() 
	{
		return this.clientName + "#" + this.clientmobileNo + "#" + this.clientEmail;
	}
	
	LoginEvent(String name, String no, String em) 
	{   
		this.clientName = name;
		this.clientmobileNo = no;
		this.clientEmail = em;
	}
	static String getarea,getcity,rupees;
	public void actionPerformed(ActionEvent e)  
	{		
		if(e.getActionCommand().equals("Login"))
		{
				lp = new LoginPage();
				this.lf.setVisible(false);
				this.lp.setVisible(true);
		}
		
		if(e.getActionCommand().equals("SUBMIT"))
		{
			
			
			
			clientName = this.lp.name.getText();
			clientmobileNo = this.lp.mobileNo.getText();
			clientEmail = this.lp.email.getText();
			System.out.println(clientName);
			System.out.println(clientmobileNo);
			System.out.println(clientEmail);
	
			
			// check Mobile Number
			Pattern p = Pattern.compile("[0-9]{10}");
			Matcher m = p.matcher(clientmobileNo);
			boolean b = m.matches();
			System.out.println(b);
			//Pattern p1 = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9_]+\\.[A-Z]{2,6}$");
			//Matcher m1 = p1.matcher(clientEmail);
			//boolean b1 = m1.matches();
			System.out.println(b);
			// check email 

			
			if(this.lp.name.getText().equals("") || this.lp.name.getText().equals("Enter Name:"))
			{
				//lp = new LoginPage();
				this.lp.name.setText("Enter Name:");
				this.lp.mobileNo.setText(clientmobileNo);
				this.lp.email.setText(clientEmail);
				this.lp.setVisible(true);
			}
			else if(b==false)
			{
				fon = new Font("Times",Font.ITALIC,15);
				//lp = new LoginPage();
				this.lp.name.setText(clientName);
				this.lp.mobileNo.setFont(fon);
				this.lp.mobileNo.setText("Invalid No:");
				this.lp.email.setText(clientEmail);
				this.lp.setVisible(true);
			}
			
			else if(this.lp.email.getText().equals(""))
			{
				//lp = new LoginPage();
				this.lp.name.setText(clientName);
				this.lp.mobileNo.setText(clientmobileNo);
				this.lp.email.setText("Enter Email:");
				this.lp.setVisible(true);
			}
			
			
			
			else
			{
				try
				{
					FileWriter fw = new FileWriter("ClientData.txt",true);
					//Student s = new Student(clientName,clientEmail,clientmobileNo);
					fw.write("\n"+clientName+"#"+clientmobileNo+"#"+clientEmail);
					fw.close();
					
					char ch[] = new char[2000];
					FileReader fr = new FileReader("ClientData.txt");  
					fr.read(ch);                      // reads the data from the txt file
					fr.close();
					
					System.out.print(ch);  //  Prints the data from the txt file
					System.out.println(" ");

					String records = new String(ch);
					String record[] = records.split("\n");
					LoginEvent readfile[] = new LoginEvent[record.length];  //   creating object array  
					
					
					for (int i = 0; i < record.length; i++) 
					{
						String atter[] = record[i].split("#");
						readfile[i] = new LoginEvent(atter[0].trim(), atter[1].trim(), atter[2].trim());
						System.out.println(readfile[i]);
					}
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				mf = new MasterFrame();
				this.mf.setVisible(true);
				this.lp.setVisible(false);
			}
		}
		

		if(e.getActionCommand().equals("Taxi"))
		{
			tf = new TaxiFrame();
			//mf = new MasterFrame();
			this.tf.setVisible(true);
			this.mf.setVisible(false);
		}
		if(e.getActionCommand().equals("Truck"))
		{
			
			tf2 = new TruckFrame();
			mf = new MasterFrame();
			this.tf2.setVisible(true);
			this.mf.setVisible(false);
		}
		if(e.getActionCommand().equals("back"))
		{
			//tf2 = new TruckFrame();
			mf = new MasterFrame();
			this.tf2.setVisible(false);
			this.mf.setVisible(true);
		}
		if(e.getActionCommand().equals("Back"))
		{
			//tf2 = new TruckFrame();
			mf = new MasterFrame();
			this.tf.setVisible(false);
			this.mf.setVisible(true);
		}
		if(e.getActionCommand().equals("Get Taxi"))
		{
			rupees = "Taxi";
			System.out.println(" "+rupees);
			//tf2 = new TruckFrame();
			gl = new GetLocation();
			this.gl.setVisible(true);
			this.tf.setVisible(false);
		}
		if(e.getActionCommand().equals("Boat Haulage") || e.getActionCommand().equals("Logging Trucks") || e.getActionCommand().equals("Fire Truck") || e.getActionCommand().equals("Cement Truck") || e.getActionCommand().equals("Pickup Truck"))
		{
			r = 1;
			rupees = e.getActionCommand();
			//tf2 = new TruckFrame();
			gl = new GetLocation();
			this.gl.setVisible(true);
			this.tf2.setVisible(false);
		}
		
		if(e.getSource()==this.gl.city && (this.gl.city.getSelectedItem()).equals("Ahemdabad"))
		{
			
			if(check==0)
			{
				this.gl.area.addItem("Bhadra");
				this.gl.area.addItem("Ambli");
				this.gl.area.addItem("CG Road");
				this.gl.area.addItem("Bhadaj");
				this.gl.area.addItem("Dantali");
				this.gl.setVisible(true);
			}
			else if(check==2)
			{
				this.gl.area.addItem("Bhadra");
				this.gl.area.addItem("Ambli");
				this.gl.area.addItem("CG Road");
				this.gl.area.addItem("Bhadaj");
				this.gl.area.addItem("Dantali");
				this.gl.area.removeItem("Kalavad-road");
				this.gl.area.removeItem("Bhaktinagar");
				this.gl.area.removeItem("SantKabir-Road");
				this.gl.area.removeItem("Aji-Dam");
				this.gl.area.removeItem("Gondal-road");
				this.gl.setVisible(true);
			}
			else if(check==3)
			{
				this.gl.area.addItem("Bhadra");
				this.gl.area.addItem("Ambli");
				this.gl.area.addItem("CG Road");
				this.gl.area.addItem("Bhadaj");
				this.gl.area.addItem("Dantali");
				this.gl.area.removeItem("Atkot");
				this.gl.area.removeItem("Ajmer");
				this.gl.area.removeItem("Bandhali");
				this.gl.area.removeItem("Bhadla");
				this.gl.area.removeItem("Dadli");
				this.gl.setVisible(true);
			}
			else if(check==4)
			{
				this.gl.area.addItem("Bhadra");
				this.gl.area.addItem("Ambli");
				this.gl.area.addItem("CG Road");
				this.gl.area.addItem("Bhadaj");
				this.gl.area.addItem("Dantali");
				this.gl.area.removeItem("Satyam Colony");
				this.gl.area.removeItem("Yogeswar Dham Colony");
				this.gl.area.removeItem("Kadiawad");
				this.gl.area.removeItem("Kaushal Nagar");
				this.gl.area.removeItem("Limda Lane");
				this.gl.setVisible(true);
			}
			else if(check==5)
			{
				this.gl.area.addItem("Bhadra");
				this.gl.area.addItem("Ambli");
				this.gl.area.addItem("CG Road");
				this.gl.area.addItem("Bhadaj");
				this.gl.area.addItem("Dantali");
				this.gl.area.removeItem("Ciramic city");
				this.gl.area.removeItem("vakaner");
				this.gl.area.removeItem("Sakat Sanada");
				this.gl.area.removeItem("Lalpur");
				this.gl.area.removeItem("Soradi");
				this.gl.setVisible(true);
			}
			check=1;
			
		}
		if(e.getSource()==this.gl.city && (this.gl.city.getSelectedItem()).equals("Rajkot"))
		{
			
			if(check==0)
			{
				this.gl.area.addItem("Kalavad-road");
				this.gl.area.addItem("Bhaktinagar");
				this.gl.area.addItem("SantKabir-Road");
				this.gl.area.addItem("Aji-Dam");
				this.gl.area.addItem("Gondal-road");
				this.gl.setVisible(true);
			}
			else if(check==1)
			{
				this.gl.area.addItem("Kalavad-road");
				this.gl.area.addItem("Bhaktinagar");
				this.gl.area.addItem("SantKabir-Road");
				this.gl.area.addItem("Aji-Dam");
				this.gl.area.addItem("Gondal-road");
				this.gl.area.removeItem("Bhadra");
				this.gl.area.removeItem("Ambli");
				this.gl.area.removeItem("CG Road");
				this.gl.area.removeItem("Bhadaj");
				this.gl.area.removeItem("Dantali");
				this.gl.setVisible(true);
			}
			else if(check==3)
			{
				this.gl.area.addItem("Kalavad-road");
				this.gl.area.addItem("Bhaktinagar");
				this.gl.area.addItem("SantKabir-Road");
				this.gl.area.addItem("Aji-Dam");
				this.gl.area.addItem("Gondal-road");
				this.gl.area.removeItem("Atkot");
				this.gl.area.removeItem("Ajmer");
				this.gl.area.removeItem("Bandhali");
				this.gl.area.removeItem("Bhadla");
				this.gl.area.removeItem("Dadli");
				this.gl.setVisible(true);
			}
			else if(check==4)
			{
				this.gl.area.addItem("Kalavad-road");
				this.gl.area.addItem("Bhaktinagar");
				this.gl.area.addItem("SantKabir-Road");
				this.gl.area.addItem("Aji-Dam");
				this.gl.area.addItem("Gondal-road");
				this.gl.area.removeItem("Satyam Colony");
				this.gl.area.removeItem("Yogeswar Dham Colony");
				this.gl.area.removeItem("Kadiawad");
				this.gl.area.removeItem("Kaushal Nagar");
				this.gl.area.removeItem("Limda Lane");
				this.gl.setVisible(true);
			}
			else if(check==5)
			{
				this.gl.area.addItem("Kalavad-road");
				this.gl.area.addItem("Bhaktinagar");
				this.gl.area.addItem("SantKabir-Road");
				this.gl.area.addItem("Aji-Dam");
				this.gl.area.addItem("Gondal-road");
				this.gl.area.removeItem("Ciramic city");
				this.gl.area.removeItem("vakaner");
				this.gl.area.removeItem("Sakat Sanada");
				this.gl.area.removeItem("Lalpur");
				this.gl.area.removeItem("Soradi");
				this.gl.setVisible(true);
			}
			check =2;
			
		}
		if(e.getSource()==this.gl.city && (this.gl.city.getSelectedItem()).equals("Jasdan"))
		{
			
			if(check==0)
			{
				this.gl.area.addItem("Atkot");
				this.gl.area.addItem("Ajmer");
				this.gl.area.addItem("Bandhali");
				this.gl.area.addItem("Bhadla");
				this.gl.area.addItem("Dadli");
				this.gl.setVisible(true);
			}
			else if(check==1)
			{
				this.gl.area.addItem("Atkot");
				this.gl.area.addItem("Ajmer");
				this.gl.area.addItem("Bandhali");
				this.gl.area.addItem("Bhadla");
				this.gl.area.addItem("Dadli");
				this.gl.area.removeItem("Bhadra");
				this.gl.area.removeItem("Ambli");
				this.gl.area.removeItem("CG Road");
				this.gl.area.removeItem("Bhadaj");
				this.gl.area.removeItem("Dantali");
				this.gl.setVisible(true);
			}
			else if(check==2)
			{
				this.gl.area.addItem("Atkot");
				this.gl.area.addItem("Ajmer");
				this.gl.area.addItem("Bandhali");
				this.gl.area.addItem("Bhadla");
				this.gl.area.addItem("Dadli");
				this.gl.area.removeItem("Kalavad-road");
				this.gl.area.removeItem("Bhaktinagar");
				this.gl.area.removeItem("SantKabir-Road");
				this.gl.area.removeItem("Aji-Dam");
				this.gl.area.removeItem("Gondal-road");
				this.gl.setVisible(true);
			}
			else if(check==4)
			{
				this.gl.area.addItem("Atkot");
				this.gl.area.addItem("Ajmer");
				this.gl.area.addItem("Bandhali");
				this.gl.area.addItem("Bhadla");
				this.gl.area.addItem("Dadli");
				this.gl.area.removeItem("Satyam Colony");
				this.gl.area.removeItem("Yogeswar Dham Colony");
				this.gl.area.removeItem("Kadiawad");
				this.gl.area.removeItem("Kaushal Nagar");
				this.gl.area.removeItem("Limda Lane");
				this.gl.setVisible(true);
			}
			else if(check==5)
			{
				this.gl.area.addItem("Atkot");
				this.gl.area.addItem("Ajmer");
				this.gl.area.addItem("Bandhali");
				this.gl.area.addItem("Bhadla");
				this.gl.area.addItem("Dadli");
				this.gl.area.removeItem("Ciramic city");
				this.gl.area.removeItem("vakaner");
				this.gl.area.removeItem("Sakat Sanada");
				this.gl.area.removeItem("Lalpur");
				this.gl.area.removeItem("Soradi");
				this.gl.setVisible(true);
			}
			check =3;
		}
		if(e.getSource()==this.gl.city && (this.gl.city.getSelectedItem()).equals("Jamnagar"))
		{
			
			if(check==0)
			{
				this.gl.area.addItem("Satyam Colony");
				this.gl.area.addItem("Yogeswar Dham Colony");
				this.gl.area.addItem("Kadiawad");
				this.gl.area.addItem("Kaushal Nagar");
				this.gl.area.addItem("Limda Lane");
				this.gl.setVisible(true);
			}
			else if(check==1)
			{
				this.gl.area.addItem("Satyam Colony");
				this.gl.area.addItem("Yogeswar Dham Colony");
				this.gl.area.addItem("Kadiawad");
				this.gl.area.addItem("Kaushal Nagar");
				this.gl.area.addItem("Limda Lane");
				this.gl.area.removeItem("Bhadra");
				this.gl.area.removeItem("Ambli");
				this.gl.area.removeItem("CG Road");
				this.gl.area.removeItem("Bhadaj");
				this.gl.area.removeItem("Dantali");
				this.gl.setVisible(true);
			}
			else if(check==2)
			{
				this.gl.area.addItem("Satyam Colony");
				this.gl.area.addItem("Yogeswar Dham Colony");
				this.gl.area.addItem("Kadiawad");
				this.gl.area.addItem("Kaushal Nagar");
				this.gl.area.addItem("Limda Lane");
				this.gl.area.removeItem("Kalavad-road");
				this.gl.area.removeItem("Bhaktinagar");
				this.gl.area.removeItem("SantKabir-Road");
				this.gl.area.removeItem("Aji-Dam");
				this.gl.area.removeItem("Gondal-road");
				this.gl.setVisible(true);
			}
			else if(check==3)
			{
				this.gl.area.addItem("Satyam Colony");
				this.gl.area.addItem("Yogeswar Dham Colony");
				this.gl.area.addItem("Kadiawad");
				this.gl.area.addItem("Kaushal Nagar");
				this.gl.area.addItem("Limda Lane");
				this.gl.area.removeItem("Atkot");
				this.gl.area.removeItem("Ajmer");
				this.gl.area.removeItem("Bandhali");
				this.gl.area.removeItem("Bhadla");
				this.gl.area.removeItem("Dadli");
				this.gl.setVisible(true);
			}
			else if(check==5)
			{
				this.gl.area.addItem("Satyam Colony");
				this.gl.area.addItem("Yogeswar Dham Colony");
				this.gl.area.addItem("Kadiawad");
				this.gl.area.addItem("Kaushal Nagar");
				this.gl.area.addItem("Limda Lane");
				this.gl.area.removeItem("Ciramic city");
				this.gl.area.removeItem("vakaner");
				this.gl.area.removeItem("Sakat Sanada");
				this.gl.area.removeItem("Lalpur");
				this.gl.area.removeItem("Soradi");
				this.gl.setVisible(true);
			}
			check=4;
			
				
		}
		if(e.getSource()==this.gl.city && (this.gl.city.getSelectedItem()).equals("Morbi"))
		{
			
			if(check==0)
			{
				this.gl.area.addItem("Ciramic city");
				this.gl.area.addItem("vakaner");
				this.gl.area.addItem("Sakat Sanada");
				this.gl.area.addItem("Lalpur");
				this.gl.area.addItem("Soradi");
				this.gl.setVisible(true);
			}
			else if(check==1)
			{
				this.gl.area.addItem("Ciramic city");
				this.gl.area.addItem("vakaner");
				this.gl.area.addItem("Sakat Sanada");
				this.gl.area.addItem("Lalpur");
				this.gl.area.addItem("Soradi");
				this.gl.area.removeItem("Bhadra");
				this.gl.area.removeItem("Ambli");
				this.gl.area.removeItem("CG Road");
				this.gl.area.removeItem("Bhadaj");
				this.gl.area.removeItem("Dantali");
				this.gl.setVisible(true);
			}
			else if(check==2)
			{
				this.gl.area.addItem("Ciramic city");
				this.gl.area.addItem("vakaner");
				this.gl.area.addItem("Sakat Sanada");
				this.gl.area.addItem("Lalpur");
				this.gl.area.addItem("Soradi");
				this.gl.area.removeItem("Kalavad-road");
				this.gl.area.removeItem("Bhaktinagar");
				this.gl.area.removeItem("SantKabir-Road");
				this.gl.area.removeItem("Aji-Dam");
				this.gl.area.removeItem("Gondal-road");
				this.gl.setVisible(true);
			}
			else if(check==3)
			{
				this.gl.area.addItem("Ciramic city");
				this.gl.area.addItem("vakaner");
				this.gl.area.addItem("Sakat Sanada");
				this.gl.area.addItem("Lalpur");
				this.gl.area.addItem("Soradi");
				this.gl.area.removeItem("Atkot");
				this.gl.area.removeItem("Ajmer");
				this.gl.area.removeItem("Bandhali");
				this.gl.area.removeItem("Bhadla");
				this.gl.area.removeItem("Dadli");
				this.gl.setVisible(true);
			}
			else if(check==4)
			{
				this.gl.area.addItem("Ciramic city");
				this.gl.area.addItem("vakaner");
				this.gl.area.addItem("Sakat Sanada");
				this.gl.area.addItem("Lalpur");
				this.gl.area.addItem("Soradi");
				this.gl.area.removeItem("Satyam Colony");
				this.gl.area.removeItem("Yogeswar Dham Colony");
				this.gl.area.removeItem("Kadiawad");
				this.gl.area.removeItem("Kaushal Nagar");
				this.gl.area.removeItem("Limda Lane");
				this.gl.setVisible(true);
			}
			check=5;
			
		}
		
		if(e.getActionCommand().equals("save"))
		{
				getcity = this.gl.city.getSelectedItem().toString();
				getarea = this.gl.area.getSelectedItem().toString();
				getday = Integer.parseInt(this.gl.days.getSelectedItem().toString());
				System.out.println(getday);
				System.out.println(" "+getarea);
				System.out.println(" "+getcity);
				if(rupees.equals("Taxi"))
				{
					try
					{	
						FileWriter fw = new FileWriter(clientName+".txt");
						fw.write("Name:"+clientName+"\n"+"Mobile No:"+clientmobileNo+"\nEmail:"+clientEmail+"\nVehicle :Taxi "+"\nYou are odered the taxi at the place "+getcity +","+getarea+"\nYour charge is "+(getday*1500));
						fw.close();
					}
					catch(Exception f)
					{
						System.out.println(f);
					}
					String host="smtp.gmail.com";  
			final String user="arjunkukadiya606@gmail.com";//change accordingly  
			final String password="rqeryzztqenymrcd";//change accordingly  
			String to=clientEmail;//change accordingly  
	  
			//Get the session object  
			Properties props = new Properties();  
			props.put("mail.smtp.host",host);  
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
		
		 
			Session session = Session.getDefaultInstance(props,  
					new javax.mail.Authenticator() 
					{  
						protected PasswordAuthentication getPasswordAuthentication() {  
						return new PasswordAuthentication(user,password);  
					}  
				});  
	  
			//Compose the message  
			try 
			{  
				MimeMessage message = new MimeMessage(session);  
				message.setFrom(new InternetAddress(user));  
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				message.setSubject("Transport Service Management");  
				message.setText("Name:"+clientName+"\n"+"Mobile No:"+clientmobileNo+"\nEmail:"+clientEmail+"\nVehicle :"+rupees+"\nYou are odered the Taxi at the place "+getcity +","+getarea+"\nYour charge is "+(getday*5000));  
				//Using HTML
				//message.setContent("Thanks for Learning <b>JAVA</b>");
				//send the message  
				Transport.send(message);  
				System.out.println("message sent successfully...");  
   
				} 
			catch (MessagingException er) 
			{
				er.printStackTrace();
			}  
					cm = new Complete();
					this.cm.l3.setText("Your charge will be "+(getday*1500));
					this.gl.setVisible(false);
					this.cm.setVisible(true);
				}
				if(r==1)
				{
					try
					{	
						FileWriter fw = new FileWriter(clientName+".txt");
						fw.write("Name:"+clientName+"\n"+"Mobile No:"+clientmobileNo+"\nEmail:"+clientEmail+"\nVehicle :"+rupees+"\nYou are odered the truck at the place "+getcity +","+getarea+"\nYour charge is "+(getday*5000));
						fw.close();
					}
					catch(Exception f)
					{
						System.out.println(f);
					}
					String host="smtp.gmail.com";  
			final String user="arjunkukadiya606@gmail.com";//change accordingly  
			final String password="rqeryzztqenymrcd";//change accordingly  
			String to=clientEmail;//change accordingly  
	  
			//Get the session object  
			Properties props = new Properties();  
			props.put("mail.smtp.host",host);  
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
		
		 
			Session session = Session.getDefaultInstance(props,  
					new javax.mail.Authenticator() 
					{  
						protected PasswordAuthentication getPasswordAuthentication() {  
						return new PasswordAuthentication(user,password);  
					}  
				});  
	  
			//Compose the message  
			try 
			{  
				MimeMessage message = new MimeMessage(session);  
				message.setFrom(new InternetAddress(user));  
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				message.setSubject("Transport Service Management");  
				message.setText("Name:"+clientName+"\n"+"Mobile No:"+clientmobileNo+"\nEmail:"+clientEmail+"\nVehicle :"+rupees+"\nYou are odered the truck at the place "+getcity +","+getarea+"\nYour charge is "+(getday*5000));  
				//Using HTML
				//message.setContent("Thanks for Learning <b>JAVA</b>");
				//send the message  
				Transport.send(message);  
				System.out.println("message sent successfully...");  
   
				} 
			catch (MessagingException er) 
			{
				er.printStackTrace();
			}  
					cm = new Complete();
					this.cm.l3.setText("Your charge will be "+(getday*5000));
					this.gl.setVisible(false);
					this.cm.setVisible(true);
			}
				
				
			
		}
	}
}

