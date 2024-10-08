package Pages;

import Base.BaseFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BoxesPage extends BaseFile {

    public BoxesPage() {
        PageFactory.initElements(driver, this);
    }
    public String boxesPageURL = "https://demos.telerik.com/kendo-angular-ui/demos/dropdowns/overview?theme=default-main";
    public String myFavoriteSport = "Tennis";
    public String autocompleteInput = "Tenn";
    public List<String> listOfIntendedDropdownOptions = new ArrayList<>(List.of("Baseball","Basketball","Cricket","Field Hockey","Football","Table Tennis","Tennis","Volleyball"));
    public List<String> listOfFavouriteSports = new ArrayList<>(List.of("Tennis","Football"));

    @FindBy(className = "k-input-inner")
    public List<WebElement> fields;

    @FindBy(xpath = "/html/body/app-root/my-app/div/div[1]/kendo-label/kendo-autocomplete/span")
    public WebElement autoCompletecloseButton;

    @FindBy(xpath = "/html/body/app-root/my-app/div/div[6]/kendo-label/kendo-multiselect/span")
    public WebElement multiSelectClearButton;

    @FindBy(css = ".k-input-md.k-rounded-md.k-input-solid.k-multiselect.k-input")
    public WebElement kendoMultiSelectInputField;

    @FindBy(xpath = "/html/body/app-root/my-app/div/div[6]/kendo-label/kendo-multiselect/div/kendo-taglist")
    public WebElement kendoMultiSelectTagsField;
    @FindBy(tagName = "li")
    public List<WebElement> listOfDropdownOptions;

    /* -------- Methods ------ */

    public WebElement findAutoCompleteField () {
        for (WebElement field : fields) {
            if (field.getAttribute("placeholder").equals("Your favorite sport")) {
                return field;
            }
        }
        return null;
    }
}
