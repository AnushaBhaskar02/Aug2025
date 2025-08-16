package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String title = driver.getTitle();
        System.out.println("The title is : " + title);

        // Wait until username field is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        username.sendKeys("Admin");

        // Wait until password field is visible
        WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("password"))
        );
        password.sendKeys("admin123");
    }
}
