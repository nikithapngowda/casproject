package com.be.Cognizant.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AcronymsVerification {
	WebDriver driver;
	WebElement companyMenu,acronymButton,AcronymTitles,acronymTitle,toolTipTiltle;
	List<WebElement> listAcronyms;
	int noOfRows;
 	Actions actions;
	
	public AcronymsVerification(WebDriver driver){
		this.driver=driver;
	}
	
	public String getAcronymTitle() throws InterruptedException {
		
 		acronymTitle=driver.findElement(By.xpath("//div[@id='title_text']"));
 		System.out.println(acronymTitle.getText());
        return acronymTitle.getText();
 	}
 	
 	public String getToolTip() throws InterruptedException {
 		
		toolTipTiltle = driver.findElement(By.xpath("//div[@id='title_text']"));
		actions = new Actions(driver);
		actions.moveToElement(toolTipTiltle).build().perform();
		System.out.println(toolTipTiltle.getAttribute("title"));
		return toolTipTiltle.getAttribute("title");
 	}
	
	public void clickCompanyMenu() throws InterruptedException {
		companyMenu=driver.findElement(By.xpath("//button[@name='Company']"));
		companyMenu.click();
	}
	
	public void clickAcronym() {
		acronymButton=driver.findElement(By.xpath("//a[@name='Acronyms']"));
		acronymButton.click();
	}
	
	public int getNoOfRows() {	
		listAcronyms=driver.findElements(By.xpath("//table[@class='bandedRowTableStyleTheme ck-table-resized']//tbody//tr"));
		noOfRows=listAcronyms.size();
		return noOfRows;
	}
	
	public void printTitles() {
		 for(int r =1;r<=noOfRows;r++) {
	       	 String acronym = driver.findElement(By.xpath("//table[@class='bandedRowTableStyleTheme ck-table-resized']//tbody//tr["+r+"]//td[1]")).getText();
	       	 String stands = driver.findElement(By.xpath("//table[@class='bandedRowTableStyleTheme ck-table-resized']//tbody//tr["+r+"]//td[2]")).getText();       	
	       	 System.out.printf("%-10s   %s",acronym,stands);
	       	 System.out.println();
	        }
	}

}
