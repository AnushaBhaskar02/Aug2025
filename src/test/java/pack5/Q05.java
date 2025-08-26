package pack5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q05 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
      driver.manage().window().maximize();

      driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

      driver.switchTo().alert().accept();

      WebElement result = driver.findElement(By.id("result"));
      String resultText = result.getText();

      if (resultText.equals("You successfully clicked an alert")) {
          System.out.println("✅ Test Passed: Alert handled successfully!");
      } else {
          System.out.println("❌ Test Failed: Actual text is " + resultText);
      }

      driver.quit();
  }
}
