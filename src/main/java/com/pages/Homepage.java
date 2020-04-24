package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.basepage.Basepage;

public class Homepage extends Basepage{
	
@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[3]/a")
WebElement trffunds;

@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[1]/a")
WebElement opennewaccount;

@FindBy(xpath="//*[@id=\"type\"]")
WebElement actypedropdown;

//@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/form/div/input")
@FindBy(xpath="//*[@value='Open New Account']")
WebElement accountbutton;

@FindBy(xpath= "//*[@id=\"amount\"]")
WebElement amount;

@FindBy(xpath="//*[@id=\"fromAccountId\"]")
WebElement fromac;

@FindBy(xpath="//*[@id=\"toAccountId\"]")
WebElement toac;

@FindBy(xpath="//*[@id=\"toAccountId\"]")
WebElement trfbutton;

@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[7]/a")
WebElement Requestloan_link;

@FindBy(xpath="//*[@id=\"amount\"]")
WebElement loanamount_tab;

@FindBy(xpath="//*[@id=\"downPayment\"]")
WebElement downpayment_tab;

@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[4]/td[2]/input")
WebElement applynowbutton;

//*[@id="rightPanel"]/div/div/form/table/tbody/tr[4]/td[2]/input
//Select selectacforloan = new Select(driver.findElementByXPath("//*[@id=\"fromAccountId\"]"));

@FindBy(name="payee.name")
public WebElement payeename;

@FindBy(name="payee.address.street")
public WebElement streetaddress;

@FindBy(name="payee.address.city")
public WebElement city;

@FindBy(name="payee.address.state")
public WebElement state;

@FindBy(name="payee.address.zipCode")
public WebElement zipCode;

@FindBy(name="payee.phoneNumber")
public WebElement phoneNumber;

@FindBy(name="payee.accountNumber")
public WebElement accountNumber;

@FindBy(name="verifyAccount")
public WebElement verifyAccount;

@FindBy(name="amount")
public WebElement billpayamount;

@FindBy(xpath="//input[@value='Send Payment']")
public WebElement sendpayment;

@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[4]/a")
public WebElement billpaylink;


public void accountcreation(String type) {
	opennewaccount.click();
	Select actype = new Select(actypedropdown);
	actype.selectByVisibleText(type);
	accountbutton.click();
	accountbutton.click();;
}

public void fundtransfer(String tamount,String fromacc, String toacc) {
	trffunds.click();	
	fromac.sendKeys(fromacc);
	toac.sendKeys(toacc);
	amount.sendKeys(tamount);
	trfbutton.click();
	
}

public String applyforloan(String loanamount, String downpayment) {
	Requestloan_link.click();
	//selectacforloan.selectByVisibleText("20337");
	loanamount_tab.sendKeys(loanamount);
	downpayment_tab.sendKeys(downpayment);
	applynowbutton.click();
	String newloanacnumber=driver.findElementByXPath("//*[@id=\"newAccountId\"]").getText();
	System.out.println(newloanacnumber);
	return null;	
}

public void billpay() {
	billpaylink.click();
	payeename.sendKeys("vijay");
	streetaddress.sendKeys("MM Street");
	city.sendKeys("karaikudi");
	state.sendKeys("tamilnadu");
	zipCode.sendKeys("323001");
	phoneNumber.sendKeys("9986194841");
	accountNumber.sendKeys("1234567890");
	verifyAccount.sendKeys("1234567890");
	billpayamount.sendKeys("10");
	sendpayment.click(); 
	System.out.println("billpayment success");
	
}


public Homepage() {
	PageFactory.initElements(driver, this);
}
	
}
