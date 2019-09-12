package appmodule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Excelunit;

public class THNcompare {
	
	
	
	static String[] monthName = {"January", "February","March", "April", "May", "June", "July","August", "September", "October", "November","December"};
	static String[] Singleroominventory = new String[14];
	static String[] DoubleRoominventory = new String[14];
	static DateFormat dateFormat = new SimpleDateFormat("d");
	static Date date = new Date();
	static String systemdateandtime= dateFormat.format(date);
	//static int Singleresult = Integer.parseInt(systemdateandtime);
	//static int doubleresult = Integer.parseInt(systemdateandtime);
	static String[] THNSinglrinventory = new String[35];
	static String[] THNDoubleinventory = new String[35];
	static Calendar cal = Calendar.getInstance();
	static String month = monthName[cal.get(Calendar.MONTH)];


	
	public static void THNavaiabilitycompare(WebDriver driver) throws Exception
	{
		Excelunit.configexcel(Excelunit.excelpath, "THN inventory check");
		
		String testdate =driver.findElement(By.xpath("//*[@id='lstdate']/div[1]/a")).getText();
		System.out.println(systemdateandtime);
		//testdate=testdate.replaceAll("\n", "");
		String []aa=testdate.split("\n");
		
		System.out.println(aa[1]);
		//String v1 =testdate.substring(4,5);
		int Singleresult = Integer.parseInt(aa[1]);
		int doubleresult = Integer.parseInt(aa[1]);
		System.out.println("current date is " +Singleresult);
		
		List<WebElement> Roomcount=driver.findElements(By.xpath("//*[@id='inventorydata']/div"));
		int size=Roomcount.size();
		System.out.println(size);
		//for Single room
		for(int i=1;i<=size;i++)
		{
			String Roomname=driver.findElement(By.xpath("//*[@id='inventorydata']/div["+i+"]/div[1]/div/div[1]/h4/a")).getText();
			//*[@id="inventorydata"]/div[1]/div[1]/div/div[1]/h4/a
			//*[@id="inventorydata"]/div[1]/div[1]/div/div[1]/h4/a
			//*[@id="inventorydata"]/div[2]/div[1]/div/div[1]/h4/a
														 
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				i=i-1;
				for(int Single=0;Single<=13;Single++)
				{
					
					Singleroominventory[Single] =driver.findElement(By.xpath("//*[@id='CurrentInventory_"+i+"_Date"+Single+"']")).getAttribute("value");
					
					//*[@id="CurrentInventory_0_Date0"]
					//*[@id="CurrentInventory_0_Date1"]
					
					//*[@id="CurrentInventory_1_Date0"]
					//*[@id="CurrentInventory_0_Date0"]
					
					System.out.println("value of  " + Single + " is " + Singleroominventory[Single]);
//					int Singleroomexcelinsert=Single+1;
//					Excelunit.setexceldata(Singleroomexcelinsert,0 , Excelunit.excelpath, Singleroominventory[Single]);
					//*[@id="CurrentInventory_2_Date0"]
					
				}
				break;
			}
		}
		//for double room
		for(int i=1;i<=size;i++)
		{
			String Roomname=driver.findElement(By.xpath("//*[@id='inventorydata']/div["+i+"]/div[1]/div/div[1]/h4/a")).getText();
			//*[@id="inventorydata"]/div[1]/div[1]/div/div[1]/h4/a
														 
			System.out.println(Roomname);
			if(Roomname.contains("Double Room"))
			{
				i=i-1;
				for(int Double=0;Double<=13;Double++)
				{
					
					DoubleRoominventory[Double] =driver.findElement(By.xpath("//*[@id='CurrentInventory_"+i+"_Date"+Double+"']")).getAttribute("value");
					//*[@id="CurrentInventory_1_Date0"]
					//*[@id="CurrentInventory_0_Date0"]
					int Doubleroomexcelinsert=Double+1;
//					System.out.println("value of  " + Double + "is" + DoubleRoominventory[Double]);
//					Excelunit.setexceldata(Doubleroomexcelinsert, 2, Excelunit.excelpath, DoubleRoominventory[Double]);
					
					//*[@id="CurrentInventory_2_Date0"]
					
				}
				break;
			}
		}
				
					
					
					//*[@id="lstdate"]/div[1]/a/text()[2]
					
								
				
					((JavascriptExecutor) driver).executeScript("window.open();");
					System.out.println("Navigating to THN channel site");
					ArrayList arr= new ArrayList(driver.getWindowHandles());
					String pareant=arr.get(0).toString();
					String childewindow=arr.get(1).toString();
					driver.switchTo().window(childewindow);
					driver.get("https://stage.hotelnetwork.com.au/admin/welcome_to_hotel_network");
					
					driver.findElement(By.name("THN_mysource_login")).clear();
					driver.findElement(By.name("THN_mysource_login")).sendKeys("useross_6873");
					driver.findElement(By.name("mysource_password")).sendKeys("Password@123");
					driver.findElement(By.xpath("//*[@type='submit']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//a[contains(text(),'Static Availability')]")).click();
					//driver.findElement(By.xpath("//*[@class='hnav-menu__item-txt']")).click();
					
					int counter=0;
					
