package com.goair.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public Properties ReadAllObjects() throws IOException
	{
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src/test/resources\\object.properties");
		obj.load(objfile);
		return obj;
	}
}
