package Tests;

import Base.BaseFile;
import Pages.BoxesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Task5Tests extends BaseFile {

    BoxesPage boxesPage;
    @BeforeClass
    public void setup() {
        boxesPage = new BoxesPage();
        driver.get(boxesPage.boxesPageURL);
    }


    @Test(priority = 20)
    public void verifyAllOptionButtons () {
        boxesPage.kendoMultiSelectInputField.click();
        List<String> listOfObservedDropdownOptions = makeStringListFromElementsAccessibleNames(boxesPage.listOfDropdownOptions);
        Assert.assertTrue(compareStringLists(boxesPage.listOfIntendedDropdownOptions,listOfObservedDropdownOptions));
        boxesPage.multiSelectClearButton.click();
        }




        @Test(priority = 30)
        public void chooseTennisAndFootballAsFavouriteSports() {
            boxesPage.kendoMultiSelectInputField.click();
            boxesPage.listOfDropdownOptions.get(6).click();
            waiter.until(ExpectedConditions.elementToBeClickable(boxesPage.kendoMultiSelectInputField));
            boxesPage.kendoMultiSelectInputField.click();
            waiter.until(ExpectedConditions.elementToBeClickable(boxesPage.listOfDropdownOptions.get(4)));
            boxesPage.listOfDropdownOptions.get(4).click();
        }

        @Test (priority = 40)
        public void verifyChosenFavouriteSports () {


            List<String> observedListOfTags = makeListOfTags(boxesPage.kendoMultiSelectTagsField);
            Assert.assertTrue(compareStringLists(observedListOfTags,boxesPage.listOfFavouriteSports));
        }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
