package com.comCast.crm.generic.fileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility
{
 public String getDataFromJsonFile(String key) throws Exception
 {
	 FileReader file=new FileReader("./configData/commanData.json");
	 JSONParser parser=new JSONParser();
	 Object obj=parser.parse(file);
	 JSONObject map =(JSONObject)obj;
	//String data= map.get(key).toString();
	String data=(String)map.get(key);
	 return data;
 }
}
