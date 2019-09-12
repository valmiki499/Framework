package appmodule;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import Pageobject.Changepassword_POM;
import Pageobject.Login_Logout_POM;
import utility.Commonfunction;
import utility.Excelunit;

public class Changepassword {
	
	public static void changepasswordaction(WebDriver driver) throws Exception
	{
		//TC_001 To check login with existing/old password
 		Excelunit.configexcel(Excelunit.excelpath, "Change password");
		String TC_001userIDandpassword=Excelunit.Getexceldata(1, 4);
		System.out.println(TC_001userIDandpassword);
		String TC_001userID= TC_001userIDandpassword.substring(9,14);
		System.out.println(TC_001userID);
		String TC_001password= TC_001userIDandpassword.substring(24,31);
		System.out.println(TC_001password);
		Login_Logout_POM obj_ll=PageFactory.initElements(driver, Login_Logout_POM.class);
		obj_ll.logincredentials(TC_001userID, TC_001password);	
		
			
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
					
				if(currenturl.contentEquals(exceptedurl))
						{
							Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Pass");
						}
				else
						{
							Excelunit.setexceldata(1, 8, Excelunit.excelpath, "Test Fail");
						}
					
					//TC_002 To check without entering password and click on submit button
					
					Changepassword_POM objcp=PageFactory.initElements(driver, Changepassword_POM.class);
					Thread.sleep(2000);
					obj_ll.strprofilearrow.click();
					objcp.strprofile.click();
					Thread.sleep(2000);
					objcp.strchangepasswordlink.click();
					objcp.strbtnSubmit.click();
					
					String expectedmessage="Password must contain atleast 6 character, one capital letter & one number";
					String actualmessage=objcp.strSubmitvalidation.getText();
					if(expectedmessage.equalsIgnoreCase(actualmessage))
						{
							Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(2, 8, Excelunit.excelpath, "Test Fail");
						}
					
					objcp.strok.click();
					
					//TC_003 To check entering space in password and click on submit button
					
					objcp.strOldPassword.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE);
					objcp.strNewPassword.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE);
					objcp.strNewConfirmPassword.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE);
					objcp.strbtnSubmit.click();
					String TC_003expectedmessage="Password must contain atleast 6 character, one capital letter & one number";
					String TC_003actualmessage=objcp.strSubmitvalidation.getText();
					if(TC_003expectedmessage.equalsIgnoreCase(TC_003actualmessage))
						{
							Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(3, 8, Excelunit.excelpath, "Test Fail");
						}
					
					objcp.strok.click();
					
					//TC_004 To check entering invalid old password and valid new and confirm password and click on submit
							
					objcp.clearfields();
					Excelunit.configexcel(Excelunit.excelpath, "Change password");
					String TC_004allpassword=Excelunit.Getexceldata(4, 4);
					System.out.println(TC_004allpassword);
					String TC_004oldpassword= TC_004allpassword.substring(12,20);
					System.out.println(TC_004oldpassword);
					String TC_004newpassword= TC_004allpassword.substring(33,40);
					System.out.println(TC_004newpassword);
					String TC_004confirmnewpassword= TC_004allpassword.substring(57,64);
					System.out.println(TC_004confirmnewpassword);
					
					objcp.strOldPassword.sendKeys(TC_004oldpassword);
					objcp.strNewPassword.sendKeys(TC_004newpassword);
					objcp.strNewConfirmPassword.sendKeys(TC_004confirmnewpassword);
					
					objcp.strbtnSubmit.click();
					String TC_004expectedmessage="Please enter correct old password";
					String TC_004actualmessage=driver.getPageSource();
					if(TC_004actualmessage.contains(TC_004expectedmessage))
						{
							Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(4, 8, Excelunit.excelpath, "Test Fail");
						}
					
					objcp.clearfields();
					
					//TC_005 To check entering valid old password and invalid new and confirm password and  click on submit
					Excelunit.configexcel(Excelunit.excelpath, "Change password");
					String TC_005allpassword=Excelunit.Getexceldata(5, 4);
					System.out.println(TC_005allpassword);
					String TC_005oldpassword= TC_005allpassword.substring(12,19);
					System.out.println(TC_005oldpassword);
					String TC_005newpassword= TC_005allpassword.substring(32,40);
					System.out.println(TC_005newpassword);
					String TC_005confirmnewpassword= TC_005allpassword.substring(57,65);
					System.out.println(TC_005confirmnewpassword);
					
					objcp.strOldPassword.sendKeys(TC_005oldpassword);
					objcp.strNewPassword.sendKeys(TC_005newpassword);
					objcp.strNewConfirmPassword.sendKeys(TC_005confirmnewpassword);
					objcp.strbtnSubmit.click();
					
					
					String TC_005expectedmessage="New Password and Confirm New Password field data does not match.";
					String TC_005actualmessage=objcp.strnewconfrimpassnotmatch.getText();
					if(TC_005expectedmessage.equalsIgnoreCase(TC_005actualmessage))
						{
							Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(5, 8, Excelunit.excelpath, "Test Fail");
						}
					objcp.strok.click();
					objcp.clearfields();
					
					//TC_006 To check entering different password in New and confirm password and click on submit
					Excelunit.configexcel(Excelunit.excelpath, "Change password");
					String TC_006allpassword=Excelunit.Getexceldata(6, 4);
					System.out.println(TC_006allpassword);
					String TC_006oldpassword= TC_006allpassword.substring(12,19);
					System.out.println(TC_006oldpassword);
					String TC_006newpassword= TC_006allpassword.substring(32,40);
					System.out.println(TC_006newpassword);
					String TC_006confirmnewpassword= TC_006allpassword.substring(57,65);
					System.out.println(TC_006confirmnewpassword);
					
					objcp.strOldPassword.sendKeys(TC_006oldpassword);
					objcp.strNewPassword.sendKeys(TC_006newpassword);
					objcp.strNewConfirmPassword.sendKeys(TC_006confirmnewpassword);
					objcp.strbtnSubmit.click();
					
					
					String TC_006expectedmessage="New Password and Confirm New Password field data does not match.";
					String TC_006actualmessage=objcp.strnewconfrimpassnotmatch.getText();
					if(TC_006expectedmessage.equalsIgnoreCase(TC_006actualmessage))
						{
							Excelunit.setexceldata(6, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(6, 8, Excelunit.excelpath, "Test Fail");
						}
					objcp.strok.click();
					objcp.clearfields();
					
					//TC_007 To check entering valide password in old ,New and confirm and click on submit
					
					Excelunit.configexcel(Excelunit.excelpath, "Change password");
					String TC_007allpassword=Excelunit.Getexceldata(7, 4);
					System.out.println(TC_007allpassword);
					String TC_007oldpassword= TC_007allpassword.substring(12,19);
					System.out.println(TC_007oldpassword);
					String TC_007newpassword= TC_007allpassword.substring(32,39);
					System.out.println(TC_007newpassword);
					String TC_007confirmnewpassword= TC_007allpassword.substring(56,63);
					System.out.println(TC_007confirmnewpassword);
					
					objcp.strOldPassword.sendKeys(TC_007oldpassword);
					objcp.strNewPassword.sendKeys(TC_007newpassword);
					objcp.strNewConfirmPassword.sendKeys(TC_007confirmnewpassword);
					objcp.strbtnSubmit.click();
					
					String TC_007exceptedurl = "https://dev.useross.com.au/Home/UserDashboard";
					String TC_007currenturl = driver.getCurrentUrl();
					
					if(TC_007currenturl.contentEquals(TC_007exceptedurl))
						{
							Excelunit.setexceldata(7, 8, Excelunit.excelpath, "Test Pass");
						}
					else
						{
							Excelunit.setexceldata(7, 8, Excelunit.excelpath, "Test Fail");
						}
					
					//TC_008 To check login with New password
					
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("profile.default_content_setting_values.notifications", 2);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);
					
					obj_ll.Logoutaction();
					
					Excelunit.configexcel(Excelunit.excelpath, "Change password");
					String TC_008userIDandpassword=Excelunit.Getexceldata(1, 4);
					System.out.println(TC_008userIDandpassword);
					String TC_008userID= TC_008userIDandpassword.substring(9,14);
					System.out.println(TC_008userID);
					String TC_008password= TC_008userIDandpassword.substring(24,31);
					System.out.println(TC_008password);
					
					obj_ll.logincredentials(TC_008userID, TC_008password);	
					
					String TC_008exceptedurl = "https://dev.useross.com.au/Home/UserDashboard";
					String TC_008currenturl = driver.getCurrentUrl();
					
					if(TC_008currenturl.contentEquals(TC_008exceptedurl))
					{
						Excelunit.setexceldata(8, 8, Excelunit.excelpath, "Test Pass");
					}
					else
					{
						Excelunit.setexceldata(8, 8, Excelunit.excelpath, "Test Fail");
					}
					
				
			}
	}

}
