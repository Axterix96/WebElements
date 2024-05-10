package Tests;

import POM.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseTest implements ITestListener {
    public ListenerClass(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed");
        try
        {
            captureScreenshot(result.getName());
            attachScreenshotPNG(result.getName());

        }catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       System.out.println(result+": Passed");
    }
}
