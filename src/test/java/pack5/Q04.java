package pack5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q04 {
  @Test
  public void f() {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://www.selenium.dev/selenium/web/web-form.html");
      driver.manage().window().maximize();

      WebElement dropdownElement = driver.findElement(By.name("my-select"));

      Select dropdown = new Select(dropdownElement);

      dropdown.selectByVisibleText("Two");

      WebElement selectedOption = dropdown.getFirstSelectedOption();
      String selectedText = selectedOption.getText();

      Assert.assertEquals(selectedText, "Two", "Dropdown selection failed!");

      System.out.println("✅ Test Passed: 'Two' is selected.");

      driver.quit();
  }
}
