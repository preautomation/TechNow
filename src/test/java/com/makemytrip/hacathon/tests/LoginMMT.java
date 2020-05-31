package com.makemytrip.hacathon.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.makemytrip.hackathon.base.ConfigureSetup;
import com.makemytrip.hackathon.loginpopup.LoginPopup;

public class LoginMMT extends ConfigureSetup {

	@BeforeClass
	public static void setupenvironment() {
		ConfigureSetup.setupenvironment();
	}

	// Verify Login to Make my trip
	@Test
	public void Login() {
		LoginPopup.loginToMMT();
		String title = LoginPopup.getTitle();
		Assert.assertTrue(title.startsWith("MakeMyTrip"), "Title mismatch...");

	}

	// Verify apply Search Hotels with City CheckinDate CheckOutDate Rooms and Guests
	@Test
	public void searchHotel() {

		LoginPopup.loginToMMT();

		// Select Hotels Tab
		driver.findElement(By.cssSelector("span.chNavIcon.appendBottom2.chSprite.chHotels")).click();

		// Click on the City/Hotel/Area/Building drop-down
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(text(),'City / Hotel / Area / Building')]"))).click();

		// Enter Delhi in the City Selection drop down
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]"))
				.sendKeys("Delhi");

		// Select the first element from the search
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();

		// Select a checking date from the date panel
		WebElement checking = driver
				.findElement(By.cssSelector("div[class='DayPicker-Day'][aria-label='Wed Jun 03 2020']"));
		WebElement webElement = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(checking));
		webElement.click();

		// Selecting the Checkout date
		WebElement checkoutdate = driver
				.findElement(By.cssSelector("div[class='DayPicker-Day'][aria-label='Sat Jun 06 2020']"));
		WebElement checkout = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(checkoutdate));
		checkout.click();

		// Selecting Guests
		driver.findElement(By.id("guest")).click();
		driver.findElement(By.cssSelector("li[data-cy='adults-2")).click();
		driver.findElement(By.cssSelector("li[data-cy='children-2")).click();

		// Apply Guest Search
		driver.findElement(By.cssSelector("button[data-cy='submitGuest']")).click();

		// Traveling Reason
		driver.findElement(By.cssSelector("div[class*='travelFor']")).click();
		driver.findElement(By.cssSelector("li[data-cy='travelFor-Leisure")).click();

		// Click On Search button on Hotels Page
		WebElement search = driver.findElement(By.id("hsw_search_button"));
		WebElement searchHotel = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(search));
		searchHotel.click();

	}

	@AfterClass
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
