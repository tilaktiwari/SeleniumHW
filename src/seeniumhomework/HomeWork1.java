package seeniumhomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork1 {
    WebDriver driver;
    String url = "https://www.uhc.com/";

    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = "lib/browserdriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDown() {
        driver.close();
    }

    @Test
    public void checkHomePageTitle() throws InterruptedException {
        driver.get(url);
        String expectedTitle = "TeamUnited Newsroom - UnitedHealth Group";
        String actualTitle = driver.getTitle();
        //Validate title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail:Title does not match");
        Thread.sleep(5000);

    }

    @Test
    public void checkHomePageTitleWithError() throws InterruptedException {
        driver.get(url);
        String expectedTitle = "TeamUnited Newsroom - UnitedHealth Group1";//intentionally putting 1 at the end to get fail result
        String actualTitle = driver.getTitle();
        //Validate title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail:Title does not match");
        Thread.sleep(5000);

    }

    @Test
    public void checkLinkUnited() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath(" /html/body/div[1]/div/div[1]/header/div/div[1]/div[1]/div/div[1]/ul/li[2]/a")).click();

        Thread.sleep(5000);
//        String expectedText = .getText("");
//      Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }

    @Test
    public void checkFindADoctorrButton() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[3]/div/div[2]/div[2]/a")).click();

        Thread.sleep(5000);


    }

    @Test
    public void checksearchEngine() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"search-desktop\"]")).sendKeys("Individuals and Families");

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#search-desktop")).click();
        Thread.sleep(5000);
        String expectedText = "1-20 of 2,013 results for Individuals and Families";
        String actualText = driver.findElement(By.cssSelector("#search-results-count__header > span")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test
    public void checksearchWithError() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"search-desktop\"]")).sendKeys("abc123");

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#search-desktop")).click();
        Thread.sleep(5000);
        String expectedText = "Your search term abc123 did not return any results";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search-results-count__header\"]")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test
    public void searchForDoctors() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"search-desktop\"]")).sendKeys("doctors near me");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#search-desktop")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "1-20 of 807 results for doctors near me";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search-results-count__header\"]/span")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test
    public void testForProviderLink() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[1]/div/div[1]/ul/li[2]/a")).click();
        Thread.sleep(5000);


    }
    @Test
    public void testForBrokerLink() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[1]/div/div[1]/ul/li[4]/a")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "Brokers: We're committed to helping you succeed";
        String actualText = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[1]/h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }
    @Test
    public void testForEmployersLink() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[1]/div/div[1]/ul/li[3]/a")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "Health insurance for employers";
        String actualText = driver.findElement(By.xpath("//*[@id=\"employer-geo\"]/div[1]/h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }

    @Test
    public void testForMedicare() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[1]/div/div[1]/ul/li[1]/a")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "Medicare insurance plans";
        String actualText = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[1]/h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }

    @Test
    public void loginWithValidCredential() throws InterruptedException {

        driver.get(url);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[3]/div/div[2]/div[3]/button/span")).click();

       // driver.findElement(By.xpath("//*[@id=\"671978824-list1603827262963\"]/li[1]/a")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"671978824-list1603827262963\"]/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"signInButton\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("#username")).sendKeys("TilakTiwari");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("##password")).click();
        driver.findElement(By.cssSelector("##password")).sendKeys("abc123");
        driver.findElement(By.cssSelector("##password")).click();
        Thread.sleep(3000);
        // Enter Password
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Test123456");
        // Click submit/signIn button
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        Thread.sleep(3000);
    }
    // i am sorry i stuck to try to figure out how to make it work
}
