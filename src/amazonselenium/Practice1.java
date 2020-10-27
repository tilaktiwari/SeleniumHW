package amazonselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Practice1 {

    public static void main(String[] args) throws InterruptedException {
        String amazonUrl="https://www.amazon.com/";
        String ebayUrl="https://www.ebay.com/";

        String chromeDriverPath="lib/browserdriver/chromedriver.exe";
        String firefoxDriverPath="lib/browserdriver/geckodriver.exe";

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver=new ChromeDriver();
        driver.get(amazonUrl);
        String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle=driver.getTitle();
        //Validate title
        Assert.assertEquals(actualTitle,expectedTitle,"Test Fail:Title does not match");
        Thread.sleep(5000);

        driver.close();
    }
}


