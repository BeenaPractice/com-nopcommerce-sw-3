package browserfactory;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        // Launch the Chrome Browser
        driver = new ChromeDriver();
        // open the URL into Browser
        driver.get(baseUrl);
        // maximise Browser
        driver.manage().window().maximize();
        // we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void closeBrowser(){
     //   driver.quit();
    }
}
