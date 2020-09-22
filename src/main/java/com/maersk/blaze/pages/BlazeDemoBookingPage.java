package com.maersk.blaze.pages;

import com.maersk.blaze.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BlazeDemoBookingPage extends TestBase {


	// Initializing the Page Objects:
	public BlazeDemoBookingPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectValueFromdepartureDropDown(String cityName){
		Select cityNameDropDown = new Select(driver.findElement(By.name("fromPort")));
		cityNameDropDown.selectByVisibleText(cityName);

	}

	public void selectValueFromToDropDown(String cityName){
		Select cityNameDropDown = new Select(driver.findElement(By.name("toPort")));
		cityNameDropDown.selectByVisibleText(cityName);

	}
	public void clickOnFindFlight(){
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	public void chooseFirstFlight(){
		WebElement element = (new WebDriverWait(driver, 45))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]/td[1]")));
		driver.findElement(By.xpath("//tr[1]/td[1]")).click();

	}
	public void fillTheFlightDetailsForm(String labelName,String value){
		WebElement element = (new WebDriverWait(driver, 45))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Purchase Flight']")));

		driver.findElement(By.xpath("//label[contains(text(),'"+labelName+"')]/../div/input")).clear();
		driver.findElement(By.xpath("//label[contains(text(),'"+labelName+"')]/../div/input")).sendKeys(value);

	}
	public void clickOnPurchaseFlight(){

		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

	}

	public void verifyTextAfterBooking(String Message){

		WebElement element = (new WebDriverWait(driver, 45))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='container hero-unit']/h1")));


		String actualMessage = driver.findElement(By.xpath("//div[@class='container hero-unit']/h1")).getText();
		Assert.assertEquals(actualMessage,Message);

	}
	public void sucessIDGeneratedAfterBooking(){
		boolean flag;
		String idGen = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
		System.out.println("ID Generated is "+idGen);
		for (char c : idGen.toCharArray())
		{
			if (!Character.isDigit(c))
			{
				flag =false;
			}
		}
		flag =true;
		Assert.assertTrue(flag);

	}

	public void verifFeildAttributesAfterBooking(String attributeName , String expectedMessage){
		String actual = driver.findElement(By.xpath("//td[contains(text(),'"+attributeName+"')]/../td[2]")).getText();
		Assert.assertEquals(actual,expectedMessage);

	}

}
