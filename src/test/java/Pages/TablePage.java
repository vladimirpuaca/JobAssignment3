package Pages;

import Base.BaseFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TablePage extends BaseFile {
    public String tablePageURL = "https://demos.telerik.com/kendo-angular-ui/demos/grid/filter-all-columns?theme=default-main";
    public TablePage() {
        PageFactory.initElements(driver, this);
    }
    public WebElement countrySearchButton = columnMenuButton("Country");
    public WebElement statusSearchButton = columnMenuButton("Status");


    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/div/kendo-grid-columnmenu-container/kendo-grid-columnmenu-container/kendo-grid-columnmenu-filter")
    public WebElement countryFilterButton;

    @FindBy( xpath = "/html/body/app-root/kendo-popup/div/div/kendo-grid-columnmenu-container/kendo-grid-columnmenu-container/kendo-grid-columnmenu-filter/kendo-grid-columnmenu-item/div/div[2]/kendo-grid-filter-menu-container/form/div/kendo-grid-string-filter-menu/kendo-grid-string-filter-menu-input[1]/kendo-grid-filter-menu-input-wrapper/input")
    public WebElement filterInputField;

    //@FindBy(css = "kendo-grid-columnmenu-item.ng-tns-c2035614799-16.ng-star-inserted")
    //@FindBy(css = "span.k-expander-indicator.ng-tns-c2035614799-16 ng-star-inserted")
    //@FindBy(xpath = "/html/body/app-root/kendo-popup/div/div/kendo-grid-columnmenu-container/kendo-grid-columnmenu-container/kendo-grid-columnmenu-filter/kendo-grid-columnmenu-item/div/div[1]")
    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/div/kendo-grid-columnmenu-container/kendo-grid-columnmenu-container/kendo-grid-columnmenu-filter/kendo-grid-columnmenu-item/div")
    public WebElement statusFilterButton;

    //@FindBy(id = "4182c554-2c0f-4ccd-a88f-7be895506a32_true")
    //@FindBy(xpath = "//*[@id=\"4182c554-2c0f-4ccd-a88f-7be895506a32_true\"]")

    @FindBy(css = ".k-radio-label")
    public List<WebElement> radioButtons;

    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/div/kendo-grid-columnmenu-container/kendo-grid-columnmenu-container/kendo-grid-columnmenu-filter/kendo-grid-columnmenu-item/div/div[2]/kendo-grid-filter-menu-container/form/div/div/button[1]")
    public WebElement confirmFilterButton;

    @FindBy(css = "button.k-button:nth-child(3)")
    public WebElement exportToExcelButton;


    /* ---------- Methods --------*/
    public void goToTablePage() {
        driver.get(tablePageURL);
    }


    public WebElement columnMenuButton(String nameOfColumnButton) {
        List<WebElement> listOfButtons = driver.findElements(By.cssSelector("a.k-grid-header-menu.k-grid-column-menu"));
        for (WebElement listOfButton : listOfButtons) {
            if (listOfButton.getAttribute("title").equals(nameOfColumnButton + " Column Menu")) {
                return listOfButton;
            }
        }
        return null;
    }
    public void clickOnYesRadioButton() {
        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).click();
            break;
        }

    }

    public void printEmployeeData() {
        List<WebElement> tdElements = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement tdElement : tdElements) {
            if (tdElement.getAttribute("aria-colindex").equals("2")) {
                String employeeName = tdElement.getText();
                System.out.println("Name: " + employeeName);
            }
            if (tdElement.getAttribute("aria-colindex").equals("3")) {
                String jobTitle = tdElement.getText();
                System.out.println("Job Tittle: " + jobTitle);
            }
            if (tdElement.getAttribute("aria-colindex").equals("9")) {
                String employeePhone = tdElement.getText();
                System.out.println("Phone number: " + employeePhone);
            }
            if (tdElement.getAttribute("aria-colindex").equals("10")) {
                String employeeAddress = tdElement.getText();
                System.out.println("Address: " + employeeAddress);
                System.out.println();
            }
        }
    }
}
