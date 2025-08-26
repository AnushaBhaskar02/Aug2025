package pack4;
  
  import org.testng.annotations.Test;
   
  import com.opencsv.CSVReader;

  import com.opencsv.exceptions.CsvException;
   
  import io.github.bonigarcia.wdm.WebDriverManager;
   
  import org.testng.annotations.BeforeMethod;

  import org.testng.annotations.AfterMethod;

  import org.testng.annotations.DataProvider;

  import org.testng.annotations.BeforeClass;
   
  import java.io.FileReader;

  import java.io.IOException;

  import java.util.List;
   
  import org.apache.poi.xssf.usermodel.XSSFWorkbook;

  import org.openqa.selenium.By;

  import org.openqa.selenium.WebDriver;

  import org.openqa.selenium.chrome.ChromeDriver;

  import org.openqa.selenium.support.PageFactory;

  import org.testng.annotations.AfterClass;

  import org.testng.annotations.BeforeTest;

  import org.testng.annotations.AfterTest;

  import org.testng.annotations.BeforeSuite;

  import org.testng.annotations.AfterSuite;
   
  public class Lab015_CSV {

  	WebDriver driver;

  	 String projectpath=System.getProperty("user.dir");

    @Test(dataProvider = "dp")

    public void f(String username, String password) throws InterruptedException {

  	  	String title=driver.getTitle();

  		System.out.println("The Title is:"+title);

  		Thread.sleep(3000);

  		login_pagefactory obj=PageFactory.initElements(driver, login_pagefactory.class);

  		obj.enterusername(username);

  		obj.enterpassword(password);

  		obj.clickonlogin();
  	  }

    @BeforeMethod

    public void beforeMethod() {

  	  System.out.println("Before method");

  	  WebDriverManager.chromedriver().setup();

  		driver=new ChromeDriver();

  		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterMethod

    public void afterMethod() {

  	  System.out.println("After method");

  	  driver.quit();

    }
   
   
    @DataProvider

    public Object[][] dp() throws IOException, CsvException {

  	  String[][] data1=new String[3][2];

  	  String csvFile = projectpath+"\\Lab15_data.csv";  // Path to your CSV file

        CSVReader csvReader = new CSVReader(new FileReader(csvFile));

        List<String[]> data = csvReader.readAll(); // Read all rows
   
        // Iterate over CSV data (skipping header)

        for (int i = 0; i < data.size(); i++) {  // Start from 1 to skip header

            data1[i][0] = data.get(i)[0];  // Get username from the CSV

            data1[i][1] = data.get(i)[1];  // Get password from the CSV
   
        }

  	  return data1;

      }
    @BeforeClass
    public void beforeClass() {
  System.out.println("Before class");
    }
   
    @AfterClass
    public void afterClass() {
  System.out.println("After Class");
    }
   
    @BeforeTest
    public void beforeTest() {
  System.out.println("Before Test");
    }
   
    @AfterTest
    public void afterTest() {
  System.out.println("After Test");
    }
   
    @BeforeSuite
    public void beforeSuite() {
  System.out.println("Before Suite");
    }
   
    @AfterSuite
    public void afterSuite() {
  System.out.println("After Suite");
    }
   
  }