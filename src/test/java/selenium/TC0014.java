package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0014 {
	@Parameters("browser")
  @Test
  public void test2(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
	  System.out.println("this is chrometest2");
	  WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.in/");
	  }
	  else if(browser.equalsIgnoreCase("edge")){
		  System.out.println("this is edgetest2");
		  WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
			driver.get("https://www.flipkart.in/");  
	  }
  }
}
