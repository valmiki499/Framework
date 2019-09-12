package appmodule;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageobject.Forgotpassword_POM;
import Pageobject.Login_Logout_POM;
import utility.Excelunit;

public class Forgotpassword {
	
	public static void forgotpasswordaction(WebDriver driver) throws Exception
	{
		//TC_001 To check with valid email id  user receving reset password link on mail
		Excelunit.configexcel(Excelunit.excelpath, "Forgotpassword");
		String TC_001emailid=Excelunit.Getexceldata(1, 4);
		System.out.println(TC_001emailid);
		String forgotemailid= TC_001emailid.substring(9,14);
		System.out.println(forgotemailid);
		Forgotpassword_POM obj_fogpaswd=PageFactory.initElements(driver, Forgotpassword_POM.class);
		obj_fogpaswd.strforgotpasswordlink.click();
		obj_fogpaswd.strUserIDfield.sendKeys(forgotemailid);
		obj_fogpaswd.strbtnSubmit.click();
		WebDriverWait wait= new WebDriverWait(driver,20);
		//WebElement guru99seleniumlink;
		
		String expectedmesg="UserID/Password reset link has been shared on your Email Id.";
		
		wait.until(ExpectedConditions.visibilityOf(obj_fogpaswd.stralertmessage));
		String actualmesg= obj_fogpaswd.stralertmessage.getText();
		
		
		if(expectedmesg.equalsIgnoreCase(actualmesg))
		{
			Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Fail");
		}
		
		obj_fogpaswd.stralertbutton.click();
		
		//TC_002 To check user able to set new password
		
		((JavascriptExecutor) driver).executeScript("window.open();");
		ArrayList al= new ArrayList(driver.getWindowHandles());
		String firstwindow=al.get(1).toString();
		driver.switchTo().window(firstwindow);
		driver.navigate().to("https://outlook.office.com/owa/?path=/mail/inbox");
		driver.findElement(By.id("i0116")).sendKeys("valmiki.k@intelegain.com");
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).clear();
		driver.findElement(By.id("i0118")).sendKeys("krishna@1990");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		driver.findElement(By.id("idBtn_Back")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='_ariaId_25']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Password Reset - All')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[contains(text(),'Reset Password Link')]")).click();
		
		//driver.close();
		for(String secondwindo : driver.getWindowHandles())
		{
			System.out.println(secondwindo);
			driver.switchTo().window(secondwindo);
			
		}
		String TC_002passwords=Excelunit.Getexceldata(2, 4);
		System.out.println(TC_002passwords);
		String TC_002newpassword= TC_002passwords.substring(12,19);
		System.out.println(TC_002newpassword);
		String TC_002confirmnewpassword= TC_002passwords.substring(36,43);
		System.out.println(TC_002confirmnewpassword);
		Thread.sleep(2000);
		obj_fogpaswd.setnewpassword(TC_002newpassword, TC_002confirmnewpassword);
		
		String passwordsetexpectedmesg="Your Password has been reset Successfully.";
		
		String passwordsetactualmesg= obj_fogpaswd.strsetpasswordsuccess.getText();
		
		if(passwordsetexpectedmesg.equalsIgnoreCase(passwordsetactualmesg))
		{
			Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Fail");
		}
		obj_fogpaswd.strclickhere.click();
		
		//TC_003 To check user is able to login with new password
		Excelunit.configexcel(Excelunit.excelpath, "Forgotpassword");
		String TC_003userIDandpassword=Excelunit.Getexceldata(3, 4);
		System.out.println(TC_003userIDandpassword);
		String TC_003userID= TC_003userIDandpassword.substring(9,14);
		System.out.println(TC_003userID);
		String TC_003password= TC_003userIDandpassword.substring(24,31);
		System.out.println(TC_003password);
		
		Login_Logout_POM ll= PageFactory.initElements(driver, Login_Logout_POM.class);
		ll.logincredentials(TC_003userID,TC_003password);
		
		String exceptedurl = "https://dev.useross.com.au/Home/UserDashboard";
		String currenturl = driver.getCurrentUrl();
		
		if(currenturl.contentEquals(exceptedurl))
		{
			Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Fail");
		}
		
		ll.Logoutaction();
		
		
		//TC_004 To check Forgot password functionality with invalid Email ID
		
		Excelunit.configexcel(Excelunit.excelpath, "Forgotpassword");
		String TC_004emailid=Excelunit.Getexceldata(4, 4);
		System.out.println(TC_004emailid);
		String TC_004forgotemailid= TC_004emailid.substring(8,38);
		System.out.println(TC_004forgotemailid);
		obj_fogpaswd.strforgotpasswordlink.click();
		obj_fogpaswd.stremailfield.sendKeys(TC_004forgotemailid);
		obj_fogpaswd.strbtnSubmit.click();
		//wait.until(ExpectedConditions.visibilityOf(obj_fogpaswd.stralertmessage));
		String TC_004expectedmesg="UserID/Password reset link has been shared on your";
		
		String TC_004actualmesg= driver.getPageSource();
		
		
		if(TC_004expectedmesg != TC_004actualmesg)
		{
			Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Fail");
		}
		
		
		//TC_005 To check Forgot password functionality with invalid Email ID(Not exist in system)
		Excelunit.configexcel(Excelunit.excelpath, "Forgotpassword");
		String TC_005emailid=Excelunit.Getexceldata(5, 4);
		System.out.println(TC_005emailid);
		String TC_005forgotemailid= TC_004emailid.substring(8,38);
		System.out.println(TC_004forgotemailid);
		obj_fogpaswd.stremailfield.clear();
		obj_fogpaswd.stremailfield.sendKeys(TC_005forgotemailid);
		obj_fogpaswd.strbtnSubmit.click();
		
		String TC_005expectedmesg="UserID/Password reset link has been shared on your";
		
		String TC_005actualmesg= driver.getPageSource();
		
		
		if(TC_005expectedmesg != TC_005actualmesg)
		{
			Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Fail");
		}
		
		
		//TC_006 To check Forgot password functionality with blank Email ID
		obj_fogpaswd.stremailfield.clear();
		obj_fogpaswd.strbtnSubmit.click();
		
		String TC_006expectedmesg="UserID/Password reset link has been shared on your";
		
		String TC_006actualmesg= driver.getPageSource();
		
		
		if(TC_006expectedmesg != TC_006actualmesg)
		{
			Excelunit.setexceldata(6, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(6, 8, Excelunit.excelpath, "Test Fail");
		}
	}

}
