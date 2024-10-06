package Tests;

import Base.BaseFile;
import Pages.BoxesPage;
import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        driver.get("https://demos.telerik.com/kendo-angular-ui/demos/dropdowns/overview?theme=default-main");
    }

    @Test(priority = 10)
    public void verifyAutoCompleteInputFieldChosenResults() {

        autocompleteField = boxesPage.findAutoCompleteField();
        autocompleteField.sendKeys(boxesPage.autocompleteInput + Keys.ENTER);
        Assert.assertEquals(autocompleteField.getAttribute("value"), boxesPage.myFavoriteSport);
    }

    @Test(priority = 20)
    public void verifyChosenSportisRemoved() {
        WebElement closeButton = driver.findElement(By.xpath("/html/body/app-root/my-app/div/div[1]/kendo-label/kendo-autocomplete/span"));
        closeButton.click();
        Assert.assertTrue(autocompleteField.getAttribute("value").isEmpty());
    }
    @AfterClass
    public void teardown() throws InterruptedException {
        driver.quit();
    }
}
