package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static ThreadLocal<WebDriver> threadloal=new ThreadLocal<WebDriver>();
	
	
	public synchronized static void initDriver(String browserName) throws MalformedURLException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  

		System.out.print(dtf.format(now)+" ----Broweser is : "+browserName+"");
		if(browserName.equals("chrome"))
		{
			/*
			 * ChromeOptions browserOptions = new ChromeOptions();
			 * browserOptions.setPlatformName("Windows 11");
			 * browserOptions.setBrowserVersion("latest"); Map<String, Object> sauceOptions
			 * = new HashMap<String, Object>(); sauceOptions.put("username",
			 * "oauth-meghavivek1626-65656"); sauceOptions.put("accessKey",
			 * "a8a17db8-3717-4911-a302-efae149bf28a"); sauceOptions.put("build",
			 * "selenium-build-A0YJQ"); sauceOptions.put("name",
			 * "First test on sauce labs"); browserOptions.setCapability("sauce:options",
			 * sauceOptions);
			 * 
			 * 
			 * URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			 */
			
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions c=new ChromeOptions();
			
		
			c.addArguments("--remote-allow-origins=*");
		
			threadloal.set( new ChromeDriver(c)) ;
			
	}
		
		
		else {
			/*
			 * FirefoxOptions browserOptions = new FirefoxOptions();
			 * browserOptions.setPlatformName("Windows 11");
			 * browserOptions.setBrowserVersion("latest"); Map<String, Object> sauceOptions
			 * = new HashMap<String, Object>(); sauceOptions.put("username",
			 * "oauth-meghavivek1626-65656"); sauceOptions.put("accessKey",
			 * "a8a17db8-3717-4911-a302-efae149bf28a"); sauceOptions.put("build",
			 * "selenium-build-A0YJQ"); sauceOptions.put("name",
			 * "First test on sauce labs"); browserOptions.setCapability("sauce:options",
			 * sauceOptions); URL url = new
			 * URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			 * threadloal.set(new RemoteWebDriver(url, browserOptions)) ;
			 */
			
			WebDriverManager.firefoxdriver().setup();
			
		
			threadloal.set( new FirefoxDriver()) ;
			
		}
			
		
		
	}
	
	/**
	 * This methods gets a driver's instance for the desired browser.
	 */
	public synchronized static WebDriver getDriver() {
		return threadloal.get();
	}
}
