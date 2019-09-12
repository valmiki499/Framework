package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Signup_POM {
	
	//Sign up link click
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	public WebElement strclickonsignup;
	
	//property name field
	@FindBy(how=How.ID,using="txtPropertyName")
	public WebElement strPropertyName;
	
	//Number of rooms name field
	@FindBy(how=How.ID,using="txtNoOfRooms")
	public WebElement strNoOfRooms;
	
	//Website  field
	@FindBy(how=How.ID,using="Website")
	public WebElement strWebsite;
		
	//PhoneNo field
	@FindBy(how=How.ID,using="txtPhoneNo")
	public WebElement strPhoneNo;	
	
	//PropertyEmail field
	@FindBy(how=How.ID,using="PropertyEmail")
	public WebElement strPropertyEmail;
	
	//txtFaxNo field
	@FindBy(how=How.ID,using="txtFaxNo")
	public WebElement strFaxNo;
		
	//txtPostCode field
	@FindBy(how=How.ID,using="txtPostCode")
	public WebElement strPostCode;
	
	//drpPMS field
	@FindBy(how=How.ID,using="drpPMS")
	public WebElement strdrpPMS;
	
	//drpCountry field
	@FindBy(how=How.ID,using="drpCountry")
	public WebElement strdrpCountry;
	
	//drpState field
	@FindBy(how=How.ID,using="drpState")
	public WebElement strdrpState;
	
	//txtCity field
	@FindBy(how=How.ID,using="txtCity")
	public WebElement strtxtCity;
	
	//AddressLine1 field
	@FindBy(how=How.ID,using="AddressLine1")
	public WebElement strAddressLine1;
	
	//AddressLine2 field
	@FindBy(how=How.ID,using="AddressLine2")
	public WebElement strAddressLine2;
	
	//txtHostName field
	@FindBy(how=How.ID,using="txtHostName")
	public WebElement strtxtHostName;
	
	//txtMobileNo field
	@FindBy(how=How.ID,using="txtMobileNo")
	public WebElement strttxtMobileNo;
	
	//Email field
	@FindBy(how=How.ID,using="Email")
	public WebElement strtEmail;
	
	//txtPassword field
	@FindBy(how=How.ID,using="txtPassword")
	public WebElement strtxtPassword;
	
	//txtConfirmPassword field
	@FindBy(how=How.ID,using="txtConfirmPassword")
	public WebElement strtxtConfirmPassword;
	
	//for captch
	
	//btnSubmit field
	@FindBy(how=How.ID,using="btnSubmit")
	public WebElement strbtnSubmit;
	
	
	
	
	
	
}
