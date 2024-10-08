package Pages;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialoguePage extends BaseFile {
    public DialoguePage() {
        PageFactory.initElements(driver, this);
    }
    public String urlDialoguePage = "https://demos.telerik.com/kendo-angular-ui/demos/dialogs/preview?theme=default-main";
    public String titleTextDialoguePage = "Please confirm";
    public String textOfDBquestion = "Are you sure you want to continue?";
    public String textOfModalMinimizeButton = "Minimize";
    public String textOfModalMaximizeButton = "Maximize";

    public String textOfModalCloseButton = "Close";
    public String textOfModalContent = "Additional info";
    public String yesBtnBGcolor = "rgba(255, 99, 88, 1)";
    @FindBy(css = "button.k-button.k-button-md.k-rounded-md.k-button-solid-base.k-button-solid")
    public WebElement openDialogueButton;
    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-dialog/div[2]")
    public WebElement dialogueBox;

    @FindBy(css = ".k-window-title.k-dialog-title")
    public WebElement dialogueBoxTittle;

    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-dialog/div[2]/kendo-dialog-titlebar/div/button")
    public WebElement dialogueBoxCloseButton;

    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-dialog/div[2]/div/p")
    public WebElement dialogueBoxQuestion;

    @FindBy(css = ".k-button-solid-base")
    public WebElement dialogueBoxNoButton;

    @FindBy(css = "button.k-button:nth-child(2)")
    public WebElement dialogueBoxYesButton;

    @FindBy(css = "body > app-root > my-app > my-dialogs > div > button:nth-child(2)")
    public WebElement openWindowBtn;

    @FindBy(className = "k-window")
    public WebElement modal;
    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-window/kendo-window-titlebar/div/button[1]")
    public WebElement modalMinimizeButton;
    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-window/kendo-window-titlebar/div/button[2]")
    public WebElement modalMaximizeButton;
    @FindBy(xpath = "/html/body/app-root/my-app/my-dialogs/div/kendo-window/kendo-window-titlebar/div/button[4]")
    public WebElement modalCloseButton;
    @FindBy(className = "k-window-content")
    public WebElement modalContent;


    /*---------Methods-------*/
    public void goToDialoguePage() {
        driver.get(urlDialoguePage);
    }

}
