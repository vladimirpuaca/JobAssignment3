package Pages;

import Base.BaseFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoxesPage extends BaseFile {

    public BoxesPage() {
        PageFactory.initElements(driver, this);
    }
    public String myFavoriteSport = "Tennis";
    public String autocompleteInput = "Tenn";
    @FindBy(className = "k-input-inner")
    public List<WebElement> fields;

    //@FindBy(className = )

    /* -------- Methods ------ */

    public WebElement findAutoCompleteField () {
        WebElement targetField = null;
        for (WebElement field : fields) {
            if (field.getAttribute("placeholder").equals("Your favorite sport")) {
                targetField = field;
                return field;
            }
        }
        return targetField;
    }

}
