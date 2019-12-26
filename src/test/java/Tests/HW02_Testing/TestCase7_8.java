package Tests.HW02_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCase7_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Test
            public void test7(){
        driver.findElement(By.linkText("File Upload")).click();

        driver.findElement(By.id("file_upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/jemsh/Desktop/file1.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualSubject=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        String expectedSubject="File Uploaded!";
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Test
    public void test8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="You selected: United States of America";
        Assert.assertEquals(actualResult, expectedResult, "FAIL");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

