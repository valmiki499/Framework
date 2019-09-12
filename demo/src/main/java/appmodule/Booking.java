package appmodule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pageobject.Booking_POM;
import Pageobject.Login_Logout_POM;
import utility.Commonfunction;


public class Booking {
	
	Select sources;
	
	public static void Addmanualbooking(WebDriver driver) throws Exception
	{
		Login_Logout_POM Login=PageFactory.initElements(driver, Login_Logout_POM.class);
		Login.logincredentials("10108", "Test123");
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
			Booking_POM Addbooking=PageFactory.initElements(driver, Booking_POM.class);
			Addbooking.clickonBooking.click();
			Thread.sleep(2000);
			Addbooking.clickaddbooking.click();
			Thread.sleep(2000);
			Addbooking.clickonsource.click();
			Select sources= new Select(Addbooking.selectsourcevalue);
			sources.selectByIndex(1);
			Thread.sleep(2000);
			Addbooking.clickonRoom.click();
			Select room= new Select(Addbooking.selectroomvalue);
			room.selectByIndex(1);
			Thread.sleep(2000);
			Addbooking.clickonRoomcount.click();
			Select roomcount= new Select(Addbooking.selectroomcountvalue);
			roomcount.selectByIndex(1);
			
			Addbooking.clickonNextIcon.click();
			Addbooking.FirstName.sendKeys("valmiki");
			Addbooking.LastName.sendKeys("k");
			Addbooking.Email.sendKeys("valmiki.k@intelegain.com");
			Addbooking.PhomeNo.sendKeys("12345678");
			Addbooking.Country.sendKeys("India");
			Addbooking.state.sendKeys("Maharastra");
			Addbooking.City.sendKeys("Navi Mumbai");
			Addbooking.Postalcode.sendKeys("400705");
			Addbooking.Company.sendKeys("Intelegain");
			Addbooking.Comments.sendKeys("Intelegain");
			
			Addbooking.AddBookingsubmit.click();
			
			
			
			
			System.out.println("Manual Booking added successfully.........");
			
			
			
			



			
			
			
		}
		
	}
}
