package utils;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pages.BasePage;

public class MainClass {

	
	@Parameters({ "browserName"})
	@BeforeClass
	public void setup(String browserName) {
		
		try {
			BasePage.initDriver(browserName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
