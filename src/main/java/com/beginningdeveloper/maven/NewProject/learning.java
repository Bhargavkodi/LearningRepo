package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.learning.pages.login_Page;

public class learning {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		int mail = 20;
		
		for(int i=1;i<=mail;i++){
			String Email = "panna" + i+ "@yopmail.com";
			System.out.println(Email);
			}
		//	String x = XML_Read.getData();
		//	System.out.println(x);
		//XML_Read.getData();
		
	//	DateFormat date = new SimpleDateFormat("hh:mm aa");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm aa");
		String a = df.format(new Date()).toString();
		System.out.println(a);
		
		String[] arrOfStr = a.split("\\s"); 
		 System.out.println(arrOfStr[0]);
		 System.out.println(arrOfStr[1]+" "+arrOfStr[2]);
		  
        for (String b : arrOfStr) 
            System.out.println(b); 

		
		
		
			
		}
		
		}

	


