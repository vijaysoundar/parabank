package com.para;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basepage.Basepage;
import com.google.common.base.Verify;
import com.pages.Homepage;
import com.pages.Loginpage;
import com.utilities.Testutil;



public class SanityTest extends Basepage {
	
	public static Basepage bp;
	public static Loginpage lp;
	public static Testutil tu;
	public static Homepage hp;
	public SanityTest() {
		super();
	}

@BeforeTest
public void Beforetest() {
	initialization();
	lp= new Loginpage();
	bp= new Basepage();
	tu= new Testutil();
	hp= new Homepage();	
	
}

@BeforeMethod
public void beforemethod() {
	lp.login_to_parabank();	
}
@AfterMethod
public void AfterMethod() {
	//bp.logout();
}

@AfterTest
public void AfterTest() {
	//driver.close();
}

@Test(enabled=true, priority=1)
public void Validation_of_login_functionality() {
	//lp.login_to_parabank();
	String title = driver.getTitle();	
	Assert.assertEquals(title, "ParaBank | Accounts Overview");		
}

@Test(enabled=false,priority=2)
public void Creation_of_new_account() throws IOException {
	//lp.login_to_parabank();	
	hp.accountcreation("SAVINGS");	
	String new_account_id = driver.findElementByXPath("//*[@id=\"newAccountId\"]").getText();
	System.out.println("Account Created: "+new_account_id);	
	String title1 = driver.findElementByXPath("//*[@id=\"rightPanel\"]/div/div/h1").getText();	
	Assert.assertEquals(title1, "Account Opened!");	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	bp.sc1("D:\\JAVAA\\account opening.png");
} 


@Test(enabled=false,priority=3)
public void Finding_accounts() throws IOException {
	//lp.login_to_parabank();
	List<WebElement> aclist = driver.findElementsByXPath("//tbody/tr[@ng-repeat='account in accounts']/td/a");
	for(WebElement e:aclist) {		
		System.out.println(e.getText());
	}
	bp.sc1("D:\\JAVAA\\list of accounts.png");	
}

@Test
public void gittest1() {
	
}
}
  