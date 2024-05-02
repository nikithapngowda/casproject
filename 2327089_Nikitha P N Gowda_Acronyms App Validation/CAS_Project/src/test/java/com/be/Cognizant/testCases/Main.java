package com.be.Cognizant.testCases;

import org.testng.annotations.Test;

import com.be.Cognizant.pageObjects.AcronymsVerification;
import com.be.Cognizant.pageObjects.HomePage;
import com.be.Cognizant.pageObjects.StockPriceValidation;
import com.be.Cognizant.pageObjects.VerifyBeCognizant;
import com.be.Cognizant.utilities.DriverSetup;
import com.be.Cognizant.utilities.Screenshot;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Main {
	public WebDriver driver;
	HomePage homePage;
	AcronymsVerification acronymVerification;
	StockPriceValidation stockPriceValidation;
	VerifyBeCognizant verifyBeCognizant;
	Screenshot screenshot;
	
	@Parameters({"browser"})
	  @BeforeClass
	  
	  public void beforeClass(String brows) throws InterruptedException {
          driver=DriverSetup.getDriver(brows);			  
		  homePage=new HomePage(driver);
		  acronymVerification=new AcronymsVerification(driver);
		  stockPriceValidation=new StockPriceValidation(driver);
		  verifyBeCognizant= new VerifyBeCognizant(driver);	
		  screenshot=new Screenshot(driver);
	  }
	
  @Test(priority=1)
  public void validateUserInformation() throws InterruptedException {
	
	 String[] userDetails= homePage.getUserDetails();
	 String[] actual= {
			 "Gowda, Nikitha (Contractor)","2327089@cognizant.com"
	 };
	 Assert.assertEquals(actual,userDetails);  
  }
  
  @Test(priority=2)
  void validateClickCompany() throws InterruptedException {
	  acronymVerification.clickCompanyMenu();
	   
  }
  @Test(priority=3)
  void validateClickAcronym() throws InterruptedException {
	  
	  acronymVerification.clickAcronym();  
  }
  
  
  @Test(priority=4)
  void validateAcronymIsDisplayed() throws InterruptedException {
	  String title=acronymVerification.getAcronymTitle();
	  Assert.assertEquals("Acronyms",title);  
  }
  
  @Test(priority=5)
  void toolTipTitle() throws InterruptedException {
	  String toolTipTitle=acronymVerification.getToolTip();
	  Assert.assertEquals("Acronyms",toolTipTitle); 	  
  }
  
  @Test(priority=6)
  void validatePrintAcronyms() {
	  acronymVerification.getNoOfRows();
	  acronymVerification.printTitles();	  
  }
  
  @Test(priority=7)
  void validateBeCognizantHomePage() throws InterruptedException {
	  
	  Assert.assertEquals(verifyBeCognizant.verifyBeCognizantTitle(),"Be.Cognizant - Home");  
  }
  
  @Test(priority=8)
  void validateStockPrice() throws InterruptedException {
	  stockPriceValidation.getStockPrice();
  }
  
  @Test(priority=9)
  void validateGoogleStockPrice() throws InterruptedException {
	  Assert.assertEquals(stockPriceValidation.getStockPrice(),stockPriceValidation.getStockPriceFromGoogle());
  }
  
  @Test(priority=10)
  void validatePastStockPrice() throws IOException {
	  stockPriceValidation.printPastData();
  }
  


  @AfterClass
  public void afterClass() {
	  DriverSetup.driverTearDown();
  }
}
