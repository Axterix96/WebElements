package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

//debuguear siempre despues de un cambio
//buscar que mas hace la interfaz y como aplicarlo
// ejectuarlo en paralelo


public class HomePageDinner extends BasePage implements HomePageDinnerLocators{


    public HomePageDinner(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    protected static By getDinnersToDelete(String chef) {
        return By.xpath("//div[contains(text(),'" + chef + "')]/preceding-sibling::div[@class='fr']");
    }

    protected static By getOrdersName(String chef) {
        return By.xpath("//div[contains(text(),'" + chef + "')]//..//div[@class='fl'][1]");
    }

    public List<String> listChefs() {
        List<String> chefList = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOrders));
        List<WebElement> ordersElements = driver.findElements(listOrders);
        List<String> newChefList = new ArrayList<>();
        for (int i = 0; i < ordersElements.size(); i++) {
            if (ordersElements.get(i).getText().contains("-")) {
                chefList.add(ordersElements.get(i).getText());
            }

        }
        for (int i = 0; i < chefList.size(); i++) {
            chefList.get(i).replaceAll(" ", "");
            String[] parts = chefList.get(i).split("-");
            newChefList.add(parts[1]);
        }
        return newChefList;
    }


    public boolean deleteOrdersByChef(List<String> chefs) {

        for (int i = 0; i < chefs.size(); i++) {
            if (chefs.get(i) == null) {
                continue;
            } else {
                wait.until(ExpectedConditions.visibilityOfElementLocated(getOrdersName(chefs.get(i))));
                driver.findElement(getDinnersToDelete(chefs.get(i))).click();
                wait.until(ExpectedConditions.elementToBeClickable(okDeletePopUp));
                wait.until(ExpectedConditions.visibilityOfElementLocated(textEdit));
                driver.findElement(okDeletePopUp).click();
                System.out.println("Order deleted: " + driver.findElement(getOrdersName(chefs.get(i))).getText());
                return true;
            }

        }
        return false;
    }

    public  boolean elementExists(By locator) {
        boolean validation = driver.findElements(locator).isEmpty();
        return !validation;
    }

    public boolean deletePancakes() {
            List<WebElement> editElements = driver.findElements(editOptions);
            for (int i = 0; i < editElements.size(); i++) {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(editElements.get(i))));
                editElements.get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(inputPopUp));

                if (elementExists(spanPancakes)) {
                    wait.until(ExpectedConditions.elementToBeClickable(spanPancakes));
                    driver.findElement(spanPancakesRemove).click();
                    driver.findElement(btnOk).click();
                    System.out.println("Meal Pancakes has been deleted");
                    return true;
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(btnOk));
                    driver.findElement(btnOk).click();
                    System.out.println("Meal Pancakes is not found in this order");
                }
            }
            return true;
    }


}
