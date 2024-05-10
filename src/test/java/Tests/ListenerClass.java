package Tests;

import POM.BasePage;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseTest implements ITestListener {
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
