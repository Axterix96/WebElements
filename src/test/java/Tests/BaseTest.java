package Tests;

import POM.BasePage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest extends BaseDriver {
    public BaseTest(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void Setup(String browser) throws IOException {
        initializeDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://demowf.aspnetawesome.com/");
        BasePage basePage = new BasePage(driver,wait);

    }

    public void captureScreenshot(String methodName)
    {
        try
        {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(file,new File("./screenshots/"+methodName+".png"));
        }catch (Exception e)
        {
            e.getMessage();

        }
    }
    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshotPNG(String methodName) throws IOException {
        return Files.readAllBytes(Paths.get("./screenshots/"+methodName+".png"));
    }


    @AfterMethod(alwaysRun = true)
    public void cleanup()
    {
        driver.quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
    }


}
