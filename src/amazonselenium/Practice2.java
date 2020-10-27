package amazonselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice2 {

    WebDriver driver ;
    String amazonUrl = "https://www.amazon.com/";
//    String ebayUrl = "https://www.ebay.com/";
    @BeforeMethod
    public void setUp() {


        String chromeDriverPath="lib/browserdriver/chromedriver.exe";
//        String firefoxDriverPath = "lib/browserdriver/geckodriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver=new ChromeDriver();
    }
    @AfterMethod
    public void tearDown() {
//        driver.close();
        driver.quit();

    }
    @Test
    public void checkHomePageTitle() throws InterruptedException {
        driver.get(amazonUrl);
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        //Validate title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail:Title does not match");
        Thread.sleep(5000);

    }

}







