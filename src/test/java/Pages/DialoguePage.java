package Pages;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialoguePage extends BaseFile {
    public DialoguePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.k-button.k-button-md.k-rounded-md.k-button-solid-base.k-button-solid")
    public WebElement openDialogueButton;

}
