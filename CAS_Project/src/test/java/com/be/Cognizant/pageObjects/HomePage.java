package com.be.Cognizant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
			WebDriver driver;
			public HomePage(WebDriver driver){
				this.driver=driver;
			}
			public String[] getUserDetails() throws InterruptedException {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				Object obj = jse.executeScript("return document.querySelector(\"#O365_MainLink_Me > div > div.clgiLVKPzugZZns0LiPTqw\\\\=\\\\=.NK6YQ060InuEH1W1LbFJ4Q\\\\=\\\\=\")");
				((WebElement) obj).click();
				String name = driver.findElement(By.xpath("//*[@id=\"mectrl_currentAccount_primary\"]")).getText();
				String mail = driver.findElement(By.xpath("//*[@id=\"mectrl_currentAccount_secondary\"]")).getText();
				String[] details= {name,mail};
				System.out.println(mail);
				System.out.println(name);
				return details;
			}			
}
