package com.kayak.stepdefinitions;



import java.io.IOException;

import com.kayak.listners.ExtentReport;
import com.kayak.pages.HomePage;
import com.kayak.utilitity.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageSteps extends TestBase{
HomePage hm;
	@Before
	public void setup() throws IOException {
		System.out.println("inside setup");
		driver=initialisation();
		ExtentReport.extentRep();
		
	}

	@Given("^launching the browser with url$")
	public void launching_the_browser_with_url() throws Throwable {
		driver.get("https://www.kayak.com.my/flights");
		driver.manage().window().maximize();
		   ExtentReport.logger.log(LogStatus.INFO, "opened kayak website ");
			


	}


	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" cities$")
	public void enter_and_cities(String arg1, String arg2) throws Throwable {
	    hm=new HomePage(driver);
	    hm.selectoriginanddestination(arg1,arg2);
	    ExtentReport.logger.log(LogStatus.INFO, "Entered origin and destination cities");
		   
	
	
	}




	@And("^Select dates from calender$")
	public void select_dates_from_calender() throws Throwable {
	  hm=new HomePage(driver);
	  hm.selectdates(); 
	  ExtentReport.logger.log(LogStatus.PASS, "selected dates from calender");
	}

	@When("^click on search button$")
	public void click_on_search_button() throws Throwable {
	 hm=new HomePage(driver);
	 hm.clicksearch();   
	}

	@Then("^selecting flight from list$")
	public void selecting_flight_from_list() throws Throwable {
	 
	  hm=new HomePage(driver) ;
	  hm.selectflight();
	  
	  ExtentReport.logger.log(LogStatus.INFO, "flight selected from the list");
	}

	
	@Then("^vaidating origin and destination \"([^\"]*)\"$")
	public void vaidating_origin_and_destination(String arg1) throws Throwable {
	   Thread.sleep(2000);
		hm=new HomePage(driver);
		hm.validate(arg1);
	    ExtentReport.logger.log(LogStatus.PASS, "validation done successfully");
	}

	@After
	public void tearDown() {
		ExtentReport.reports.endTest(ExtentReport.logger);
		ExtentReport.reports.flush();
		driver.quit();
	}
}
