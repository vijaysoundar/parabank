package com.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.basepage.Basepage;
import com.basepage.Listner;


public class Loginpage extends Basepage {
	public static String user= "karthick1998";	
	
	
	@FindBy(name = "username")
	public WebElement userid;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[2]/input")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[3]/input")
	public WebElement Loginbutton;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/p[2]/a")
	WebElement Clickregister;
	
	@FindBy(id="customer.firstName")
	WebElement customerfirstname;
	
	@FindBy(id="customer.lastName")
	WebElement customerlastName;
	
	@FindBy(id="customer.address.street")
	WebElement customeraddressstreet;
	
	@FindBy(id="customer.address.city")
	WebElement customeraddresscity;
	
	@FindBy(id="customer.address.state")
	WebElement customeraddressstate;
	
	@FindBy(id="customer.address.zipCode")
	WebElement customeraddresszipCode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement customerphoneNumber;
	
	@FindBy(id="customer.ssn")
	WebElement customerssn;
	
	@FindBy(id="customer.username")
	WebElement customerusername;
	
	@FindBy(id="customer.password")
	WebElement customerpassword;
	
	@FindBy(id="repeatedPassword")
	WebElement repeatedPassword;
	
	@FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
	WebElement registerbutton;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/h1")
	WebElement succmsg;
	
	
	public void login_to_parabank() {		
		userid.sendKeys(user);
		password.sendKeys(user);
		Loginbutton.click();		
//		try {
//			driver.findElementByXPath("//h1[text()='Accounts Overview']").isDisplayed();
//			System.out.println("logged in successfully");
//		}
//		catch(Exception e) {
//			register();
//			System.out.println("Register and logged in successfully");
//		}	
		
		if(driver.getTitle().contains("Accounts Overview")){			
			System.out.println("logged in successfully");
		}
		else if(driver.findElementByXPath("//p[text()='The username and password could not be verified.']").isDisplayed()){
			register();
			System.out.println("Register and logged in successfully");	
		}		

	}
	
	
	public void register() {
		Clickregister.click();
		customerfirstname.sendKeys(user);
		customerlastName.sendKeys(user);
		customeraddressstreet.sendKeys(user);
		customeraddresscity.sendKeys(user);
		customeraddressstate.sendKeys(user);
		customeraddresszipCode.sendKeys(user);
		customerphoneNumber.sendKeys(user);
		customerssn.sendKeys(user);
		customerusername.sendKeys(user);
		customerpassword.sendKeys(user);
		repeatedPassword.sendKeys(user);
		registerbutton.click();
		//String successmsg = succmsg.getText();
		//assert successmsg== "Welcome "+user;
		
		
		
	}
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

}
