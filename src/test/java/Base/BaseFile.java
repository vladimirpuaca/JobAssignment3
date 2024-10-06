package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseFile {
    public static WebDriver driver;
    public WebDriverWait waiter;
    public Actions actions;
    public ExcelReader excelReader;

    public JavascriptExecutor js;
@BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        excelReader = new ExcelReader("src/test/resources/Employees.xlsx");
        js = (JavascriptExecutor) driver;
    }

    public void putFocusOnElement(WebElement element) {
        new Actions(driver).moveToElement(element).click().perform();
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return nonexistingElement;
    }
    public boolean compareStringLists(List<String> list1, List<String> list2) {
        if (list1.size()!=list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}