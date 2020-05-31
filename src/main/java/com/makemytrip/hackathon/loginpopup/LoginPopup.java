package com.makemytrip.hackathon.loginpopup;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.hackathon.base.ElementUtils;

public class LoginPopup extends ElementUtils {

	private static void clicklogin() {

		clickElementByxpath(LoginPageConstants.LOGIN_BUTTON);

	}

	private static void enterUsername() {
		String useremail = prop.getProperty("USERNAME_EMAIL");
		sendKeysByID("username", useremail);
	}

	private static void enterpassword() {
		String password = prop.getProperty("PASSWORD");
		sendKeysByID("password", password);
	}

	private static void clickContinueOnLoginPopup() {

		driver.findElement(By.cssSelector(LoginPageConstants.LOGIN_CONTINUE_BUTTON)).click();
		;
		new WebDriverWait(driver, 5000).until(
				ExpectedConditions.elementToBeClickable(By.cssSelector(LoginPageConstants.LOGIN_CONTINUE_BUTTON)))
				.click();
	}

	private static void clickButtonLogin() {

		new WebDriverWait(driver, 2000)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-cy$='login'"))).click();

	}

	public static void loginToMMT() {
		// Login to the make my trip web-site with login details
		clicklogin();

		// Enter User-name field on the Login pop-up
		enterUsername();

		// Click on Continue button
		clickContinueOnLoginPopup();

		// Enter Password field on the Login pop-up
		enterpassword();

		// Click Login
		clickButtonLogin();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getTitle() {

		return driver.getTitle();

	}

}