					for(int tr=3;tr<=7;tr++)	
					{
							for(int td=1;td<=7;td++)
							{
								if(counter==14)
								{
									break;
								}
								List<WebElement> list = driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/b"));
																					  //html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/b
								if(list.size()>0)
								{
									String data=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/b")).getText();
									//System.out.println(data);
									//System.out.println(systemdateandtime);
									if((Singleresult)==Integer.parseInt(data))
									
									{
										int THNSingleroomexcelinsert=counter+1;
										//if(!driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[1]/td[6]/input")).getAttribute("value").equals(""))
										//{
												THNSinglrinventory[counter] =driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[1]/td[6]/input")).getAttribute("value");
												//below line check if text box is blank 
												if(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[1]/td[6]/input")).getAttribute("value").equals(""))
												{
													THNSinglrinventory[counter] ="0";
													System.out.println("Single Room" +" " + Singleresult +" " + month +" inventory is " + THNSinglrinventory[counter] + " applied stop sell ");
													Excelunit.setexceldata(THNSingleroomexcelinsert,0 , Excelunit.excelpath, "Single Room" +" " + Singleresult +" " + month +" inventory is " + THNSinglrinventory[counter] + " applied stop sell ");
													
												}
												//System.out.println(Singleresult + month +" inventory is " + THNSinglrinventory[counter]);
												
												
												else
												{
													int Userossinventorywiththrashhod=Integer.parseInt(Singleroominventory[counter]);
													int THNinventoryminusthreashold=Integer.parseInt(THNSinglrinventory[counter]);
													if((Userossinventorywiththrashhod-10)==THNinventoryminusthreashold)
														{
															//System.out.println("inventory match");
															System.out.println("Single Room" +" " + Singleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNSinglrinventory[counter] + " inventory match");
															Excelunit.setexceldata(THNSingleroomexcelinsert,0 , Excelunit.excelpath, "Single Room" +" " + Singleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNSinglrinventory[counter] + " inventory match");
														}
													else
														{
															//System.out.println("inventory not match");
															System.out.println("Single Room" +" " + Singleresult +" "+  month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNSinglrinventory[counter] + " inventory not match");
															Excelunit.setexceldata(THNSingleroomexcelinsert,0 , Excelunit.excelpath, "Single Room" +" " + Singleresult +" "+  month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNSinglrinventory[counter] + " inventory not match");
														}
												}
												Singleresult=Singleresult+1;
												counter=counter+1;
										
												
									}
								}
								
							}
							
							
							
					}
					
					
					
					
					int counter1=0;
					for(int tr=3;tr<=7;tr++)	
					{
							for(int td=1;td<=7;td++)
							{
								if(counter1==14)
								{
									break;
								}
								List<WebElement> list = driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/b"));
								
								if(list.size()>0)
								{
									String data=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/b")).getText();
									//System.out.println(data);
									//System.out.println(systemdateandtime);
									if(doubleresult==Integer.parseInt(data))
									{
										int THNDoubleoomexcelinsert=counter1+1;
										//if(!driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[1]/td[6]/input")).getAttribute("value").equals(""))
										//{
												THNDoubleinventory[counter1] =driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[2]/td[6]/input")).getAttribute("value");
																										   	
												if(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr["+tr+"]/td["+td+"]/table/tbody/tr[2]/td[6]/input")).getAttribute("value").equals(""))
												{
													THNDoubleinventory[counter1] ="0";
													System.out.println("Double Room" +" " + doubleresult +" " + month +" inventory is " + THNDoubleinventory[counter1] + " applied stop sell ");
													Excelunit.setexceldata(THNDoubleoomexcelinsert,1 , Excelunit.excelpath, "Double Room" +" " + doubleresult +" " + month +" inventory is " + THNDoubleinventory[counter1] + " applied stop sell ");
												}
												
												
												else
												{
												
												int Userossinventorywiththrashhod=Integer.parseInt(DoubleRoominventory[counter1]);
												int THNinventoryminusthreashold=Integer.parseInt(THNDoubleinventory[counter1]);
												if((Userossinventorywiththrashhod-10)==THNinventoryminusthreashold)
													{
														//System.out.println("inventory match");
														System.out.println("Double Room" +" " + doubleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNDoubleinventory[counter1] + " inventory match");
														Excelunit.setexceldata(THNDoubleoomexcelinsert,1 , Excelunit.excelpath, "Double Room" +" " + doubleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNDoubleinventory[counter1] + " inventory match");
													}
												else
													{
														//System.out.println("inventory not match");
														System.out.println("Double Room" +" " + doubleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNDoubleinventory[counter1] + " inventory not match");
														Excelunit.setexceldata(THNDoubleoomexcelinsert,1 , Excelunit.excelpath, "Double Room" +" " + doubleresult +" "+ month + " UR inventory is " + (Userossinventorywiththrashhod-10) + " and THN inventory is " + THNDoubleinventory[counter1] + " inventory not match");
													}
												}
												doubleresult=doubleresult+1;
												counter1=counter1+1;
										
												
									}
								}
								
							}
							
							
					}
					
				driver.close();
				
				driver.switchTo().window(pareant);

				
			}
			
		

	

}
