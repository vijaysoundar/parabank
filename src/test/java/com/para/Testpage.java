package com.para;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.basepage.Basepage;
import com.basepage.Listner;
import com.pages.Homepage;
import com.pages.Loginpage;
import com.utilities.Testutil;

@Listeners(Listner.class)
public class Testpage extends Basepage{
public static Loginpage lp;
public static Homepage hp;
public static Basepage bp;
public static Testutil tu;
	

private static Logger log = LogManager.getLogger(Testpage.class);
String log4jConfPath = "C:\\Users\\Vijay\\eclipse-workspace\\com.para\\src\\main\\resources\\log4j.properties";



	public Testpage() {
		super();
	}

	

@BeforeTest
public void bf() {
	initialization();
	lp=new Loginpage();	
	hp=new Homepage();
	bp=new Basepage();
	tu=new Testutil();
	log.debug("opening webiste");
	PropertyConfigurator.configure(log4jConfPath);
	lp.login_to_parabank();
	//driver.quit();
	
	     
	
}
@AfterTest
public void aftertest() {
	//bp.teardown();
	
}

@Test (enabled=false,priority=1)
public void register() {
	lp.register();
}

@Test (enabled=false, priority =1)
public void Login() {	
	lp.login_to_parabank();
	
}

@Test(enabled=false)
@Parameters({"username","password"})
public void ppem(String username, String password) {
	lp.userid.sendKeys(username);
	lp.password.sendKeys(password);
	lp.Loginbutton.click();
	
	if(driver.getTitle().contains("Accounts Overview")){
		System.out.println(username+"  "+password);
		System.out.println("logged in successfully");
	}
	else if(driver.findElementByXPath("//p[text()='The username and password could not be verified.']").isDisplayed()){
		//register();
		System.out.println(username+"  "+password);
		System.out.println("Register and logged in successfully");	
	}		
	
}

@Test(dataProvider="dpforlogin",enabled=false)
public void dataprovide(String username, String password) {
	lp.userid.sendKeys(username);
	lp.password.sendKeys(password);
	lp.Loginbutton.click();
	
	if(driver.getTitle().contains("Accounts Overview")){
		System.out.println(username+"  "+password);
		System.out.println("logged in successfully");
	}
	else if(driver.findElementByXPath("//p[text()='The username and password could not be verified.']").isDisplayed()){
		//register();
		System.out.println(username+"  "+password);
		System.out.println("Register and logged in successfully");	
	}		
	
}

@DataProvider
public Object [][] dpforlogin(){
	return new Object[][]
			{
		{"vijay1991","vijay1991"},
		{"vijay1992","vijay1992"},
		{"vijay1993","vijay1993"}
			};
	
}

@Test (enabled=false, priority=2)
public void acccreation() {
	//lp.login_to_parabank();
	hp.accountcreation("CHECKING");
	
	
}

@Test (enabled=false)
public void fundtransfer() {
	lp.login_to_parabank();
	hp.fundtransfer("10", account1, account2);
}

@Test (enabled=false, priority =5)
public void applyloan() {
	lp.login_to_parabank();
	hp.applyforloan("20000", "1000");
	
}

@Test(enabled=false)
public void billpaytest() {
	lp.login_to_parabank();
	hp.billpay();
	
}

@Test(enabled=false)
public void xml() throws SAXException, IOException, ParserConfigurationException {
	File fXmlFile = new File("D:\\sample.xml.txt");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	NodeList nList = doc.getElementsByTagName("staff");
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("Staff id : " + eElement.getAttribute("id"));
			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		}
	}
}

@DataProvider
public Object[][] gettingexcelldata() throws InvalidFormatException{	
	Object data[][]= Testutil.datafromexcel("Sheet1");		
	return data;
		
		
}

@Test(enabled=false, dataProvider="gettingexcelldata")
public void exceldata(String payeename,String city,String streetaddress, String state,String zipCode,String phoneNumber,String accountNumber,String verifyAccount,String billpayamount) {	
	
	
}

@Test(enabled=true, dataProvider="gettingexcelldata",priority=2)
public void billpaymentfromexcel(String payeename,String city,String streetaddress, String state,String zipCode,String phoneNumber,String accountNumber,String verifyAccount,String billpayamount) throws IOException {
	//lp.login_to_parabank();
	hp.billpaylink.click();
	hp.payeename.sendKeys(payeename);
	hp.streetaddress.sendKeys(streetaddress);
	hp.city.sendKeys(city);
	hp.state.sendKeys(state);
	hp.zipCode.sendKeys(zipCode);
	hp.phoneNumber.sendKeys(phoneNumber);
	hp.accountNumber.sendKeys(accountNumber);
	hp.verifyAccount.sendKeys(verifyAccount);
	hp.billpayamount.sendKeys(billpayamount);
	UUID uuid = UUID.randomUUID();
	bp.sc1("D:\\JAVAA\\"+uuid+".png");
	hp.sendpayment.click(); 
	hp.billpaylink.click();
	System.out.println("billpayment success");
	
}



}
