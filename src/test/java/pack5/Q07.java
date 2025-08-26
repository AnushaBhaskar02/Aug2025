package pack5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q07 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://the-internet.herokuapp.com/tables");
      driver.manage().window().maximize();

      List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
      
      System.out.println("Names from first table:");
      for (WebElement name : names) {
          System.out.println(name.getText());
      }

      String email = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Jason']/following-sibling::td[1]")).getText();
      System.out.println("\nEmail ID of Jason: " +email);
  }
}
