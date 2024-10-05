package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseFile {
    public static WebDriver driver;
    public WebDriverWait waiter;
@BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-angular-ui/demos/dialogs/preview?theme=default-main");

        Thread.sleep(5000);
        driver.quit();
    }
}