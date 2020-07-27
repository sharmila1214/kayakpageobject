package com.kayak.listners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.kayak.utilitity.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

public class ExtentReport extends  TestBase{
		  static TestBase bm = new TestBase();
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	public static   void extentRep() throws IOException {
		
		SimpleDateFormat simpledateformatter = new SimpleDateFormat("'sampledemo_'yyyyMMddHHmm'.html'");
		Date currentDate =new Date();
		String filename = simpledateformatter.format(currentDate);
		//String path = prop.getProperty("path")+filename;
	
		 
		
		 String spath=System.getProperty("user.dir")+"/KayakReport2/myReport2.html";
		 htmlReporter = new ExtentHtmlReporter(spath);
		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  htmlReporter.config().setTheme(Theme.DARK);
		 
	      // return reports=new ExtentReports(spath);
	     
		String path="C:\\Users\\sweet\\eclipse-workspace\\Kayakpageobject\\Kayakreports\\myreport.html";
		reports = new ExtentReports(spath);
		 logger = reports.startTest("Kayak");
	}

	}

