package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Commonfunction;

public class Login_Logout_POM {
	
	@FindBy(how=How.ID,using="UseROSSUserID")
	public WebElement  strUseROSSUserID;
	
	@FindBy(how=How.ID,using="Password")
	public WebElement  strPassword;
	
	@FindBy(how=How.ID,using="btnSubmit")
	public WebElement  strbtnSubmit;
	
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/header/div/nav/div[2]/ul/li[4]/a/span[2]/i")
	public WebElement  strprofilearrow;
	
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/header/div/nav/div[2]/ul/li[4]/ul/li[3]/a")
	public WebElement  strlogout;
	
	
	public void logincredentials(String struserid,String strpassword)
	{
		strUseROSSUserID.clear();
		strUseROSSUserID.sendKeys(struserid);
		strPassword.clear();
		strPassword.sendKeys(strpassword);
		strbtnSubmit.click();
//		WebElement wb= driver.findElement(By.xpath("//div[@class='preloader']"));
//		Commonfunction.waitforloader(driver, wb);
	}
	public void Logoutaction()
	{
		strprofilearrow.click();
		strlogout.click();
	}
}
