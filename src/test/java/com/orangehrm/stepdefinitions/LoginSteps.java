package com.orangehrm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;

	@Given("Launch the Browser")
	public void launch_the_browser() {
		// Write code here that turns the phrase above into concrete actions

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

	}

	@Given("Navigate to the URL")
	public void navigate_to_the_url() {
		// Write code here that turns the phrase above into concrete actions

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@When("Enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}
	@When("Enter the invalid username and password")
	public void enter_the_invalid_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("fgdfgdfg");
		driver.findElement(By.name("password")).sendKeys("admin123fgdf");

	}

	@When("Click on Login Button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		if(title.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Login Suucessfull");
		}
		else
		{
			System.out.println("Login unSuucessfull");
		}
	}

	@Then("verify dashboard")
	public void verify_dashboard() {
		// Write code here that turns the phrase above into concrete actions
		String expectedTitle = "OrangeHRM";   // or Dashboard page title
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Dashboard verification successful");
		} else 
		{
			Assert.fail("Expected title: " + expectedTitle + " but found: " + actualTitle);
			System.out.println("Dashboard verification failed");
		}


	}@Then("Login should be unsuccessful")
	public void login_should_be_unsuccessful() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement error=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		if(error.isDisplayed()) {
			System.out.println("login unsuccessful");
		}
	}
	

//	@Then("verify error message")
//	public void verify_error_message() {
//	    WebElement errorElement = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
//	    String actualMessage = errorElement.getText();
//	    String expectedMessage = "Invalid credentials";
//	    
//	    Assert.assertEquals(actualMessage, expectedMessage, "❌ Error message mismatch!");
//	    System.out.println(" Error message verified: " + actualMessage);
//	}


	@Then("Close the Browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}