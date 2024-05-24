package Tests;

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
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       System.out.println(result+": Passed");
        try
        {
            captureScreenshot(result.getName());
            attachScreenshotPNG(result.getName());

        }catch (Exception e)
        {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
