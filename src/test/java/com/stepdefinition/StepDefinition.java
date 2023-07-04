package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;

import com.pom.Home_Page;
import com.testrunner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	public WebDriver driver =TestRunner.driver;
	
	Home_Page hp = new Home_Page(driver);
	
	
	@Given("User launch the url {string}")
	public void user_launch_the_user(String string) {
	    launchUrl(string);
	}
	@When("click the element to select shop men it navigates to men Page")
	public void click_the_element_to_select_shop_men_it_navigates_to_men_page() throws Exception {
		Thread.sleep(5000);
	    hp.getShopForMen().click();
	}	




}
