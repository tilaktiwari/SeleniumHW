import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Demo {

    public static void main(String[] args) {
        String chromeDriverPath="lib/browserdriver/chromedriver.exe";
        String firefoxDriverPath="lib/browserdriver/geckodriver.exe";

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);// need to set driver property than get
        System.setProperty("webdriver.gecko.driver",firefoxDriverPath);//setting driver property for firefox
        WebDriver driver=new ChromeDriver();//for chrome driver
        WebDriver driver1=new FirefoxDriver();//for firefoxDriver
        driver.get("https://www.amazon.com/");
        driver.close();//closing driver/to see in slowly don't close it both
        driver1.get("https://www.ebay.com/");
        driver1.close();//closing driver1
    }
}

