package appmodule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pageobject.Connection_POM;
import Pageobject.Login_Logout_POM;
import utility.Commonfunction;

public class Connection {
	
	WebDriver driver;
	@Test
	public static void connection(WebDriver driver) throws Exception
	{
	
		Login_Logout_POM Login=PageFactory.initElements(driver, Login_Logout_POM.class);
		Login.logincredentials(Signup.temppropertyID, Signup.temppassword);
		//Login.logincredentials("10108", "Test123");
		Thread.sleep(3000);
		
		if(Commonfunction.isAlertPresent(driver))
		{
			Alert art=driver.switchTo().alert();
			String alertText = art.getText();
			System.out.println(alertText +"Occured.......driver closed");
			art.accept();
			driver.close();
		}
		
		else
		{
		Connection_POM conn=PageFactory.initElements(driver, Connection_POM.class);
		conn.clickonconnection.click();
		String connectedchannelname;
		List<String> list = new ArrayList<String>();
		//String[] alphabet = new String[]{"Book Now", "Booking.com", "Lido"};
		List<WebElement> isPresent=driver.findElements(By.xpath("//div[@class='connections_sec']"));
		int size1=isPresent.size();
		System.out.println(size1);
		if(size1!=0)
		{
			System.out.println("channel connected");
			try{
				for(int i=1;i<=size1;i++)
					{
					connectedchannelname= driver.findElement(By.xpath("//*[@id='dvMain2']/div/div/div["+i+"]/div[1]/div[1]/div[1]/h3")).getText();
					//System.out.println("Connected channel is  " + connectedchannelname);
					
					 System.out.println(connectedchannelname);
					 list.add(connectedchannelname);
					
					}
				
				
				}
			catch(Exception e)
				{
					System.out.println(e);
					File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
					FileUtils. copyFile(src, new File("D:/valmiki/Java"+ System. currentTimeMillis()+".png")); 
				
				}
			
			if(!list.contains("Book Now"))
			{
				System.out.println("Book Now not present");
				Channelconnection.booknow(driver);
			}
			
			if(!list.contains("Booking.com"))
			{
				System.out.println("Booking.com not present");
				Channelconnection.bookingcom(driver);
			}
			if(!list.contains("Hotel Network"))
			{
				System.out.println("Hotel Network not present");
				Channelconnection.Hotelnetworkchannel(driver);
			}
			
			if(!list.contains("Lido"))
				{
					System.out.println("Lido not present");
					Channelconnection.Lidochannel(driver);
				}
			if(!list.contains("Expedia"))
			{
				System.out.println("Lido not present");
				Channelconnection.Expediachannel(driver);
			}
			
			
			
		}
		else
			{
					System.out.println("No channel connected");
					Channelconnection.booknow(driver);
					Channelconnection.bookingcom(driver);
					Channelconnection.Hotelnetworkchannel(driver);
					Channelconnection.Lidochannel(driver);
					Channelconnection.Expediachannel(driver);
			}
		

		
		
			}
		}
	}

