package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopingCartPage extends BasePage{
    public ShopingCartPage (WebDriver driver){
        super(driver);
    }
    
    By chechkOutButton = By.id("checkout");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By shoppingCartContainer = By.id("shopping_cart_container");
    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By zipCodeBy = By.id("postal-code");
    By continueButton = By.id("continue");
    By priceOne = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
    By allPrices = By.className("inventory_item_price");
    By taxWebElementBy = By.className("summary_tax_label");
    By totalPriceBy = By.className("summary_total_label");
    By orderCompletionMessage = By.className("complete-header");
    By finishButton = By.id("finish");

    public ShopingCartPage goToCheckout    (){
        waitVisibility(addToCartButton1By);
        waitVisibility(addToCartButton2By);
        click(addToCartButton1By);
        click(addToCartButton2By);
        click(shoppingCartContainer);
        click(chechkOutButton);
        

        
    return this;
    }

   
    public ShopingCartPage checkOutInformationSubmit (String firstName, String lastName, String zipCode){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(zipCodeBy, zipCode);
        click(continueButton);
        return this;
    }
    public ShopingCartPage calculateThePrice (){
        
        List<WebElement> listOfPrices = driver.findElements(allPrices);
        double sum = 0;
        for (WebElement onePriceWebElement : listOfPrices){
            double onePrice = Double.parseDouble(onePriceWebElement.getText().substring(1));
            sum=sum+onePrice;
        }
        double tax = Double.parseDouble(driver.findElement(taxWebElementBy).getText().substring(6));
        sum=sum+tax;
        double totalPrice = Double.parseDouble(driver.findElement(totalPriceBy).getText().substring(8));
        Assert.assertEquals(sum,totalPrice,0.0001);
        return this;
    }
    public ShopingCartPage goToCheckOutPage (){
        click(finishButton);
        return this;
    }
    public ShopingCartPage verifyOrderCompletion (String expectedText){
        
        String actualText= driver.findElement(orderCompletionMessage).getText();
        assertTextEquals(expectedText, actualText);
        return this;
    }
}
