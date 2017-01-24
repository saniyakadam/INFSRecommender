package com.infs740.mail;

import java.util.TimerTask;
import javaConstants.Constants;
 
public class EmailSender extends TimerTask
{
 
	public void run()
	{
 
                GMailServer sender = new GMailServer(Constants.setFrom, Constants.setPassword);
 
	            try {
			    sender.sendMail("Behind The Mirror",Constants.message,Constants.setFrom,Constants.emailTO);
			}
                   catch (Exception e) {
			     e.printStackTrace();
			}  
 
				System.out.println("Email Sent Succesfully...");
 
	        }
}
