package com.comCast.crm.vendortest;

import java.util.Date;

public class captureTimeStamp 
{
 public static void main(String[] args)
 {
	 String time=new Date().toString().replace(" ", "_").replace(":"," ");
	 System.out.println(time.replace(" ", "_").replace(":"," "));
 }
}
