package com.visionit.automation.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {
	private static final Logger logger = LogManager.getLogger(FooterPage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	String Expectedfacebooktxt="Candere by Kalyan Jewellers";
	String ExpectedInstaText ="canderejewellery";
//	private String ExpectedTwitterURL = "https://twitter.com/";
	private String TwitterTitle ="Twitter. It’s what’s happening / Twitter";
	public FooterPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// locators
//	private By AboutUsEle = By.xpath("//p[text()='ABOUT US']");
	private By AboutListEle = By.xpath("//p[text()='ABOUT US']//parent::nav[@class='menu menu-mobile']/a");
	private By PageScrollEle = By.xpath("//div[@class='desktop_footer_link_item']");
	private By FacebookEle = By.xpath("//div[@class='row_group flex_group_item']/a[@class='social_icons__ fb']");
	private By FBCross = By.xpath("//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']");
	private By FaceBookLogoEle = By.xpath("//div[@class='x78zum5 x1qughib xh8yej3 xds687c xixxii4 x17qophe x13vifvy xzkaem6']");
	private By FacebookTxtEle = By.xpath("//h1[text()='Candere by Kalyan Jewellers']");
	private By InstaEle = By.xpath("//div[@class='row_group flex_group_item']/a[@class='social_icons__ insta']");
	private By InstalogoEle = By.xpath("//div[@class='_aagx']");
	private By InstaTxtEle =By.xpath("//h2[text()='canderejewellery']");
	private By TwitterEle =By.xpath("//div[@class='row_group flex_group_item']/a[@class='social_icons__ twitter']");
	private By TwCross = By.xpath("//*[local-name()='svg'and @class='r-4qtqp9 r-yyyyoo r-z80fyv r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-19wmn03']");
	//div[@role='button'][1]
	//div[@dir='ltr']
	
	
	
	
	
	private By TwittertxtEle = By.xpath("//span[text()='Happening now']");
	// Methods
	public void PageScroll() {

		WebElement FooterElement = driver.findElement(PageScrollEle);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", FooterElement);
		wait.until(ExpectedConditions.visibilityOf(FooterElement));
		logger.info("Page is scrolled to the bottom");

	}

	public void AboutUsListValidation(List<String> expectedAboutUsList) {
		List<WebElement> AboutUsListElement = driver.findElements(AboutListEle);
		for (int i = 0; i < expectedAboutUsList.size(); i++) {
			System.out.println(AboutUsListElement.get(i).getText());
			if (expectedAboutUsList.get(i).equals(AboutUsListElement.get(i).getText())) {
				Assert.assertTrue(true);

			} else {
				Assert.fail();
			}
		}
	}
	
	public void SocialMediaBrowserOpennig(String string) throws InterruptedException {
		
		switch(string){
		case "facebook":
			WebElement FaceBookElement= driver.findElement(FacebookEle);
			FaceBookElement.click();
			WebElement FBCrossEle = driver.findElement(FBCross);
			FBCrossEle.click();
			WebElement FacebooklogoElement = driver.findElement(FaceBookLogoEle );
			if(FacebooklogoElement.isDisplayed()) {
				Assert.assertTrue(true);
			}else {
				Assert.fail();
			}
			wait.until(ExpectedConditions.visibilityOf(FacebooklogoElement));
			logger.info("Test case is passed facebook is opened");
//			WebElement FacebookTextElement = driver.findElement(FacebookTxtEle);
//			Assert.assertEquals("expected text and current text is not matching so test case is failed",Expectedfacebooktxt, FacebookTextElement.getText());

			break;
		case "Instagram":	
			WebElement InstaElement= driver.findElement( InstaEle);
			InstaElement.click();
			WebElement InstaLogoElement= driver.findElement(InstalogoEle);
			if(InstaLogoElement.isDisplayed()){
				Assert.assertTrue(true);
			}else
			{
				Assert.fail();
			}
			wait.until(ExpectedConditions.visibilityOf(InstaLogoElement));
			logger.info("Test case is passed Instagram is opened");
//			WebElement InstaTextElement = driver.findElement( InstaTxtEle);
//			Assert.assertEquals("expected text and current text is not matching so test case is failed",ExpectedInstaText, InstaTextElement.getText());
			
			break;
			
		case "twitter":
		
			WebElement TwitterElement= driver.findElement(TwitterEle);
			TwitterElement.click();
			WebElement TwCrossEle = driver.findElement(TwCross);
			Thread.sleep(5000);
			TwCrossEle.click();
			Thread.sleep(5000);
		
			
//			WebElement TwitterTextElement = driver.findElement(TwittertxtEle);
			Assert.assertEquals("Twitter test case is not passed",TwitterTitle,driver.getTitle());
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));
			logger.info("Twitter test case is passed");
			break;
		default:
				System.out.println("This social media handle is not available");
				
		}
		
	}
	


		

	

}
