package homepage;
/*
 create class "TopMenuTest"
1.1 create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
select the Menu and click on it and verify the page navigation.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    // Browser set up
    @Before
    // browser setup
   public void browserSetUP(){
        openBrowser(baseUrl);
   }
   @Test
       public void verifyPageNavigation() {
        selectMenu("Computers");
        String actualTitle = driver.findElement(By.xpath("//h1")).getText();
        String expectedTitle = "Computers";
        Assert.assertEquals("",actualTitle,expectedTitle);




      }
   @After
    public void tearDown(){
        closeBrowser();
   }
}
