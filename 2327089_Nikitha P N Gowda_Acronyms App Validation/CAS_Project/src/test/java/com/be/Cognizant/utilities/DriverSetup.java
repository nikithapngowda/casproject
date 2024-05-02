package com.be.Cognizant.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver getDriver(String browser) throws InterruptedException {
		
		if(browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		
		}
		
		driver.get("https://be.cognizant.com");
		Thread.sleep(25000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}	
	public static void driverTearDown() {
		driver.quit();
	}

}
