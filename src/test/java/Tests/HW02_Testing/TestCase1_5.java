package Tests.HW02_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase1_5 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test (description="Verify that date if birth is not valid")
    public void test1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//*[@id='registrationForm']/div[8]/div/small[2]")).getText();
        String expectedResult = "The date of birth is not valid";
        Assert.assertEquals(actualResult, expectedResult, "NO ERROR MESSAGE");
         }

    @Test(description="Verify that following options for programming languages are displayed: c++, Java, JavaScript")
    public void test2(){
        String actualC = driver.findElement(By.xpath("//*[@id='registrationForm']/div[11]/div/div[1]/label")).getText();
        String expectedC = "C++";
        Assert.assertEquals(actualC, expectedC, "Element was not found");

        String actualJava = driver.findElement(By.xpath("//*[@id='registrationForm']/div[11]/div/div[2]/label")).getText();
        String expectedJava = "Java";
        Assert.assertEquals(actualJava, expectedJava, "Element was not found");

        String actualJavaS = driver.findElement(By.xpath("//*[@id='registrationForm']/div[11]/div/div[3]/label")).getText();
        String expectedJavaS = "JavaScript";
        Assert.assertEquals(actualJava, expectedJava, "Element was not found");

    }

    @Test(description="Verify that invalid input to first name box gives error message")
    public void test3(){
        driver.findElement(By.name("firstname")).sendKeys("z");
        BrowserUtils.wait(1);
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div/small[2]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage, "Message is not displayed");
    }

    @Test(description="Verify that invalid input to last name box gives error message")
    public void test4(){
        driver.findElement(By.name("lastname")).sendKeys("z");
        BrowserUtils.wait(1);
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//*[@id='registrationForm']/div[2]/div/small[2]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage, "Message is not displayed");
    }
    @Test(description = "Verify that success message is displayed")
    public void testCase5() {

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Snow");
        driver.findElement(By.name("username")).sendKeys("JohnSnow");
        driver.findElement(By.name("email")).sendKeys("JohnSnow@email.com");
        driver.findElement(By.name("password")).sendKeys("howderhowder");
        driver.findElement(By.name("phone")).sendKeys("462-856-8798");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("06/20/1983");
        Select department = new Select(driver.findElement(By.cssSelector("[name='department']")));
        department.selectByVisibleText("MPDC");
        Select jobTitle = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        driver.findElement(By.id("wooden_spoon")).click();
       // String expectedMessage = "You've successfully completed registration!";

        BrowserUtils.wait(1);
        String actualMessage=driver.findElement(By.xpath("//*[@id='content']/div/div/p")).getText();
        BrowserUtils.wait(1);
        Assert.assertEquals(actualMessage,"You've successfully completed registration!");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
