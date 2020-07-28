package com.kayak.pages;





import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kayak.utilitity.TestBase;





public class HomePage extends TestBase{
	Logger log = Logger.getLogger(getClass().getSimpleName());

	WebDriver driver;
	String origin;
	public  HomePage(WebDriver driver) {
		//super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//div[@data-placeholder='From?'][@aria-label='Flight origin input']")
    WebElement clickoriginbutton;

   @FindBy(xpath="//input[@placeholder='From?'][@name='origin']")
  WebElement Enterorigin;

   @FindBy(xpath="//div[contains(text(),'Hyderabad, India')]")
   WebElement Selectorigin1;
 
   
   //@FindBy(xpath=" //ul[@class='flight-smarty']")
   //WebElement Selectorigin1;
   
   @FindBy(xpath="//div[@data-placeholder='To?'][@aria-label='Flight destination input']")
   WebElement clickDestinationbutton;
   
   @FindBy(xpath="//input[@placeholder='To?'][@name='destination']")
   WebElement EnterDesti;
   
   @FindBy(xpath="//div[contains(text(),'Bengaluru, India')]")
   WebElement SelectDesti1;
    
   
   @FindBy(xpath="(//div[@aria-label='Departure date input']//div[@data-placeholder='Depart'])[1]")
   WebElement clickDepartdate;
   
   @FindBy(xpath="//div[@id='stl-jam-cal-202007']//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19'][contains(text(),'31')]")
   WebElement SelectDepartdate;
   
   @FindBy(xpath="//div[@id='stl-jam-cal-202008']//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19'][contains(text(),'30')]")
   WebElement Selectreturndate;
   
   @FindBy(xpath="(//button[@title='Search flights'][@type='submit'])[1]")
 WebElement Searchbutton;

   @FindBy(xpath="//button[@aria-label='Close'][contains(@id,'covid-loading-dialog-close')]")	
   WebElement popup;

   @FindBy(xpath="//div[@id='searchResultsList'][@class='Base-Results-ResultsList Flights-Results-FlightResultsList']")	
   WebElement Selectflight;

@FindBy(xpath="(//div[@class='Flights-Results-FlightLegDetails']//span[@class='origin-destination'])[1]")	
	
 //@FindBy(xpath="//section[@id='avmM-details-leg-details']//div[@id='ESJ6']")  
   WebElement Validate;

public void selectoriginanddestination(String origin,String Destin) throws Exception {
	oU_utility.waitforelementvisible(clickoriginbutton);
	oU_utility.ufClick(clickoriginbutton);
	log.info("origin successfully clicked");
	
	oU_utility.waitforelementvisible(Enterorigin);
	oU_utility.ufSendKeys(Enterorigin,origin);
	log.info("origin successfully entered");
	
	oU_utility.waitforelementvisible(Selectorigin1);
	oU_utility.ufClick(Selectorigin1);
	
	log.info("origin successfully selected");
	
	oU_utility.waitforelementvisible(clickDestinationbutton);
	oU_utility.ufClick(clickDestinationbutton);
	log.info("Destination successfully clicked");
	
	oU_utility.waitforelementvisible(EnterDesti);
	oU_utility.ufSendKeys(EnterDesti,Destin);
	log.info("Destination successfully Entered");
	
	oU_utility.waitforelementvisible(SelectDesti1);
	oU_utility.ufClick(SelectDesti1);
	log.info("Destination successfully selected");
	
	
}

public void selectdates() throws Exception{
	oU_utility.waitforelementvisible(clickDepartdate);
	oU_utility.ufClick(clickDepartdate);
	log.info("departure date clicked");
	
	oU_utility.waitforelementvisible(SelectDepartdate);
	oU_utility.ufClick(SelectDepartdate);
	log.info("departure date selected");
	
	oU_utility.waitforelementvisible(Selectreturndate);
	oU_utility.ufClick(Selectreturndate);
	log.info("departure date selected");
}



public void clicksearch() throws Exception {
	oU_utility.waitforelementvisible(Searchbutton);
	oU_utility.ufClick(Searchbutton);
	log.info("search button clicked");
	
	oU_utility.waitforelementvisible(popup);
	oU_utility.ufClick(popup);
	
}

public void selectflight() throws Exception {
	oU_utility.waitforelementvisible(Selectflight);
	oU_utility.ufClick( Selectflight);
	log.info("flight selected");
	oU_utility.ScrollToView(driver, Selectflight);
//	List<WebElement> flights=Selectflight;
//	for(int count=0;count<flights.size();count++)	{
//		System.out.println(flights.size());
//		//flights.get(count).click();
//oU_utility.ScrollToView(driver, flights.get(0));
//	
//	System.out.println("flight selected");
//	log.info("flight selected");
//	flights.get(count).click();
//	System.out.println("success");
//	//Thread.sleep(3000);
//	}	
}
public void validate(String city) throws InterruptedException {
	//Thread.sleep(2000);
	oU_utility.waitforelementvisible(Validate);
	String expectedresult=Validate.getText();
	System.out.println(expectedresult);
	String actualresult=city;
	
	if(actualresult.equals(expectedresult)) {
		System.out.println("both are same");
	}
	Assert.assertEquals(expectedresult,actualresult,"both are same");

}
}
