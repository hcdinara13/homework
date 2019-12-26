package Tests.HW02_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase6 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.id("email")).getText();;

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("ElieSaab");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedText="Thank you for signing up. Click the button below to return to the home page.";
        String actualText=driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(expectedText,actualText,"Something wrong");
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(2);

        String actualEmail=driver.findElement(By.xpath("//tr[@data-href='2'][1]//td[1]")).getText();
        String expectedEmail="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expectedEmail,actualEmail,"FAIL");


        driver.findElement(By.xpath("//tr[@data-href='2'][1]//td[1]")).click();
        String actualEmail2=driver.findElement(By.id("odesilatel")).getText();
        String expectedEmail2="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expectedEmail2,actualEmail2,"FAIL");

        String actualEmail3=driver.findElement(By.id("predmet")).getText();
        String expectedEmail3="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(expectedEmail3,actualEmail3,"Fail");
        driver.close();
    }
}
