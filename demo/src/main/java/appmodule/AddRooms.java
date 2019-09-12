package appmodule;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pageobject.AddRooms_POM;
import Pageobject.Login_Logout_POM;
import utility.Commonfunction;
import utility.Excelunit;

public class AddRooms {
	
	private static Logger Log = Logger.getLogger(AddRooms.class.getName());
	
	
	public static void Addroomaction(WebDriver driver) throws Exception
	{
		DOMConfigurator.configure("Log4j.xml");
		
		Login_Logout_POM Login=PageFactory.initElements(driver, Login_Logout_POM.class);
		Log.info("Login details called");
		System.out.println(Signup.temppropertyID);
		System.out.println(Signup.temppassword);
		Login.logincredentials(Signup.temppropertyID, Signup.temppassword);
		//Login.logincredentials("10112", "Test123");
		
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
        Log.info("successfully Logged in");
        
		AddRooms_POM AR=PageFactory.initElements(driver, AddRooms_POM.class);
		Log.info("Initiated PageFactory");
		Thread.sleep(3000);
		//Commonfunction.Webdriverwait_forall(driver, AR.clickonsetup);
		
		AR.clickonsetup.click();
		Log.info("Click on Setup menu");
		//Commonfunction.Webdriverwait_forall(driver, AR.clickonproperty);
		Thread.sleep(3000);
		AR.clickonproperty.click();
		Log.info("Click on property info menu");
		
		
		String text = AR.readtxtNoOfRooms.getAttribute("value");
		Log.info("Reading No of Room value");
		System.out.println(text);
		Log.info("printing No. of Room count");
		int number = Integer.parseInt(text);
		
		Log.info("parsing Text to integer value" + number);
		System.out.println(number);
		Log.info("printing converted value on console");
		((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
		Thread.sleep(3000);
		//Commonfunction.Webdriverwait_forall(driver, AR.clickonRoom);
		AR.clickonRoom.click();
		Log.info("Clicked on Room menu under setup menu");
		for(int i=1;i<=number;i++)
		{
			Log.info("For loop applied with no. of Room count");
			Thread.sleep(3000);
			
			//Commonfunction.Webdriverwait_forall(driver, AR.clickonaddRoomplusicon);
			AR.clickonaddRoomplusicon.click();
			Log.info("Clicked on Add Room Icon");
			Excelunit.configexcel(Excelunit.excelpath, "Define Rooms");
			
			//#Room info
			
			String excelvalroomname=Excelunit.Getexceldata(i, 0);
			System.out.println(excelvalroomname);
			String excelvalpplinrate=Excelunit.Getexceldata(i, 1);
			System.out.println(excelvalpplinrate);
			String excelvalmaxoccu=Excelunit.Getexceldata(i, 2);
			System.out.println(excelvalmaxoccu);
			String excelvalextraadult=Excelunit.Getexceldata(i, 3);
			System.out.println(excelvalextraadult);
			String excelvalextchild=Excelunit.Getexceldata(i, 4);
			System.out.println(excelvalextchild);
			String excelvalAvailthre=Excelunit.Getexceldata(i, 5);
			System.out.println(excelvalAvailthre);
			String excelvaldescript=Excelunit.Getexceldata(i, 6);
			System.out.println(excelvaldescript);
			
			AR.Roominfo(excelvalroomname, excelvalpplinrate, excelvalmaxoccu, excelvalextraadult, excelvalextchild, excelvalAvailthre, excelvaldescript);
			Log.info("Inserted Roominfo details");
			//Minstay
			
			String excelvalrate=Excelunit.Getexceldata(i, 7);
			System.out.println(excelvalrate);
			AR.WeeklyDEFAULTrate(excelvalrate, excelvalrate, excelvalrate, excelvalrate, excelvalrate, excelvalrate, excelvalrate);
			Log.info("Inserted Weekly Room Rate");
			
			String excelvalminstay=Excelunit.Getexceldata(i, 8);
			System.out.println(excelvalminstay);
			
			AR.WeeklyDEFAULTMinstay(excelvalminstay, excelvalminstay, excelvalminstay, excelvalminstay, excelvalminstay, excelvalminstay, excelvalminstay);
			Log.info("Inserted Weekly Room Min stay");
			
			String excelvalavail=Excelunit.Getexceldata(i, 9);
			System.out.println(excelvalavail);
			AR.WeeklyDEFAULTAvailability(excelvalavail, excelvalavail, excelvalavail, excelvalavail, excelvalavail, excelvalavail, excelvalavail);
			Log.info("Inserted Weekly Room Availability");
			if(i==1 || i==3)
			{
				Log.info("select stop sell, closed on arrival and closed on departue..if value is 1 or 3 ");
				AR.strclickonstopsell_1.click();
				AR.strclickonstopsell_5.click();
				
				AR.strchkClosedOnArrival_1.click();
				AR.strchkClosedOnArrival_5.click();
				
				AR.strchkClosedOnDeparture_1.click();
				AR.strchkClosedOnDeparture_5.click();
							
			}
			else
			{
				Log.info("select stop sell, closed on arrival and closed on departue..if value is not 1 or 3 ");
				AR.strclickonstopsell_0.click();
				AR.strclickonstopsell_3.click();
				
				AR.strchkClosedOnArrival_0.click();
				AR.strchkClosedOnArrival_3.click();
				
				AR.strchkClosedOnDeparture_0.click();
				AR.strchkClosedOnDeparture_3.click();
			}
			
			AR.strbedconfig.click();
			Log.info("Clicked on bed config dropdown");
			String excelvalsetbeddrpvalue=Excelunit.Getexceldata(i, 10);
			System.out.println(excelvalsetbeddrpvalue);
			Log.info("Read bed config value from excel");
			
			Select dropval=new Select(AR.strdrpRoomBedConfigvalues);
			List <WebElement> elementcount=dropval.getOptions();
			int isize=elementcount.size();
			Log.info("For loop to check excel match with drop-down valie if yes the select it");
			for(int j= 0;j <isize;j++)
			{
				String svalue=dropval.getOptions().get(j).getText();
				System.out.println(svalue);
				
				//Log.info("printing all Bed config drop down values");
				
				if(excelvalsetbeddrpvalue.equalsIgnoreCase(svalue))
					//Log.info("bed config value match with excek data");
				{
					dropval.selectByIndex(j);
					//Log.info("bed config value selected as per excel data");
					break;
				}
				
			}
			
			String excelvalsetvalue=Excelunit.Getexceldata(i, 11);
			System.out.println(excelvalsetvalue);
			Thread.sleep(3000);
			AR.setbedconfirnadamenities(excelvalsetvalue);
			Log.info("Bed value added and Amenities selected");
			
			
			AR.clickonroomsavebutton.click();
			
			Thread.sleep(3000);
			AR.confirmsaveroombutton.click();
			
			
					
			
			
		}
		
		
		}
		
	}

}
