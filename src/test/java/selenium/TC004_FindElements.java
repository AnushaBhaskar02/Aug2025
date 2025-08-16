package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_FindElements {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total links in amazon.in :"+ allLinks.size());
		for(WebElement link : allLinks) {
			System.out.println("the link is :"+link.getAttribute("href"));
			System.out.println("The link is :"+link.getText());
		}
	}
}
