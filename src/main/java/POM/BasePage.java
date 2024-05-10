package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage implements HomePageDinnerLocators {


    public  WebDriver driver;
    public  WebDriverWait wait;

    public BasePage(WebDriver driver,WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
    }
    public void clickOkCookie()
    {
        wait.until(ExpectedConditions.elementToBeClickable(okBtnCookie));
        driver.findElement(okBtnCookie).click();
    }
}
