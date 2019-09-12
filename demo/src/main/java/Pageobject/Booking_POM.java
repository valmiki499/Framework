package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Booking_POM {
	
	
	@FindBy(how=How.XPATH,using="//*[@id='Bookings']/a")
	public WebElement clickonBooking;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Add Booking')]")
	public WebElement clickaddbooking;
	
	@FindBy(how=How.XPATH,using="//*[@id='select2-chosen-3']")
	public WebElement clickonsource;
	
	@FindBy(how=How.ID,using="drpBookingSource")
	public WebElement selectsourcevalue;
	
	@FindBy(how=How.XPATH,using="//*[@id='s2id_drpRoom']/a")
	public WebElement clickonRoom;
	
	@FindBy(how=How.ID,using="drpRoom")
	public WebElement selectroomvalue;
	
	@FindBy(how=How.XPATH,using="//*[@id='s2id_drpRoomCnt']/a")
	public WebElement clickonRoomcount;
	
	@FindBy(how=How.ID,using="drpRoomCnt")
	public WebElement selectroomcountvalue;
	
	@FindBy(how=How.ID,using="txtCheckinDate")
	public WebElement clickoncheckindate;
	
	@FindBy(how=How.XPATH,using="//*[@id='aNextguestDetail']")
	public WebElement clickonNextIcon;
	
	@FindBy(how=How.ID,using="txtFirstName")
	public WebElement FirstName;
	
	@FindBy(how=How.ID,using="txtLastName")
	public WebElement LastName;
	
	@FindBy(how=How.ID,using="txtEMail")
	public WebElement Email;
	
	@FindBy(how=How.ID,using="txtPhoneNo")
	public WebElement PhomeNo;
	
	@FindBy(how=How.ID,using="txtCountry")
	public WebElement Country;
	
	@FindBy(how=How.ID,using="txtState")
	public WebElement state;
	
	@FindBy(how=How.ID,using="txtCity")
	public WebElement City;
	
	@FindBy(how=How.ID,using="txtPostalCode")
	public WebElement Postalcode;
	
	@FindBy(how=How.ID,using="txtAddress")
	public WebElement Address;
	
	
	@FindBy(how=How.ID,using="guestInfoMaster_CompanyName")
	public WebElement Company;
	
	@FindBy(how=How.ID,using="bookingMaster_Comments")
	public WebElement Comments;
	
	@FindBy(how=How.ID,using="btnAddBooking")
	public WebElement AddBookingsubmit;
	
	
	
	
}
