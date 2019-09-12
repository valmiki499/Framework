package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Forgotpassword_POM {
	
	@FindBy(how=How.XPATH,using="//a[@class='forgot-pas']")
	public WebElement strforgotpasswordlink;
	
	@FindBy(how=How.ID,using="Email")
	public WebElement stremailfield;
	
	@FindBy(how=How.ID,using="UseROSSUserID")
	public WebElement strUserIDfield;
	
	@FindBy(how=How.ID,using="btnSubmit")
	public WebElement strbtnSubmit;
	
	//@FindBy(how=How.XPATH,using="//div[contains(@class,'showSweetAlert visible')]")
	@FindBy(how=How.XPATH,using="//h5[contains(text(),'UserID/Password reset link has been shared on your')]")
	public WebElement stralertmessage;
	
	
	@FindBy(how=How.XPATH,using="//button[contains(@class,'confirm btn btn-lg btn-primary')]")
	public WebElement stralertbutton;
	
	
	@FindBy(how=How.ID,using="txtNewPassword")
	public WebElement strnewpassword;
	
	@FindBy(how=How.ID,using="txtNewConfirmPassword")
	public WebElement strconfirmnewpassword;
	
	@FindBy(how=How.ID,using="btnSubmit")
	public WebElement strpasswordsubmit;
	
	@FindBy(how=How.XPATH,using="//div[@id='divSucessMsg']")
	public WebElement strsetpasswordsuccess;
	
	
	@FindBy(how=How.XPATH,using="/html/body/form/div/div/section/div/div/div/div[1]/span[2]/a")
	public WebElement strclickhere;
	
	public void setnewpassword(String New,String confnew)
	{
		strnewpassword.sendKeys(New);
		strconfirmnewpassword.sendKeys(confnew);
		strpasswordsubmit.click();
		strsetpasswordsuccess.click();
	}
}
