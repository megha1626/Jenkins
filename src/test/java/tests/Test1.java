package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.log.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	static ChromeDriver driver;
	@Test(dataProvider="create")
	public static void firstest(String str1,String str2) throws MalformedURLException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions c=new ChromeOptions();
		System.out.println("user:"+str1+" pass:"+str2);
		c.addArguments("--headless=chrome") ;
		c.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(c);
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		devtools.send(Log.enable());
		devtools.addListener(Log.entryAdded(), logEntry->{
			System.out.println("Request id:"+logEntry.getNetworkRequestId());
			System.out.println("URL:"+logEntry.getUrl());
			
			
		});
		Map coordinates = new HashMap() {
			{
			     put("latitude", 34.0549);
			     put("longitude",-118.243683);
			     put("accuracy", 1);
			 }
		    };
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		//Action class
		driver.get("https://where-am-i.org/");
		driver.quit();
}
	
	@DataProvider(name="create")
	public Object[][] dataset(){
		return new Object[][]{
			{"test1","pass1"},
			{"test2","pass2"},
			{"test3","pass3"}
		};
		
	}
}