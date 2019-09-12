package appmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Pageobject.Login_Logout_POM;
import Pageobject.Rememberme_POM;
import utility.Commonfunction;
import utility.Excelunit;

public class Rememberme {
	
	public static void remembermeaction(WebDriver driver) throws Exception
	{
		//TC_001 To check Remember me enable functionality
		Excelunit.configexcel(Excelunit.excelpath, "Remember me");
		String userIDandpassword=Excelunit.Getexceldata(1, 4);
		System.out.println(userIDandpassword);
		String userID= userIDandpassword.substring(9,14);
		System.out.println(userID);
		String password= userIDandpassword.substring(24,31);
		System.out.println(password);
		
		Rememberme_POM Rm=PageFactory.initElements(driver, Rememberme_POM.class);
		Rm.strrememberme.click();
		
		Login_Logout_POM obj_ll=PageFactory.initElements(driver, Login_Logout_POM.class);
		obj_ll.logincredentials(userID, password);
		
		WebElement wb= driver.findElement(By.xpath("//div[@class='loader']"));
		Commonfunction.waitforloader(driver, wb);
	    
		obj_ll.Logoutaction();
		
		
		if(obj_ll.strUseROSSUserID.getText() != null && obj_ll.strPassword.getText() != null)
		{
			
			Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Fail");
		}
		//Assert.assertEquals("10011", obj_ll.strUseROSSUserID.getText());
		
		
		
		//TC_002 To check Remember me disable functionality
		Rm.strrememberme.click();
		obj_ll.logincredentials(userID, password);	
		WebElement wb1= driver.findElement(By.xpath("//div[@class='loader']"));
		Commonfunction.waitforloader(driver, wb1);
		obj_ll.Logoutaction();
		String emptystringuserid=obj_ll.strUseROSSUserID.getText();
		String emptystringpass=obj_ll.strPassword.getText();
		if(emptystringuserid.isEmpty() && emptystringpass.isEmpty())
		{
			Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Pass");
		}
		else
		{
			Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Fail");
		}
		//Assert.assertNotEquals(1, 8, Excelunit.excelpath, "Test pass");		
		
	}

}
