package modules;

import pages.ActionPage;
import pages.BasePage;

import utils.MainClass;

public class ActionModule extends MainClass{
	
	
	
	
	public static ActionPage actionLocators() {
		return new ActionPage(BasePage.getDriver());
	}
	
	
	public static void clickWidgets() {
		BasePage.getDriver().get("https://www.google.com/");
		actionLocators().widgets.click();
	}
}
	
	
	
	
	
