package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static WebDriver driver;
	static Actions a;
	
	public static WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	    driver.manage().window().maximize();
	    return driver;
	}
	
	 public static void launchUrl(String url) {
		 driver.manage().window().maximize();
		 driver.get(url);

	} 
	 
	 public static void clickOnElement(WebElement element) {
		 element.click();

	}
	 
	 public static void inputToElement(WebElement element,String value) {
		 element.sendKeys(value);

	}
	 
	 public static void screenshot(String fileName) throws IOException {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File des = new File("C:\\Users\\user\\eclipse-workspace\\Maven\\Screenshot\\"+fileName+".png");
		 FileHandler.copy(source, des);

	}
	 
	 public static void dropdownForSelect(WebElement element,String option,String value) {
		 Select s = new Select(element);
		 if (option.equalsIgnoreCase("value")) {
			 s.selectByValue(value);
			
		}
		 else if (option.equalsIgnoreCase("text")) {
			 s.selectByVisibleText(value);
		 }
		 else if (option.equalsIgnoreCase("index")) {
			 int index = Integer.parseInt(value);
			 s.selectByIndex(index);
			 
			 
		 }
		 
	 }
	 
	 public static  void switchToFrame(String option,String value) {
		 if (option.equalsIgnoreCase("index")) {
			 int index = Integer.parseInt(value);
			 driver.switchTo().frame(index);
			 
		 }
		 
		 else if (option.equalsIgnoreCase("idOrName")) {
			 driver.switchTo().frame(value);
			 
		 }
			
	 }
	   
	 public static void switchFrameById(String id) {
		 driver.switchTo().frame(id);
	 }
	 
	 public static void switchFrameByElement(WebElement element) {
		 driver.switchTo().frame(element);
	 }
	 
	 public static void switchWindow(int index) {
		 Set<String> all_tab = driver.getWindowHandles();
		 List<String> tab_list = new ArrayList<String>(all_tab);
		 driver.switchTo().window(tab_list.get(index));
	 }

	  public static void SwitchToWindow(String tab_id) {
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> itr = set.iterator();
		  while(itr.hasNext()) {
			  String id =itr.next();
			  if(id==tab_id) {
				  driver.switchTo().window(id);
			  }
		  }
	  }
	  
	  public static void actions(WebElement element,String option) {
		  Actions a = new Actions(driver);
		  if (option.equalsIgnoreCase("move")) {
			  a.moveToElement(element).build().perform();
			
		}
		  else if(option.equalsIgnoreCase("rightclick")) {
			  a.contextClick(element).build().perform();
		  }
		  
		  else if(option.equalsIgnoreCase("doubleclick")) {
			  a.doubleClick(element).build().perform();
		  }
	  }
	  
	  public static void alert(String option) {
		  Alert alert = driver.switchTo().alert();
		  
		  if (option.equalsIgnoreCase("ok")) {
			  alert.accept();
			  
		  }else if(option.equalsIgnoreCase("cancel")) {
			  alert.dismiss();
			  
		  }else if(option.equalsIgnoreCase("gettext")) {
			  String text = alert.getText();
			  System.out.println(text);
			  driver.switchTo().alert();
		  }
			  
			  
			
		
	  }

	}



