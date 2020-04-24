package com.basepage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basepage {
	public static ChromeDriver driver;
	public static String account1="14010";
	public static String account2="14121";
	public static String account3="14232";
	
	
public void initialization() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32_r1\\chromedriver.exe");		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://parabank.parasoft.com/");
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
public static void screenshot() {
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scr, new File("C:\\Users\\Vijay\\eclipse-workspace\\com.para\\target\\Screenshot\\test.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void sc1(String scname) throws IOException {
	TakesScreenshot scrShot1 =((TakesScreenshot)driver);
	File SrcFile=scrShot1.getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(SrcFile, new File(scname));
}

public static void logout() {
	driver.findElementByXPath("//*[@id=\"leftPanel\"]/ul/li[8]/a").click();
}

public void teardown() {
	driver.quit();
}


}
