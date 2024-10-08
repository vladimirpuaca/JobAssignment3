package Tests;

import Base.BaseFile;
import Pages.BoxesPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task4Tests extends BaseFile {
    BoxesPage boxesPage;

    WebElement autocompleteField;

    @BeforeClass
    public void setup() {
        boxesPage = new BoxesPage();
        driver.get(boxesPage.boxesPageURL);
    }

    @Test(priority = 10)
    public void verifyAutoCompleteInputFieldChosenResults() {

        autocompleteField = boxesPage.findAutoCompleteField();
        autocompleteField.sendKeys(boxesPage.autocompleteInput + Keys.ENTER);
        Assert.assertEquals(autocompleteField.getAttribute("value"), boxesPage.myFavoriteSport);

    }

    @Test(priority = 20)
    public void verifyChosenSportIsRemoved() {

       boxesPage.autoCompletecloseButton.click();
       Assert.assertTrue(autocompleteField.getAttribute("value").isEmpty());
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
