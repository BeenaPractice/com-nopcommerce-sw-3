package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    // Browser set up
    @Before
    // browser setup
    public void browserSetUP(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        //1.3 Verify the text “Cell phones”

        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        WebElement cellphones  = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellphones).click().build().perform();
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']")).getText();
        String expectedText = "Cell phones";
        Assert.assertEquals("",actualText,expectedText);

    }

//     2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        //2.3 Verify the text “Cell phones”
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        WebElement cellphones  = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellphones).click().build().perform();
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']")).getText();
        String expectedText = "Cell phones";
        Assert.assertEquals("",actualText,expectedText);

       // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@title='List']"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        mouseHover(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        

        //2.6 Verify the text “Nokia Lumia 1020”
        String actualText1 = driver.findElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")).getText();
        String expectedText1 = "Nokia Lumia 1020";
        Assert.assertEquals("",actualText1,expectedText1);

       // 2.7 Verify the price “$349.00”
        String actualText2 = driver.findElement(By.xpath("//span[@id='price-value-20']")).getText();
        String expectedText2 = "$349.00";
        Assert.assertEquals("",actualText2,expectedText2);

        //2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

       //2.10 Verify the Message "The product has been added to your shopping cart on Top green Bar
        String actualText3 = driver.findElement(By.xpath("//p[@class='content']")).getText();
        String expectedText3 = "The product has been added to your shopping cart";
        Assert.assertEquals("",actualText3,expectedText3);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart  = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

//        2.12 Verify the message "Shopping cart"
          String actualText4 = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
          String expectedText4 = "Shopping cart";
          Assert.assertEquals("",actualText4,expectedText4);

//        2.13 Verify the quantity is 2
          String actualQty = driver.findElement(By.xpath("//input[@id='itemquantity11220']")).getText();
          String expectedQty = "2";
          Assert.assertEquals("",actualQty,expectedQty);

//        2.14 Verify the Total $698.00
          String actualTotal = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")).getText();
          String expectedTotal = "$698.00";
          Assert.assertEquals("",actualTotal,expectedTotal);

//        2.15 click on checkbox “I agree with the terms of service”
          clickOnElement(By.xpath("//input[@id='termsofservice']"));

//        2.16 Click on “CHECKOUT”
          clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.17 Verify the Text “Welcome, Please Sign In!”
          String actualText5 = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
          String expectedText5 = "Welcome, Please Sign In!";
          Assert.assertEquals("",actualText5,expectedText5);

//        2.18 Click on “REGISTER” tab
          clickOnElement(By.xpath("//a[@class='ico-register']"));
//        2.19 Verify the text “Register”
          String actualText6 = driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
          String expectedText6 = "Register";
          Assert.assertEquals("",actualText6,expectedText6);

//        2.20 Fill the mandatory fields
          sendTextToElement(By.xpath("//input[@id='FirstName']"),"Prime");
          sendTextToElement(By.xpath("//input[@id='LastName']"),"Testing");
          sendTextToElement(By.xpath("//input[@id='Email']"),"prime123@gmail.com");
          sendTextToElement(By.xpath("//input[@id='Password']"),"pr123");
          sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"pr123");

//        2.21 Click on “REGISTER” Button
          clickOnElement(By.xpath("//button[@id='register-button']"));
//        2.22 Verify the message “Your registration completed”
          String actualText7 = driver.findElement(By.xpath("//div[@class='result']")).getText();
          String expectedText7 = "Your registration completed";
//        2.23 Click on “CONTINUE” tab
          clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

//        2.24 Verify the text “Shopping cart”
          String actualText8 = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
          String expectedText8 = "Shopping cart";
          Assert.assertEquals("",actualText8,expectedText8);

//        2.25 click on checkbox “I agree with the terms of service”


//        2.26 Click on “CHECKOUT”

//        2.27 Fill the Mandatory fields
//        2.28 Click on “CONTINUE”
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
//        2.30 Click on “CONTINUE”
//        2.31 Select Radio Button “Credit Card”
//        2.32 Select “Visa” From Select credit card dropdown
//        2.33 Fill all the details
//        2.34 Click on “CONTINUE”
//        2.35 Verify “Payment Method” is “Credit Card”
//        2.36 Verify “Shipping Method” is “2nd Day Air”
//        2.37 Verify Total is “$698.00”
//        2.38 Click on “CONFIRM”
//        2.39 Verify the Text “Thank You”
//        2.40 Verify the message “Your order has been successfully processed!”
//        2.41 Click on “CONTINUE”
//        2.42 Verify the text “Welcome to our store”
//        2.43 Click on “Logout” link
//        2.44 Verify the URL is “https://demo.nopcommerce.com/”

    }


}
