package pack4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pagefactory {
	WebDriver driver;
	@FindBy(name = "username")
	WebElement uname;

	@FindBy(name = "password")
	WebElement pword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;
	public login_pagefactory(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		Thread.sleep(3000);
		PageFactory.initElements(driver, this);
	}
	public void enterusername(String username) throws InterruptedException
	{
		Thread.sleep(2000);

		uname.sendKeys(username);
	}


	public void enterpassword(String password) throws InterruptedException
	{
		Thread.sleep(1000);
		pword.sendKeys(password);
	}


	public void clickonlogin()
	{
		loginbutton.click();
	}

}
