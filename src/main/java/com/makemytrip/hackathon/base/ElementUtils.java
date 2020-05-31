package com.makemytrip.hackathon.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtils extends ConfigureSetup {

	public static WebElement findElementByxpath(String xpath) {

		return driver.findElement(By.xpath(xpath));

	}

	public static void clickElementByxpath(String xpath) {
		findElementByxpath(xpath).click();

	}

	public static WebElement findElementByID(String id) {
		return driver.findElement(By.id(id));

	}

	public static void sendKeysByID(String id, String value) {
		findElementByID(id).clear();
		findElementByID(id).sendKeys(value);

	}

}
