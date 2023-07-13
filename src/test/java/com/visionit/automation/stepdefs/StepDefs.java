package com.visionit.automation.stepdefs;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageObjects.FooterPage;
import com.visionit.automation.pageObjects.LandingPageObjects;
import com.visionit.automation.pageObjects.ScreenshotPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;

public class StepDefs {

	private static final Logger logger = LogManager.getLogger(StepDefs.class);

	WebDriver driver;
	WebDriverWait wait;
	int implicit_wait_timeout_in_sec = 10;
	String Base_URL = "https://www.candere.com/";
	//String ExpectedpriceText = "Price updated";
	Scenario scn;
	String ScreenshotFileName = "Cap1";
	// obj creation
	LandingPageObjects landingpageobjects;
	FooterPage footerPage;

	@Before
	public void setup(Scenario scn) throws Exception {
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser is invoked");
		driver.manage().window().maximize();
		logger.info("Browser is maximised");
		scn.log("Browser is maximised");
		wait = new WebDriverWait(driver, 35);
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		logger.info("implicit wait timeout in sec is set as => " + implicit_wait_timeout_in_sec);
		driver.get(Base_URL);
		landingpageobjects = new LandingPageObjects(driver, wait);
		footerPage = new FooterPage(driver, wait);
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-Automation"));
		// options.addArguments("--disable-notifications");

	}

	@After(order = 1)
	public void TearDown() {
		WebDriverFactory.quitDriver();
		scn.log("Browser is closed");
		logger.info("Browser is closed");

	}

	@After(order = 2)
	public void TakeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot scrnshot = (TakesScreenshot) driver;
			byte[] data = scrnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Failed step Name " + scenario.getName());
		} else {
			scn.log("Test case is passed,Screenshot is not captured");
		}

	}

	@Given("User navigated to the home Application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(Base_URL);
		scn.log("page url is -> " + Base_URL);
		logger.info("Base URl is => " + Base_URL);
	}

	@When("title page is displayed")
	public void title_page_is_displayed() {
		driver.getTitle();
	}

	@Then("page title is validated as {string}")
	public void page_title_is_validated_as(String ExpectedTitlePage1) {
		Assert.assertEquals("page 1 title is -: ", ExpectedTitlePage1, driver.getTitle());
		scn.log("title validation is successful with title name as -> " + driver.getTitle());
		logger.info("title of page 1 is => " + driver.getTitle());
//		wait.until(ExpectedConditions.titleContains(ExpectedTitlePage1));
//		ScreenshotPage.Screenshotcap(driver, "test1Screenshot");
//		scn.log("Screenshot is captured");
	}

	@Given("navigate to the application Url")
	public void navigate_to_the_application_url() {
		driver.get(Base_URL);
	}

	@When("user search for the product {string}")
	public void user_search_for_the_product(String prodName) {

		landingpageobjects.SearchProduct(prodName);
	}

	@Then("product is displayed as searched result {string}")
	public void product_is_displayed_as_searched_result(String string) {
		landingpageobjects.SearchProductTitleValidation();
	}

	@When("user search for the product as {string}")
	public void user_search_for_the_product_as(String productName) {
		WebElement SearchBoxelement = driver.findElement(By.id("search"));
		SearchBoxelement.sendKeys(productName);

	}

	@When("product is displayed as  {string}")
	public void product_is_displayed_as(String string) throws InterruptedException {
		landingpageobjects.product_displayed();

	}

	@Then("user click on the product and title should contain {string}")
	public void user_click_on_the_product_and_title_should_contain(String ExpectedTitlePage2) {
		Assert.assertEquals("Page 2 title is -: ", ExpectedTitlePage2, driver.getTitle());
		scn.log("page 2 title validation is successful with title => " + driver.getTitle());

	}

	@Then("select ring size from dropdown as {string}")
	public void select_ring_size_from_dropdown_as(String ringSize) {

		landingpageobjects.Ring_Selection_1(ringSize);

	}
	@Then("again select the ring size from the drop down as {string} and popup should be displayed as {string}")
	public void again_select_the_ring_size_from_the_drop_down_as_and_popup_should_be_displayed_as(String ringSize2, String Price_updated) {
		landingpageobjects.Ring_Selection_2(ringSize2 ,Price_updated);
	}

//	@Then("again select the ring size from the drop down as {string}")
//	public void again_select_the_ring_size_from_the_drop_down_as(String ringSize2) {
//		
//		
//	}

	@When("User scroll down to the footer about us section")
	public void user_scroll_down_to_the_footer_about_us_section() {

		footerPage.PageScroll();
	}

	@Then("under footer section following about us options will be available")
	public void under_footer_section_following_about_us_options_will_be_available(List<String> expectedAboutUsList) {

		footerPage.AboutUsListValidation(expectedAboutUsList);

	}

	@When("user scroll down to the footer follow us section")
	public void user_scroll_down_to_the_footer_follow_us_section() {

		footerPage.PageScroll();

	}

	@When("User click on follows us section {string}")
	public void user_click_on_follows_us_section(String string) throws InterruptedException {

		footerPage.SocialMediaBrowserOpennig(string);

	}

	@Then("new Tab should be opened containing social media handle name {string}")
	public void new_tab_should_be_opened_containing_social_media_handle_name(String string) {

	}

}
