package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
 public String getDataFromPropertiesFile(String key) throws Exception
 {
	 FileInputStream fin=new FileInputStream("./configData/newcommanData.properties");
	 Properties pro=new Properties();
	 pro.load(fin);
	String data= pro.getProperty(key);
	 return data;
	 
 }
}
