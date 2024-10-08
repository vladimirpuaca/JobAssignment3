package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseFile {
    public static WebDriver driver;
    public WebDriverWait waiter;
    public Actions actions;
    public ExcelReader excelReader;

    public JavascriptExecutor js;
@BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        excelReader = new ExcelReader("src/test/resources/Employees.xlsx");
        js = (JavascriptExecutor) driver;
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
    public void printTextOfElementsList(List<WebElement> listOfElements) {
        for (WebElement element:listOfElements) {
            System.out.print(element.getText());
            System.out.println();
        }
    }
    public void printTextofElementsList2(List<WebElement> listOfElements) {
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Element: "+ (i+1)+ " ");
            System.out.println("Accessible Name:" +listOfElements.get(i).getAccessibleName());
            System.out.println("Class Name:" + listOfElements.get(i).getClass());
            System.out.println("Tag Name:" + listOfElements.get(i).getTagName());
            System.out.println("Get Text:" + listOfElements.get(i).getText());
            System.out.println();
        }
    }

    public List<String> makeStringListFromElementsAccessibleNames(List<WebElement> listofElements) {
        List<String> newStringlist = new ArrayList<>();
        for (int i = 0; i < listofElements.size(); i++) {
            String returnedString = listofElements.get(i).getAccessibleName();

            String trimmedString =returnedString.substring(1);
            newStringlist.add(trimmedString);
        }
        return newStringlist;
    }
    public List<String> makeListOfTags(WebElement tagsField) {
        List<WebElement> listOfElements = tagsField.findElements(By.tagName("div"));
        List<String>listofSportsString = new ArrayList<>();
        for (WebElement element:listOfElements)
        {
            listofSportsString.add(element.getAccessibleName());
        }
        return listofSportsString;
    }
}