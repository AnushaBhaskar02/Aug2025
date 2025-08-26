package pack5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q06 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      // Open URL
      driver.get("https://the-internet.herokuapp.com/checkboxes");
      driver.manage().window().maximize();

      // Locate checkboxes
      WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
      WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

      // Select both checkboxes if not already selected
      if (!checkbox1.isSelected()) {
          checkbox1.click();
      }
      if (!checkbox2.isSelected()) {
          checkbox2.click();
      }

      // Verify both are checked
      if (checkbox1.isSelected() && checkbox2.isSelected()) {
          System.out.println("✅ Test Passed: Both checkboxes are selected.");
      } else {
          System.out.println("❌ Test Failed: One or both checkboxes are not selected.");
      }
  }
}