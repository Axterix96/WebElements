package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomManager extends BasePage{

    public HomePageDemo homePageDemo = new HomePageDemo(driver,wait);

public HomePageDinner homePageDinner = new HomePageDinner(driver,wait);

    public PomManager(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
