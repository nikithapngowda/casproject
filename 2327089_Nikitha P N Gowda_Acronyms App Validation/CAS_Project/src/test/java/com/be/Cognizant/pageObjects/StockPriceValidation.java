package com.be.Cognizant.pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.be.Cognizant.utilities.ExcelUtilities;

public class StockPriceValidation {
		WebDriver driver;
		WebElement footer,stockPrice,googleSearchBox,googleStockPrice;
		String currentPrice,highPrice,lowPrice;
		int noOfRows,noOfCells;
		public StockPriceValidation(WebDriver driver){
			this.driver=driver;
		}
		
		public String getStockPrice() throws InterruptedException {
			Thread.sleep(5000);
			footer=driver.findElement(By.xpath("//*[@id=\"spPageCanvasContent\"]/div/div/div/div/div/div/div[2]"));
			JavascriptExecutor jse =(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();",footer);
			Thread.sleep(5000);		
			stockPrice=driver.findElement(By.xpath("//*[@id=\"vpc_WebPart.pnpStockInformation.external.5b8c6db2-f462-40aa-9cfe-6e64d258595f\"]/div/div/div/div/div[1]/div[1]"));
			return stockPrice.getText();
		}
		
		
		public String getStockPriceFromGoogle() throws InterruptedException {
			 driver.switchTo().newWindow(WindowType.TAB);
		     driver.get("https://google.com/");
		    
		     googleSearchBox=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		     googleSearchBox.sendKeys("cognizant stock price");
		     googleSearchBox.sendKeys(Keys.ENTER);
		    
		     googleStockPrice=driver.findElement(By.cssSelector("#knowledge-finance-wholepage__entity-summary > div.aviV4d > g-card-section > div > g-card-section > div.wGt0Bc > div.PZPZlf > span:nth-child(1) > span > span.IsqQVc.NprOob.wT3VGc"));
		     currentPrice=googleStockPrice.getText();
		     return currentPrice;
		}
		
		public void printPastData() throws IOException {
		     
			 noOfRows=ExcelUtilities.getRowCount("C:\\Users\\2327089\\Downloads\\Major_Project 1\\CAS_Project\\src\\testData\\data.xlsx","Sheet1");
		     noOfCells=ExcelUtilities.getCellCount("C:\\Users\\2327089\\Downloads\\Major_Project 1\\CAS_Project\\src\\testData\\data.xlsx","Sheet1",0);
			 double price1=Double.parseDouble(currentPrice);
			   
			    for(int i=1;i<noOfRows;i++) {
			    	highPrice=ExcelUtilities.getCellData("C:\\Users\\2327089\\Downloads\\Major_Project 1\\CAS_Project\\src\\testData\\data.xlsx","Sheet1",i,1);
			    	lowPrice=ExcelUtilities.getCellData("C:\\Users\\2327089\\Downloads\\Major_Project 1\\CAS_Project\\src\\testData\\data.xlsx","Sheet1",i,2);
			    		double high1=Double.parseDouble(highPrice);
			    		double low1=Double.parseDouble(lowPrice);
			    		if(price1<=high1 & price1>=low1 ) {
			    			String pastData=ExcelUtilities.getCellData("C:\\Users\\2327089\\Downloads\\Major_Project 1\\CAS_Project\\src\\testData\\data.xlsx","Sheet1",i,0);
			    			System.out.println(pastData);
			    		} 
			    }
		}
}
