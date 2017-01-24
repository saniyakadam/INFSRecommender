package com.infs740.mail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetPropertiesFile {
  public void setProps(String id, String time, String user, String message) {

	Properties prop = new Properties();
	OutputStream output = null;
		try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		prop.setProperty("setFrom", "behindthemirrorinfs740@gmail.com");
		prop.setProperty("setPassword", "INFS740DB");
		prop.setProperty("timetoquery", time);
		prop.setProperty("delay", "2s");
		prop.setProperty("emailTO", id);
		prop.setProperty("message", message);

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
		DBScheduler dbs = new DBScheduler();
		try {
			dbs.callScheduler();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

  }
}
