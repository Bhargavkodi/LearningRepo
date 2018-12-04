package com.beginningdeveloper.maven.NewProject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import NewThings.initialise;

public class DateNew extends initialise{
	static Logger log = Logger.getLogger(DateNew.class.getName());

	public static void main(String[] args) throws InterruptedException {
		
		initialise.browserLaunch();
		Thread.sleep(6000);
		
		initialise.HandleTabs("0");
		Thread.sleep(1000);
		initialise.HandleTabs("1");
		Thread.sleep(1000);
		initialise.HandleTabs("2");
		Thread.sleep(1000);
		initialise.HandleTabs("3");
		Thread.sleep(1000);
		initialise.HandleTabs("4");
		
		
//		sendEmail.sendSimpleEmail("mroads.vnr@gmail.com");
//		
//		initialise.gmail_Login();
//		
//		Thread.sleep(3000);
//		
//		
//		initialise.buttonClick(By.xpath("//div[@class='y6']//span[contains(text(),'Interview scheduled for the position of')]"));
//		
//		Thread.sleep(3000);
//		
//		initialise.buttonClick(By.xpath("//*[@act=\"10\"][@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA T-I-Zf-aw2\"]"));
		
		
	}
	
	

}
