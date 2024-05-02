package com.be.Cognizant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerifyBeCognizant {
         	WebDriver driver;
         	WebElement beCognizantTitle;
         	
         	public VerifyBeCognizant(WebDriver driver){
         		this.driver=driver;
         	}
         	
         	public String verifyBeCognizantTitle() throws InterruptedException {
         		
         		beCognizantTitle=driver.findElement(By.cssSelector(".ms-Button-label"));
         		beCognizantTitle.click();
         		Thread.sleep(5000);
         	    System.out.println(driver.getTitle());
         		return driver.getTitle();      		
         	}
         	
         	
         
         	
         	
         	
         	
}
