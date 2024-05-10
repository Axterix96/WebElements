package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class HomePageDemo extends BasePage implements HomePageDemoLocators {

    public HomePageDemo(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickLocator(By locator)
{
    driver.findElement(locator).click();
}


public void waitElementToBeClickable(By locator)
{
    wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public List<WebElement>listElements(By locator)
{
    List<WebElement> list = driver.findElements(locator);

    return list;
}

    public List<String> listFruits()
{
    clickLocator(btnDropDown);
    List<WebElement> fruits = listElements(dropdownListFruits);
    List<String> fruitsString = new ArrayList<>();

    for(int i = 0; i < fruits.size();i++)
    {
       fruitsString.add(fruits.get(i).getText());
    }


    return fruitsString;

}

public void searchFruits(List<String> fruits)
{
    for(int i = 0; i < fruits.size();i++) {
        driver.findElement(autocompleteInput).sendKeys(fruits.get(i));
       waitElementToBeClickable(dropdownMenuFirstChoice);
        clickLocator(dropdownMenuFirstChoice);
        driver.findElement(autocompleteInput).clear();
    }
}

    public void goToDinner()
    {
        driver.navigate().to("https://prodinner.aspnetawesome.com/");

    }
    public void searchFruitsMulticheck()
    {
        clickLocator(multicheckBtn);
        List<WebElement> fruitsSelected = listElements(selectedMulticheckValues);
        for(int i = 0; i<fruitsSelected.size();i++)
        {
            System.out.println(fruitsSelected.get(i).getText());
        }

    }

}
