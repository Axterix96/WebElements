package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface HomePageDemoLocators{


    By autocompleteInput = By.id("ContentPlaceHolder1_Meal");

    By dropdownMenuFirstChoice = By.xpath("//div[@id='ContentPlaceHolder1_Meal-dropmenu']//li[1]");

    By dropdownListFruits = By.xpath("//div[@id='ContentPlaceHolder1_AllMeals-dropmenu']//li//div");

    By btnDropDown = By.id("ContentPlaceHolder1_AllMeals-awed");

    By selectedMulticheckValues = By.xpath("//li[@class='o-itm o-v selected o-ditm']");

    By multicheckBtn = By.id("ContentPlaceHolder1_AllMealsMultichk-awed");

    public void clickLocator(By locator);

    public void waitElementToBeClickable(By locator);

    public List<WebElement> listElements(By locator);

}
