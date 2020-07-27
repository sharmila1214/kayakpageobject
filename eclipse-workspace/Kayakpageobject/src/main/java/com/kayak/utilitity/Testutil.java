package com.kayak.utilitity;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Testutil extends TestBase{
	Logger log = Logger.getLogger(getClass().getSimpleName());

public void waitforelementvisible( WebElement ele) {

	WebDriverWait wait=new WebDriverWait(TestBase.driver,30);
	wait.until(ExpectedConditions.visibilityOf(ele));
}
public boolean ScrollToView(WebDriver driver, WebElement ele) throws Exception {
	boolean bRes_Flag = false;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", ele);
	bRes_Flag = true;
	return bRes_Flag;
}

public void ClickUsingJS(WebDriver driver, WebElement ele) throws Exception {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ele);
}

public void ufClick(WebElement ele) throws Exception {
	ele.click();
}

public void ufSendKeys(WebElement ele, String keysToSend) throws Exception {
	ele.sendKeys(keysToSend);
}

public String ufGetText(WebElement ele) throws Exception {
	return ele.getText();
}
public boolean isDisplayed(WebElement ele) throws Exception {
	boolean bRes_flag = false;
	try {
		if (ele.isDisplayed()) {
			log.info("Displayed " + ele);
			bRes_flag = true;
		}
	} catch (Exception ea) {
		bRes_flag = false;
	}
	return bRes_flag;
}
}	



