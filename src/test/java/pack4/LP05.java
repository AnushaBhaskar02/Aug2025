package pack4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LP05 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // Verify title
        String expectedTitle = "Your Store";
        if (!driver.getTitle().equals(expectedTitle)) {
            System.out.println("Title mismatch!");
        }

        // Click My Account → Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify heading
        WebElement heading = driver.findElement(By.tagName("h1"));
        if (!heading.getText().equals("Register Account")) {
            System.out.println("Heading mismatch!");
        }

        // Click Continue without filling → verify privacy warning
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        WebElement warning = driver.findElement(By.cssSelector(".alert-danger"));
        if (!warning.getText().contains("Privacy Policy")) {
            System.out.println("Privacy Policy warning not displayed!");
        }

        // Your Personal Details
        driver.findElement(By.id("input-firstname")).sendKeys("AnushaTestFirstNameThatIsMoreThan33Chars");
        driver.findElement(By.id("input-lastname")).sendKeys("BhaskarTestLastNameMoreThan33Chars");

        driver.findElement(By.id("input-email")).sendKeys("anusha" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

        // Your Address
        driver.findElement(By.id("input-address-1")).sendKeys("123 Test Street Bangalore");
        driver.findElement(By.id("input-city")).sendKeys("Bangalore");
        driver.findElement(By.id("input-postcode")).sendKeys("560001");

        Select country = new Select(driver.findElement(By.id("input-country")));
        country.selectByVisibleText("India");

        Thread.sleep(1000); // Wait for state dropdown to load
        Select state = new Select(driver.findElement(By.id("input-zone")));
        state.selectByIndex(1);

        // Password
        driver.findElement(By.id("input-password")).sendKeys("Test1234");
        driver.findElement(By.id("input-confirm")).sendKeys("Test1234");

        // Newsletter Yes
        driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();

        // Privacy Policy
        driver.findElement(By.name("agree")).click();

        // Continue
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        // Verify account creation
        WebElement successMsg = driver.findElement(By.tagName("h1"));
        if (successMsg.getText().equals("Your Account Has Been Created!")) {
            // Continue and check order history
            driver.findElement(By.linkText("Continue")).click();
            driver.findElement(By.linkText("View your order history")).click();
        } else {
            System.out.println("Account creation failed!");
        }

        driver.quit();
    }
}
