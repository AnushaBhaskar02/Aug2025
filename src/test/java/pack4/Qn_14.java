package pack4;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Qn_14 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String firstname, String lastname, String email, String phone, String password, String confpass) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Lab14_PO obj_14 = new Lab14_PO(driver);
	  obj_14.accountreg();
	  obj_14.registeruser(firstname, lastname, email, phone, password, confpass);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws IOException {
    String[][] data = new String[1][6];
    String projectpath_2 = System.getProperty("user.dir");
    File file_2 = new File(projectpath_2+"\\lab14_details.xlsx");
    FileInputStream fs_2 = new FileInputStream(file_2);
    XSSFWorkbook workbook_2 = new XSSFWorkbook(fs_2);
    XSSFSheet worksheet_2 = workbook_2.getSheetAt(0);
    int rowcount = worksheet_2.getPhysicalNumberOfRows();
//    int colcount = 6;
    System.out.println("Rows:"+ rowcount);
    
//    DataFormatter formatter = new DataFormatter();
    
    for(int i=0;i<rowcount;i++) {
    	data[i][0]=worksheet_2.getRow(i).getCell(0).getStringCellValue();
    	data[i][1]=worksheet_2.getRow(i).getCell(1).getStringCellValue();
    	data[i][2]=worksheet_2.getRow(i).getCell(2).getStringCellValue();
    	data[i][3]=worksheet_2.getRow(i).getCell(3).toString();
    	data[i][4]=worksheet_2.getRow(i).getCell(4).getStringCellValue();
    	data[i][5]=worksheet_2.getRow(i).getCell(5).getStringCellValue();
    	}
    return data;
  }
}