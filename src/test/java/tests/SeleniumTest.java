package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumTest    {
	public static WebDriver driver;
	@Test
	public static void firstest() throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(c);
		
		//Action class
		driver.get("https://www.flipkart.com/");
	
		
	}
}
