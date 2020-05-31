package com.makemytrip.hackathon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigureSetup {

	public static WebDriver driver;
	public static Properties prop;

	static String liveEnv = "https://www.makemytrip.com/";

	public static void setupenvironment() {

		readConfigFile();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		System.out.println("===== Setup environment done=====");
		System.out.println("You are about to hit the url   : " + prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	public static void readConfigFile() {

		try {
			prop = new Properties();

			String configpropertiespath = "D:\\Learnings\\HeadSpinAutomation\\HeadSpinAutomationMMT\\src\\main\\java\\com\\makemytrip\\hackathon\\config\\config.properties";
			FileInputStream ip = new FileInputStream(configpropertiespath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

}
