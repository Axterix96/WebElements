package Tests;

import POM.PomManager;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.util.List;


import static io.qameta.allure.SeverityLevel.NORMAL;

public class TestCases extends BaseTest{

@Test(groups={"userStory1"},priority = 1)
public void testFindFruit()
{PomManager pomManager = new PomManager(threadDriver.get(),threadWait.get());
List<String> fruits = pomManager.homePageDemo.listFruits();
pomManager.homePageDemo.searchFruits(fruits);
}

@Test(groups={"userStory2"},priority = 2)
@Description("This test attempts to delete an order")
@Severity(NORMAL)
@Owner("Nicolas Sogbi")
@Issue("TCOR-1650")
@TmsLink("TMS-001")
public void testDeleteChefOrder()
{
    PomManager pomManager = new PomManager(threadDriver.get(), threadWait.get());
    pomManager.homePageDemo.goToDinner();
    pomManager.homePageDinner.clickOkCookie();
    List<String> chefsList = pomManager.homePageDinner.listChefs();
    boolean ordersDeleted = pomManager.homePageDinner.deleteOrdersByChef(chefsList);
    Assert.assertTrue(ordersDeleted, "You didn't delete the Chef's order");
}

@Test(groups={"userStory3"},priority = 3)
    public void testDeletePancakes()
{PomManager pomManager = new PomManager(threadDriver.get(), threadWait.get());
    pomManager.homePageDemo.goToDinner();
    pomManager.homePageDinner.clickOkCookie();
    boolean pancakesDeleted = pomManager.homePageDinner.deletePancakes();
    Assert.assertTrue(pancakesDeleted,"You didn't delete the pancakes");
}

@Test(groups={"userStory4"}, priority = 4)
public void testMultiCheck()
{PomManager pomManager = new PomManager(threadDriver.get(), threadWait.get());
    pomManager.homePageDemo.goToDinner();
    pomManager.homePageDemo.clickOkCookie();
    pomManager.homePageDemo.searchFruitsMulticheck();

}
}
