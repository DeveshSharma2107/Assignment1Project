package com.visionit.automation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LandingPageObjects {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);

//	private static final String Price_updated = null;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String ExpectedFirstPage_URl = "https://www.candere.com/";
//	private String  Price_updated;

	
	public LandingPageObjects(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		
		
		
	}
	
	//locators
	private By SearchBoxele = By.id("search");
	private By SearchtxtEle =By.xpath("//div[text()='Majestic Solitaire Diamond Ring ']");
	private By dropdownEle = By.id("mt_size");
	//private By priceUpdateEle = By.xpath("//div[text()='"+Price_updated+"']");

	
	//methods
	public void SearchProduct (String prodname) {
		
		
		WebElement SearchBoxelement = driver.findElement(SearchBoxele);
		SearchBoxelement.sendKeys(prodname);
		logger.info("send the keys in the searchbox as => "+prodname);
		//SearchtextElement.getText();
//		wait.until(ExpectedConditions.titleContains(driver.getTitle()));
//		ScreenshotPage.Screenshotcap(driver, "Test2Screenshot");
	}
	public void SearchProductTitleValidation () {
	//	WebElement SearchtextElement= driver.findElement(SearchtxtEle);
		wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		Assert.assertEquals("Element is not displayed on screen,so title is not valid ",ExpectedFirstPage_URl,driver.getCurrentUrl());
		logger.info("Right element is visible in search box ");
	}
	
	public void product_displayed() throws InterruptedException {
		WebElement SearchtextElement = driver.findElement(SearchtxtEle);
		wait.until(ExpectedConditions.elementToBeClickable(SearchtextElement));
		SearchtextElement.click();
//		scn.log("element is clicked");
	//	wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		Thread.sleep(5000);
	}
	
	public void Ring_Selection_1 (String ringSize) {
		WebElement DropDownElement = driver.findElement(dropdownEle);
		Select select = new Select (DropDownElement);
		select.selectByVisibleText(ringSize);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", DropDownElement);
		wait.until(ExpectedConditions.visibilityOf(DropDownElement));
	}
	
	public void Ring_Selection_2 (String ringSize2 ,String Price_updated) {
		WebElement DropDownElement = driver.findElement(dropdownEle);
		Select select = new Select (DropDownElement);
		select.selectByVisibleText(ringSize2);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", DropDownElement);
		WebElement PriceUpdateElement = driver.findElement(By.xpath("//div[text()='"+Price_updated+"']"));
		wait.until(ExpectedConditions.visibilityOf(PriceUpdateElement));
	
		
		if(PriceUpdateElement.isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("price tag is updated");
		}else
		{
			Assert.fail();
			logger.info("price tag is not updated");
		}
	
	}
	
	


}
