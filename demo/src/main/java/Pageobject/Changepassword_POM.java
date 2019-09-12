package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Changepassword_POM {
	
		@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu animated littleFadeInRight profilmenu']//li[1]//a[1]")
		public WebElement strprofile;
		
		@FindBy(how=How.XPATH,using="//*[@id='aChangePassword']")
		public WebElement strchangepasswordlink;
		
		@FindBy(how=How.ID,using="txtOldPassword")
		public WebElement strOldPassword;
		
		@FindBy(how=How.ID,using="txtNewPassword")
		public WebElement strNewPassword;
		
		@FindBy(how=How.ID,using="txtNewConfirmPassword")
		public WebElement strNewConfirmPassword;
		
		@FindBy(how=How.ID,using="btnSubmit")
		public WebElement strbtnSubmit;
		
		@FindBy(how=How.XPATH,using="//h5[contains(text(),'Password must contain atleast 6 character, one capital letter & one number')]")
		public WebElement strSubmitvalidation;
		
		
		@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
		public WebElement strok;
		
		
		
		@FindBy(how=How.XPATH,using="/html/body/div[2]/h5")
		public WebElement strnewconfrimpassnotmatch;
		
		public void clearfields()
		{
			strOldPassword.clear();
			strNewPassword.clear();
			strNewConfirmPassword.clear();
		}
		
		
}
