package amazonselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice3FromClass {
    WebDriver driver=null;
    String amazonUrl = "https://www.amazon.com/";

    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = "lib/browserdriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();//for making full screen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//telling to wait indirectly wait 20 second
        // because some tme internet slow
    }


    @Test(enabled = false)
    public void checkHomePageTitle() throws InterruptedException {
        driver.get(amazonUrl);
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        // Validate Title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail: Title does not match");
        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void searchBox1() throws InterruptedException {
        // Open Browser and Navigate to Amazon Url
        driver.get(amazonUrl);
        // Enter "Hand Sanitizer" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys");
        // for wait only
        Thread.sleep(3000);
        // Click on search Button
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "\"toys\"";
        String actualText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test(enabled = false)
    public void searchBox2() throws InterruptedException {
        // Open Browser and Navigate to Amazon Url
        driver.get(amazonUrl);
        // Enter "Hand Sanitizer" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Hand Sanitizer");
        // for wait only
        Thread.sleep(3000);
        // Click on search Button
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "\"Hand Sanitizer\"";
        String actualText = driver.findElement(By.cssSelector("#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col-26-of-32.sg-col-18-of-24.sg-col.sg-col-22-of-28.s-breadcrumb.sg-col-10-of-16.sg-col-30-of-36.sg-col-6-of-12 > div > div > span.a-color-state.a-text-bold")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }

    @Test(enabled = false)
    public void searchBox3() throws InterruptedException {
        // Open Browser and Navigate to Amazon Url
        driver.get(amazonUrl);
        // Enter "Hand Sanitizer" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("rolex");
        // for wait only
        Thread.sleep(3000);
        // Click on search Button
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "\"rolex\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test
    public void searchBox4() throws InterruptedException {
        // Open Browser and Navigate to Amazon Url
        driver.get(amazonUrl);
        // Enter "Hand Sanitizer" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12 pro max");
        // for wait only
        Thread.sleep(3000);
        // Click on search Button
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(5000);
        // Validate
        String expectedText = "\"iphone 12 pro max\"";
        String actualText = driver.findElement(By.xpath("//span[text()='\"iphone 12 pro max\"']")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    @Test
    public void loginWithValidCredential() throws InterruptedException {
        // Open Browser and Navigate to Amazon Url
        driver.get(amazonUrl);
        // click on hello sign in
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
        // Enter Email Address/ Phone Number
        driver.findElement(By.id("ap_email")).sendKeys("mh.shahib@gmail.com");
        // Click on Continue Button
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Test123456");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        Thread.sleep(3000);
    }


    @AfterMethod
    public void tearDown() {
        //driver.close();
        driver.quit();
    }


}


