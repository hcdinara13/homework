package Tests.HW03_SyncCheckBoxLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.SelectValueFromDropDown.selectValueFromDropDown;

public class CalendarEvents {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement loaderMask= null;

        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


    @Test(description = "Verify 'OPTIONS' button")
    public void test1() {
        String actualText = driver.findElement(By.xpath("//*[@class='btn btn-link dropdown-toggle']")).getText();
        String expectedText = "Options";
        Assert.assertEquals(actualText, expectedText, "Fail");
    }

    @Test(description = "Verify that page number is equals to '1'")
    public void test2() {
        String actualText = driver.findElement(By.xpath("//*[@class='pagination pagination-centered']/ul/li[2]/input")).getText();
        if (actualText.contains("1")) {
            System.out.println("TEST PASS");
        } else
            System.out.println("TEST FAIL");
    }

    @Test(description = "Verify that view page number is equals to '25'")
    public void test3() {
        String actualText = driver.findElement(By.xpath("//*[@class='btn dropdown-toggle ']")).getText();
        if (actualText.contains("25")) {
            System.out.println("TEST PASS");
        } else
            System.out.println("TEST FAIL");
    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {
        int actualRowSize = driver.findElements(By.xpath("//table//tbody//tr")).size();
        String act = ""+ actualRowSize;
        String expectedRowSize=driver.findElement(By.xpath("//label[@class='dib'][3]")).getText();
        Assert.assertTrue(expectedRowSize.contains(act));
        }

    @Test
    public void test5(){
        driver.findElement(By.xpath("//div[@class='btn-group dropdown']//button//input")).click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody//tr//td//input"));
        for(WebElement checkBox : checkBoxes) {
            Assert.assertTrue(checkBox.isSelected());
        }
    }

    @Test(dataProvider = "testData")
    public void test6(String xpath, String respond){
        WebElement testersMeeting = driver.findElement(By.xpath("//td[text()='Testers meeting December']"));
        wait.until(ExpectedConditions.visibilityOf(testersMeeting));
        wait.until(ExpectedConditions.elementToBeClickable(testersMeeting));
        testersMeeting.click();
        Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(),respond);
    }

    @DataProvider
    public static Object[][]testData(){
        return new Object[][]{{"//*[text()='Testers meeting December']", "Testers meeting December"},
                {"//*[@class='control-label html-property']/p", "This is a weekly testers meeting notice"},
                {"//*[text()='Dec 26, 2019, 10:56 AM']","Dec 26, 2019, 10:56 AM"},
                {"//*[text()='Dec 26, 2019, 11:56 AM']","Dec 26, 2019, 11:56 AM"},
                {"//div[text()='No']","No"},
                {"//div[@class='calendar-event-organizer']/a","Stephan Haley"},
                {"//span[@class='list-group-item-text']/a","Tom Smith"},
                {"//div[text()='Weekly every 1 week on Friday']","Weekly every 1 week on Friday"},
                {"//label[text()='Call via Hangout']/parent::div/div/div","No"}};
    }


        @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
