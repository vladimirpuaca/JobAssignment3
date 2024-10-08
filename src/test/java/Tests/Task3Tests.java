package Tests;

import Base.BaseFile;
import Pages.TablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Task3Tests extends BaseFile {

    public TablePage tablePage;
    public List<String> listOfEmployeesExcel;
    public List<String> listOfEmployeesTable;

    @BeforeClass
    public void setup() {
        tablePage = new TablePage();
        driver.manage().window().maximize();
        tablePage.goToTablePage();
    }

    @Test(priority = 10)
    public void basicTest() {
        Assert.assertEquals(driver.getCurrentUrl(), tablePage.tablePageURL);
    }

    @Test(priority = 20)
    public void printingAmericanEmployees() {
        filteringEmployeesByCountry("US");
        tablePage.printEmployeeData();
    }

    @Test(priority = 30)
    public void exportingAmericanOnlineEmployees() {
        filteringforOnlineEmployees();
        tablePage.exportToExcelButton.click();
    }

    @Test(priority = 40)
    public void verifyingContentsOfExcelFile() {
        makeListOfEmployeesInExcel();
        makeListofEmployeesInTable();
        Assert.assertTrue(compareStringLists(listOfEmployeesExcel,listOfEmployeesTable));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void filteringEmployeesByCountry(String countryAbbreviation) {
        tablePage.columnMenuButton("Country").click();
        waiter.until(ExpectedConditions.elementToBeClickable(tablePage.countryFilterButton));
        tablePage.countryFilterButton.click();

        waiter.until(ExpectedConditions.elementToBeClickable(tablePage.filterInputField));
        tablePage.filterInputField.sendKeys(countryAbbreviation + Keys.ENTER);
    }

    public void filteringforOnlineEmployees() {
        tablePage.columnMenuButton("Status").click();
        waiter.until(ExpectedConditions.elementToBeClickable(tablePage.statusFilterButton));
        tablePage.statusFilterButton.click();
        tablePage.clickOnYesRadioButton();
        waiter.until(ExpectedConditions.elementToBeClickable(tablePage.confirmFilterButton));
        tablePage.confirmFilterButton.click();
    }

    public void makeListOfEmployeesInExcel() {
        listOfEmployeesExcel = new ArrayList<>();
        System.out.println("This is list of employees in Excel: ");
        for (int i = 0; i < excelReader.getLastRow("Sheet1") - 1; i++) {
            listOfEmployeesExcel.add(i, excelReader.getStringData("Sheet1", i + 2, 0));
            System.out.println((i + 1) + ". " + excelReader.getStringData("Sheet1", i + 2, 0));
        }
    }

    public void makeListofEmployeesInTable() {
        listOfEmployeesTable = new ArrayList<>();
        List<WebElement> tdElements = driver.findElements(By.xpath("//table/tbody/tr/td"));
        System.out.println("This is list of employees in the table:");
        int j=0;
        for (WebElement tdElement : tdElements) {
            if (tdElement.getAttribute("aria-colindex").equals("2")) {
                listOfEmployeesTable.add(tdElement.getText());
                j++;
                System.out.println(j + ". " + tdElement.getText());
            }
        }
    }
}