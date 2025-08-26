package com.orangehrm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_Pagefactory {
		@FindBy(name="username")
		WebElement uname;
		@FindBy(name="password")
		WebElement pword;
		@FindBy(xpath="//button[@type='submit']")
		WebElement loginbutton;
		
		public void enterusername(String username)
		{
			uname.sendKeys(username);
		}
		
		public void enterpassword(String password)
		{
			pword.sendKeys(password);
		}
		
		public void clickonlogin()
		{
			loginbutton.click();
		}
		
	}