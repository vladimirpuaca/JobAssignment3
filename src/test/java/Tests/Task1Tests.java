package Tests;

import Base.BaseFile;
import Pages.DialoguePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task1Tests extends BaseFile {

    public DialoguePage dialoguePage;

    @BeforeClass
    public void setupTask1() {
        dialoguePage=new DialoguePage();
        dialoguePage.goToDialoguePage();
        dialoguePage.openDialogueButton.click();
    }

    @Test (priority = 10)
    public void basicDialogueBoxTest() {
        Assert.assertEquals(driver.getCurrentUrl(),dialoguePage.urlDialoguePage);
        Assert.assertTrue(elementIsPresent((dialoguePage.dialogueBox)));
    }
    @Test (priority = 20)
    public void verifyDialogueTitle() {
        waiter.until(ExpectedConditions.visibilityOf(dialoguePage.dialogueBoxTittle));
        Assert.assertTrue(dialoguePage.dialogueBoxTittle.isDisplayed());
        Assert.assertEquals(dialoguePage.dialogueBoxTittle.getText(),dialoguePage.titleTextDialoguePage);
    }
    @Test
    public void verifyCloseButton() {
        Assert.assertTrue(dialoguePage.dialogueBoxCloseButton.isDisplayed());
        Assert.assertEquals(dialoguePage.dialogueBoxCloseButton.getAttribute("title"), "Close");
    }
    @Test(priority = 40)
    public void verifyDialogueBoxQuestion() {
        Assert.assertTrue(dialoguePage.dialogueBoxQuestion.isDisplayed());
        Assert.assertEquals(dialoguePage.dialogueBoxQuestion.getText(),dialoguePage.textOfDBquestion);
    }
    @Test(priority = 50)
    public void verifyButtons() {
        Assert.assertTrue(dialoguePage.dialogueBoxNoButton.isDisplayed());
        Assert.assertEquals(dialoguePage.dialogueBoxNoButton.getText(),"No");
        Assert.assertEquals(dialoguePage.dialogueBoxYesButton.getText(),"Yes");
    }

    @Test (priority = 60)
    public void verifyYesBtnBGColor() {
        Assert.assertEquals(dialoguePage.dialogueBoxYesButton.getCssValue("background-color"),dialoguePage.yesBtnBGcolor);
    }
    @Test (priority =70)
    public void verifyFocusOnCloseBtn() throws InterruptedException {
        Assert.assertNotEquals(driver.switchTo().activeElement(), dialoguePage.dialogueBoxCloseButton);
        dialoguePage.dialogueBoxCloseButton.sendKeys("");
        Assert.assertEquals(driver.switchTo().activeElement(), dialoguePage.dialogueBoxCloseButton);
        dialoguePage.dialogueBoxCloseButton.sendKeys(Keys.ENTER);
    }
    @Test (priority=80)
    public void verifyDialogueBoxAbsent () {
        Assert.assertFalse(elementIsPresent(dialoguePage.dialogueBox));
        Assert.assertFalse(elementIsPresent(dialoguePage.dialogueBoxCloseButton));
    }


    @AfterClass
    public void testTearDown() throws InterruptedException {
        driver.quit();
    }
}
