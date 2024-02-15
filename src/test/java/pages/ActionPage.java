package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.MainClass;

public class ActionPage extends MainClass  {

public ActionPage(WebDriver driver){
		
PageFactory.initElements(BasePage.getDriver(), this);
	}
	
	
@FindBy(xpath="//div[normalize-space()='Interactions']")
public WebElement interaction;


@FindBy(xpath="")
public WebElement dragDrop;

@FindBy(xpath="")
public WebElement resize;


@FindBy(xpath="//*[name()='path' and contains(@d,'M13 13v8h8')]")
public WebElement widgets;


@FindBy(xpath="")
public WebElement slider;

@FindBy(xpath="//span[normalize-space()='Auto Complete']")
public WebElement autoComplete;


@FindBy(xpath="//span[normalize-space()='Date Picker']")
public WebElement datePicker;




}
