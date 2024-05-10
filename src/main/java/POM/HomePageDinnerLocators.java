package POM;

import org.openqa.selenium.By;

public interface HomePageDinnerLocators {

    By popUp = By.xpath("//label[contains(text(),'Name')]");

    By listOrders = By.xpath("//div[@class='fl']");

    By okDeletePopUp = By.xpath("//div[@id='deletedinnersGrid']//..//button[contains(text(),'Ok')]");

    By editOptions = By.xpath("//button[contains(text(),'Edit')]");

    By okBtnCookie = By.id("btnCookie");

    By spanPancakes = By.xpath("//span[contains(text(),'pancakes')]");

    By spanPancakesRemove = By.xpath("//span[contains(text(),'pancakes')]/following-sibling::span");

    By btnOk = By.xpath("//button[contains(text(),'Ok')]");

    By textEdit = By.xpath("//b");

}
