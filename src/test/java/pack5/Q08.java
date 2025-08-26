package pack5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q08 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://the-internet.herokuapp.com/windows");
      driver.manage().window().maximize();

      String parentWindow = driver.getWindowHandle();

      driver.findElement(By.linkText("Click Here")).click();

      Set<String> allWindows = driver.getWindowHandles();

      for (String window : allWindows) {
          if (!window.equals(parentWindow)) {
              driver.switchTo().window(window);
              System.out.println("Child Window Title: " + driver.getTitle());
              driver.close();
          }
      }

      driver.switchTo().window(parentWindow);
      System.out.println("Parent Window Title: " + driver.getTitle());
}
}
