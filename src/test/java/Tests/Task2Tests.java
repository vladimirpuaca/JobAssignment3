package Tests;

import Base.BaseFile;
import Pages.DialoguePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task2Tests extends BaseFile {

    public DialoguePage dialoguePage;

    @BeforeClass
    public void setupTask1() {
        dialoguePage = new DialoguePage();
        dialoguePage.goToDialoguePage();
        dialoguePage.openWindowBtn.click();
    }

    @Test(priority = 10)
    public void verifyModal() {
        Assert.assertTrue(elementIsPresent(dialoguePage.modal));
    }
    @Test(priority = 20)
    public void verifyModalButtons () {
        Assert.assertTrue(elementIsPresent(dialoguePage.modalMinimizeButton));
        Assert.assertEquals(dialoguePage.modalMinimizeButton.getAttribute("title"),dialoguePage.textOfModalMinimizeButton);

        Assert.assertTrue(elementIsPresent(dialoguePage.modalMaximizeButton));
        Assert.assertEquals(dialoguePage.modalMaximizeButton.getAttribute("title"),dialoguePage.textOfModalMaximizeButton);

        Assert.assertTrue(elementIsPresent(dialoguePage.modalCloseButton));
        Assert.assertEquals(dialoguePage.modalCloseButton.getAttribute("title"),dialoguePage.textOfModalCloseButton);

        Assert.assertTrue(elementIsPresent(dialoguePage.modalContent));
        Assert.assertEquals(dialoguePage.modalContent.getText(),dialoguePage.textOfModalContent);
    }
    @Test(priority = 30)
    public void verifyMaximizeButtonIsAbsentWhenWindowisMaximized() {
        dialoguePage.modalMaximizeButton.click();
        Assert.assertFalse(elementIsPresent(dialoguePage.modalMaximizeButton));
    }
    @Test(priority = 40)
    public void verifyClosedWindow() {
        dialoguePage.modalCloseButton.click();
        Assert.assertFalse(elementIsPresent(dialoguePage.modal));
        Assert.assertFalse(elementIsPresent(dialoguePage.modalCloseButton));
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
