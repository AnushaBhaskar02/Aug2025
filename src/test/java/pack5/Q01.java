package pack5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q01 {
	
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void openGoogle() {
	        driver.get("https://www.google.com");
	        System.out.println("title: " + driver.getTitle());
	    }
	}
