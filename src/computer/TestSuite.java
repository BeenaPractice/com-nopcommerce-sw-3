package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";
    @Before
    public void browserSetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeAlphabeticalOrder(){
        //1.1 Click on Computer Menu.
        selectMenu("Computers");
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: Z to A");
        List<WebElement> list = driver.findElements(By.xpath("//h2[@class='product-title']"));
        for (WebElement e : list) {
            System.out.println(e.getText());
            //1.4 Verify the Product will arrange in Descending order.
            WebElement sortByElement1 = driver.findElement(By.xpath("//select[@id='products-orderby']"));
            Select select1 = new Select(sortByElement1);
            select1.selectByVisibleText("Name: A to Z");



            List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
            List<Double> beforeFileNameZtoAList= new ArrayList<>();
            for(WebElement nameZtoA : beforeFilterNameZtoAList)
            {
                beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
            }

            select.selectByVisibleText("Name: Z to A");

            List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
            List<Double>afterFileNameZtoAList = new ArrayList<>();
            for(WebElement nameZtoA : afterFilterNameZtoAList)
            {
                afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
            }

            Collections.sort(beforeFileNameZtoAList);
            Assert.assertEquals(beforeFilterNameZtoAList,afterFilterNameZtoAList);

        }
        }



    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        selectMenu("Computers");
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);


        //2.4 Click on "Add To Cart"
        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]")).click();

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_10"));

        clickOnElement(By.id("product_attribute_5_12"));

        //2.11 Verify the price "$1475.00"
        String actualPrice = driver.findElement(By.id("price-value-1")).getText();
        String expectedPrice = "$1,300.00";
        // Assert.assertEquals("",actualPrice,expectedPrice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar

        String actualText1 = getTextFromElement(By.xpath("//p[@class='content']"));
        String expectedText1 = "The product has been added to your shopping cart\" on Top\n" +
                "        //green Bar";

        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        goToCart.click();

        //2.15 Verify the message "Shopping cart"
        String actualCart = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        String expectedCart = "Shopping cart";
        Assert.assertEquals("", actualCart, expectedCart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String expectedText3 = "$2,850.00";
        String updatedPrice = driver.findElement(By.xpath("//span[@class='value-summary']")).getText();
        Assert.assertEquals("", expectedText3, updatedPrice);

        //  2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //  2.20 Verify the Text “Welcome, Please Sign In!”
        String actualText4 = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        String expectedText4 = "Welcome, Please Sign In!";
        Assert.assertEquals("", actualText4, expectedText4);

        //  2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //  2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Testing");
        sendTextToElement(By.id("BillingNewAddress_Email"), "primetesting@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "1,Downing Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW2 5KZ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567890");

        //  2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //  2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //  2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //    2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //   2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master Card");

        //    2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime Testing");
        sendTextToElement(By.id("CardNumber"), "2233445566778899");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "08");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2030");
        sendTextToElement(By.id("CardCode"), "123");

        //   2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // 2.30 Verify “Payment Method” is “Credit Card”
        String expectedText5 = "Credit Card";
        String actualText5 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("", expectedText5, actualText5);

        // 2.32	Verify “Shipping Method” is “Next Day Air”
        String expectedText6 = "Next Day Air";
        String actualText6 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals("", expectedText6, actualText6);


        // 2.33	Verify Total is “$2,950.00”
        String expectedValue1 = "$2,940.00";
        Thread.sleep(5000);
        String actualValue1 = getTextFromElement(By.xpath("//span[@class='value-summary']"));
        Assert.assertEquals("", expectedValue1, actualValue1);

        //2.34	Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
// 2.35	Verify the Text “Thank You”
        String expectedText7 = "Thank you";
        String actualText7 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("", expectedText7, actualText7);

        // 2.36	Verify the message “Your order has been successfully processed!”
        String expectedText8 = "Your order has been successfully processed!";
        String actualText8 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("", expectedText8, actualText8);


        // 2.37	Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.37 Verify the text “Welcome to our store”
        String expectedText9 = "Welcome to our store";
        String actualText9 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("", expectedText9, actualText9);

    }
}
