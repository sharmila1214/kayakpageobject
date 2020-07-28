package com.kayak.utilitity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop ;
	public static Properties props;
	public static Testutil oU_utility = new Testutil();
	 Logger log=Logger.getLogger(getClass().getSimpleName());
	
	
	public static WebDriver initialisation() throws IOException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sweet\\eclipse-workspace\\Kayakpageobject\\src\\main\\java\\com\\kayak\\testdata\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver()	.setup();
			
		
		driver= new ChromeDriver();
		
		
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		return driver;
	}
	public  void loadlog4jproperty() throws Exception 
	{
		String log4path="C:\\Users\\sweet\\eclipse-workspace\\Kayakpageobject\\src\\main\\java\\com\\kayak\\testdata\\log4j.properties";
		prop=new Properties();
		log.info("log4j property file path "+log4path);
		FileInputStream fi=new FileInputStream(log4path);
		prop.load(fi);
		PropertyConfigurator.configure(prop);
	}	

	public String screenShot(String result) throws IOException {
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File(prop.getProperty("screenpath"+result+"screenshot.png")));

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot)TestBase. driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
//		  
//		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "//Screenshots//" +result+ ""+dateName+ "ts1.png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
	  return destination;
	 } 
}

	
	
	
	
	
	
	
	
	
		
		

	


















