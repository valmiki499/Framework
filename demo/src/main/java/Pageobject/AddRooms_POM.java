package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRooms_POM {
	
	
	
		@FindBy(how=How.XPATH,using="//*[@id='Setup']/a")
		public WebElement clickonsetup;
	
	@FindBy(how=How.XPATH,using="//*[@id='atabProperty']/span")
	public WebElement clickonproperty;
	
	@FindBy(how=How.ID,using="txtNoOfRooms")
	public WebElement readtxtNoOfRooms;
		
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Rooms')]")
	public WebElement clickonRoom;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='addroom']//a")
	public WebElement clickonaddRoomplusicon;
	
	@FindBy(how=How.ID,using="btnSubmit")
	public WebElement clickonroomsavebutton;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='sa-confirm-button-container']")
	public WebElement confirmsaveroombutton;
	
	
	
	@FindBy(how=How.ID,using="txtRoomName")
	public WebElement strRoomname;
	
	@FindBy(how=How.ID,using="txtPeopleInRate")
	public WebElement strtxtPeopleInRate;
			
	@FindBy(how=How.ID,using="txtMaxOccupancy")
	public WebElement strtxtMaxOccupancy;
		
	@FindBy(how=How.ID,using="txtExtraAdult")
	public WebElement strtxtExtraAdult;
	
	@FindBy(how=How.ID,using="txtExtraChild")
	public WebElement strtxtExtraChild;
	
	@FindBy(how=How.ID,using="txtAvailabilityThreshold")
	public WebElement strtxtAvailabilityThreshold;
	
	@FindBy(how=How.ID,using="txtDescription")
	public WebElement strtxtDescription;
	
	//#rate
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_0__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_0__Rate;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_1__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_1__Rate;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_2__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_2__Rate;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_3__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_3__Rate;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_4__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_4__Rate;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_5__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_5__Rate;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_6__Rate")
	public WebElement strlistDaywiseDefaultSettingModel_6__Rate;	
	//------------------------------------------------------------------------
	
	//#minstay
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_0__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_0__MinStay;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_1__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_1__MinStay;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_2__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_2__MinStay;	
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_3__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_3__MinStay;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_4__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_4__MinStay;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_5__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_5__MinStay;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_6__MinStay")
	public WebElement strlistDaywiseDefaultSettingModel_6__MinStay;
	
	
	//---------------------------------------------------------------------------
	
	//#availability
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_0__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_0__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_1__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_1__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_2__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_2__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_3__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_3__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_4__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_4__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_5__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_5__Availability;
	
	@FindBy(how=How.ID,using="listDaywiseDefaultSettingModel_6__Availability")
	public WebElement strlistDaywiseDefaultSettingModel_6__Availability;
	
	
	//-----------------------------------------------------------------------------
	
	//#StopSell
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_0']")
	public WebElement strclickonstopsell_0;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_1']")
	public WebElement strclickonstopsell_1;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_2']")
	public WebElement strclickonstopsell_2;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_3']")
	public WebElement strclickonstopsell_3;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_4']")
	public WebElement strclickonstopsell_4;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_5']")
	public WebElement strclickonstopsell_5;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkStopSell_6']")
	public WebElement strclickonstopsell_6;
	
	//--------------------------------------------------------------
	//#ClosedOnArrival
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_0']")
	public WebElement strchkClosedOnArrival_0;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_1']")
	public WebElement strchkClosedOnArrival_1;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_2']")
	public WebElement strchkClosedOnArrival_2;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_3']")
	public WebElement strchkClosedOnArrival_3;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_4']")
	public WebElement strchkClosedOnArrival_4;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_5']")
	public WebElement strchkClosedOnArrival_5;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnArrival_6']")
	public WebElement strchkClosedOnArrival_6;
	
	//-------------------------------------
	
	//#ClosedOnDeparture_0
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_0']")
	public WebElement strchkClosedOnDeparture_0;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_1']")
	public WebElement strchkClosedOnDeparture_1;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_2']")
	public WebElement strchkClosedOnDeparture_2;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_3']")
	public WebElement strchkClosedOnDeparture_3;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_4']")
	public WebElement strchkClosedOnDeparture_4;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_5']")
	public WebElement strchkClosedOnDeparture_5;
	
	@FindBy(how=How.XPATH,using="//label[@for='chkClosedOnDeparture_6']")
	public WebElement strchkClosedOnDeparture_6;
	
	//---------------------------------------------------------
	
	@FindBy(how=How.XPATH,using="//*[@id='s2id_drpRoomBedConfig']/a")
	public WebElement strbedconfig;
	
	@FindBy(how=How.ID,using="drpRoomBedConfig")
	public WebElement strdrpRoomBedConfigvalues;
	
	@FindBy(how=How.ID,using="txtSetValue")
	public WebElement strtxtSetbedconfigValue;
	
	@FindBy(how=How.ID,using="btnAddBed")
	public WebElement strbtnAddBed;
	
	@FindBy(how=How.XPATH,using="//*[@for='PropertyFacility_0']")
	public WebElement strAirConditioning;
	
	@FindBy(how=How.XPATH,using="//*[@for='PropertyFacility_1']")
	public WebElement strWardrobeCloset;
	
	
	
	public void Roominfo(String Roomname,String peopleinrate,String maxoccupancy,String extraadult,String extrachild,String Availtrash,String decription)
	{
		strRoomname.sendKeys(Roomname);
		strtxtPeopleInRate.clear();
		strtxtPeopleInRate.sendKeys(peopleinrate);
		strtxtMaxOccupancy.clear();
		strtxtMaxOccupancy.sendKeys(maxoccupancy);
		strtxtExtraAdult.clear();
		strtxtExtraAdult.sendKeys(extraadult);
		strtxtExtraChild.clear();
		strtxtExtraChild.sendKeys(extrachild);
		strtxtAvailabilityThreshold.clear();
		strtxtAvailabilityThreshold.sendKeys(Availtrash);
		strtxtDescription.clear();
		strtxtDescription.sendKeys(decription);
	}
	
	public void WeeklyDEFAULTrate(String sunrate,String monrate,String tuerate,String wedrate,String thurrate,String frirate,String satrate)
	{
		strlistDaywiseDefaultSettingModel_0__Rate.clear();
		strlistDaywiseDefaultSettingModel_0__Rate.sendKeys(sunrate);
		
		strlistDaywiseDefaultSettingModel_1__Rate.clear();
		strlistDaywiseDefaultSettingModel_1__Rate.sendKeys(monrate);
		
		strlistDaywiseDefaultSettingModel_2__Rate.clear();
		strlistDaywiseDefaultSettingModel_2__Rate.sendKeys(tuerate);
		
		strlistDaywiseDefaultSettingModel_3__Rate.clear();
		strlistDaywiseDefaultSettingModel_3__Rate.sendKeys(wedrate);
		
		strlistDaywiseDefaultSettingModel_4__Rate.clear();
		strlistDaywiseDefaultSettingModel_4__Rate.sendKeys(thurrate);
		
		strlistDaywiseDefaultSettingModel_5__Rate.clear();
		strlistDaywiseDefaultSettingModel_5__Rate.sendKeys(frirate);
		
		strlistDaywiseDefaultSettingModel_6__Rate.clear();
		strlistDaywiseDefaultSettingModel_6__Rate.sendKeys(satrate);
	}
	
	public void WeeklyDEFAULTMinstay(String sunminstay,String monminstay,String tueminstay,String wedminstay,String thurminstay,String friminstay,String satminstay)
	{
		strlistDaywiseDefaultSettingModel_0__MinStay.clear();
		strlistDaywiseDefaultSettingModel_0__MinStay.sendKeys(sunminstay);
		
		strlistDaywiseDefaultSettingModel_1__MinStay.clear();
		strlistDaywiseDefaultSettingModel_1__MinStay.sendKeys(monminstay);
		
		strlistDaywiseDefaultSettingModel_2__MinStay.clear();
		strlistDaywiseDefaultSettingModel_2__MinStay.sendKeys(tueminstay);
		
		strlistDaywiseDefaultSettingModel_3__MinStay.clear();
		strlistDaywiseDefaultSettingModel_3__MinStay.sendKeys(wedminstay);
		
		strlistDaywiseDefaultSettingModel_4__MinStay.clear();
		strlistDaywiseDefaultSettingModel_4__MinStay.sendKeys(thurminstay);
		
		strlistDaywiseDefaultSettingModel_5__MinStay.clear();
		strlistDaywiseDefaultSettingModel_5__MinStay.sendKeys(friminstay);
		
		strlistDaywiseDefaultSettingModel_6__MinStay.clear();
		strlistDaywiseDefaultSettingModel_6__MinStay.sendKeys(satminstay);
	}
	
	public void WeeklyDEFAULTAvailability(String sunAvail,String monAvail,String tueAvail,String wedAvail,String thurAvail,String friAvail,String satAvail)
	{
		strlistDaywiseDefaultSettingModel_0__Availability.clear();
		strlistDaywiseDefaultSettingModel_0__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_1__Availability.clear();
		strlistDaywiseDefaultSettingModel_1__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_2__Availability.clear();
		strlistDaywiseDefaultSettingModel_2__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_3__Availability.clear();
		strlistDaywiseDefaultSettingModel_3__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_4__Availability.clear();
		strlistDaywiseDefaultSettingModel_4__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_5__Availability.clear();
		strlistDaywiseDefaultSettingModel_5__Availability.sendKeys(sunAvail);
		
		strlistDaywiseDefaultSettingModel_6__Availability.clear();
		strlistDaywiseDefaultSettingModel_6__Availability.sendKeys(sunAvail);
		
	}
	
	public void setbedconfirnadamenities(String setbedvalue)
	{
		strtxtSetbedconfigValue.clear();
		strtxtSetbedconfigValue.sendKeys(setbedvalue);
		strbtnAddBed.click();
		strAirConditioning.click();
		strWardrobeCloset.click();
		
	}
}
