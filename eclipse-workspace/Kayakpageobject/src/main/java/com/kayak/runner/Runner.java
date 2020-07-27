package com.kayak.runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "C:\\Users\\sweet\\eclipse-workspace\\Kayakpageobject\\src\\main\\java\\com\\kayak\\features",
		 glue={"com/kayak/stepdefinitions"})
public class Runner  {
	
}
