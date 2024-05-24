package Tests;


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
    protected  ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    protected  ThreadLocal<WebDriverWait> threadWait = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void Setup(String browser) throws IOException {
        threadDriver.set(initializeDriver(browser));
        threadWait.set(getWait());
        threadDriver.get().manage().window().maximize();
        threadDriver.get().get("https://demowf.aspnetawesome.com/");


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
       threadDriver.get().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadDriver.remove();
    }


}
