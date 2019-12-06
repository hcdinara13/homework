package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase01 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        driver.findElement(By.name("full_name")).sendKeys("Dinara");
        driver.findElement(By.name("email")).sendKeys("user@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        BrowserUtils.wait(1);

        String expectedHButton = "Home";
        String actualHButton = driver.findElement(By.className("//i [@class='icon-2x icon-signout']")).getText();
        if (expectedHButton.equals(actualHButton)) {
            System.out.println("Home button displayed");
        } else System.out.println("No button exists");

        driver.quit();

    }
}
