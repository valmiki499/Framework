package appmodule;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pageobject.Login_Logout_POM;
import utility.Commonfunction;
import utility.Excelunit;

public class Login_Logout {
	
	
	public static void loginandlogoutaction(WebDriver driver) throws Exception
	{
		//TC_001 To check Login functionality with valid credentials
		Excelunit.configexcel(Excelunit.excelpath, "Login and logout");
		String userIDandpassword=Excelunit.Getexceldata(1, 4);
		System.out.println(userIDandpassword);
		String userID= userIDandpassword.substring(9,14);
		System.out.println(userID);
		String password= userIDandpassword.substring(24,31);
		System.out.println(password);
		
		Login_Logout_POM obj_ll=PageFactory.initElements(driver, Login_Logout_POM.class);
		obj_ll.logincredentials(userID, password);	
		
		
		
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
			
			String exceptedurl = "https://dev.useross.com.au/Home/UserDashboard";
			String currenturl = driver.getCurrentUrl();
			//Assert.assertEquals(exceptedurl, currenturl);
			if(currenturl.contentEquals(exceptedurl))
				{
					Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Pass");
				}
			else
				{
					Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Fail");
				}
			
			obj_ll.Logoutaction();
			
			
			//TC_002 To check Login functionality with invalid credentials(valid user ID and invalid password)
			
			Excelunit.configexcel(Excelunit.excelpath, "Login and logout");
			String TC_002userIDandpassword=Excelunit.Getexceldata(2, 4);
			System.out.println(TC_002userIDandpassword);
			String TC_002userID= TC_002userIDandpassword.substring(9,14);
			System.out.println(TC_002userID);
			String TC_002password= TC_002userIDandpassword.substring(24,31);
			System.out.println(TC_002password);
			obj_ll.logincredentials(TC_002userID, TC_002password);
			
			if(currenturl !=exceptedurl)
				{
					Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Pass");
				}
			else
				{
					Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Fail");
				}
			
			//TC_003 To check Login functionality with invalid credentials(invalid user ID and valid password)
			
			Excelunit.configexcel(Excelunit.excelpath, "Login and logout");
			String TC_003userIDandpassword=Excelunit.Getexceldata(2, 4);
			System.out.println(TC_003userIDandpassword);
			String TC_003userID= TC_003userIDandpassword.substring(9,14);
			System.out.println(TC_003userID);
			String TC_003password= TC_002userIDandpassword.substring(24,31);
			System.out.println(TC_003password);
			obj_ll.logincredentials(TC_003userID, TC_003password);
			
			if(currenturl !=exceptedurl)
				{
					Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Pass");
				}
			else
				{
					Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Fail");
				}
			
			//TC_004 To check Login functionality with invalid credentials(invalid user ID and invalid password)
			
			Excelunit.configexcel(Excelunit.excelpath, "Login and logout");
			String TC_004userIDandpassword=Excelunit.Getexceldata(2, 4);
			System.out.println(TC_004userIDandpassword);
			String TC_004userID= TC_004userIDandpassword.substring(9,14);
			System.out.println(TC_004userID);
			String TC_004password= TC_004userIDandpassword.substring(24,31);
			System.out.println(TC_004password);
			obj_ll.logincredentials(TC_004userID, TC_004password);
			
			if(currenturl !=exceptedurl)
				{
					Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Pass");
				}
			else
				{
					Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Fail");
				}
			
			//TC_005 To check Login functionality with blank credentials
			
			obj_ll.strbtnSubmit.click();
			
			if(currenturl !=exceptedurl)
				{
					Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Pass");
				}
			else
				{
					Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Fail");
				}
			}
	}
}
