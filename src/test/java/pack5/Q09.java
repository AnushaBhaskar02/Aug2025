package pack5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q09 {
  @Test
  public void f() throws IOException {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://www.wikipedia.org/");
      driver.manage().window().maximize();

      TakesScreenshot ts = (TakesScreenshot) driver;
      File src = ts.getScreenshotAs(OutputType.FILE);

      File dest = new File("homepage.png");
      FileUtils.copyFile(src, dest);
      System.out.println("Screenshot saved as homepage.png");
      }
}
