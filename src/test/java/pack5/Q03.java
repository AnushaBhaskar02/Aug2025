package pack5;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Q03 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String search) {
	  driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(search);
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  List<WebElement> prodtitle = driver.findElements(By.cssSelector("h2.a-size-medium"));
	  for(int i =0;i<5;i++) {
		  String title = prodtitle.get(i).getAttribute("aria-label");
		  System.out.println((i+1)+": "+title);
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "laptop" },
    };
  }
}