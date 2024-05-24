package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BaseDriver{
    public WebDriver driver ;

    public WebDriverWait wait;

    public  WebDriver initializeDriver(String browser) throws IOException {

        if (browser.equalsIgnoreCase("chrome")) {

           return driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("edge")) {

            return driver = new EdgeDriver();


        } else if (browser.equalsIgnoreCase("firefox")) {

           return driver = new FirefoxDriver();

        }

return driver;
    }

    public WebDriverWait getWait() {
        return wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}
