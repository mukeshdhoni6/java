package com.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\user\\cucumber-workspace\\LimeRoad\\src\\test\\java\\com\\feature\\LimeRoad.feature",
glue = "com.stepdefinition" ,
monochrome =true,
dryRun = true,



tags = "@smoketest",
plugin = {"pretty",
		 "html:Resources/limeroad.html",
		 "json:Resources/limeroad.json",
		 "com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} 
)


 
public class TestRunner extends BaseClass{
	
	public static WebDriver driver;
	
	@BeforeClass
     public static void getDriver() {
		driver =getDriver("chrome");

	}
	


}
