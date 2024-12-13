package com.comCast.crm.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
 public int getRandomNumber()
 {
	 Random random=new Random();
	 int ranDomnumber=random.nextInt(10000);
	 return ranDomnumber;
 }
 public String getSystemDateyyyDDMM()
 {
	 Date dateobj=new Date();
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 String date=sdf.format(dateobj);
	 return date;
	 
 }
 
 public String getRequiredDateYYYYDDMM(int days)
 {
	 Date dateobj=new Date();
	 
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");//caps MM gives cuurent month
		
	sim.format(dateobj);
     Calendar cal=sim.getCalendar();
     cal.add(Calendar.DAY_OF_MONTH,days );//use - (minus) for before date
     String requireddate=sim.format(cal.getTime());
     return requireddate;
     
 }
 
}
