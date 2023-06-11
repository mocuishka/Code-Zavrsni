package pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    
    public HomePage (WebDriver driver){
        super(driver);
    }
    By homePageTitleBy = By.className("title");
    By numberOfItems = By.className("inventory_item");
    By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By addToCartButton3By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartButton4By = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By addToCartButton5By = By.id("add-to-cart-sauce-labs-onesie");
    By addToCartButton6By = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By allAddToCartButtons = By.className("btn_inventory");
    By shoppingCartContainer = By.id("shopping_cart_container");
    By firstItemCheckOutPage = By.xpath("//*[@id='item_4_title_link']/div");
    By firstItemHomePage = By.xpath("//*[@id='item_4_title_link']/div");
    By secondItemHomePage = By.xpath("//*[@id=\'item_0_title_link\']/div");
    By secondItemCheckOutPage = By.xpath("//*[@id='item_0_title_link']/div");
    
    
   
    public HomePage verifyNumberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItems);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    public HomePage verifyUnSuccesfulLogin(String expectedText){
        String actualText = readText(errorMessage);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    public HomePage addRandomItemToCart (){
        
        waitVisibility(allAddToCartButtons);
        List<WebElement> buttons = driver.findElements(allAddToCartButtons);
        Random rand = new Random();
        WebElement randomButton = buttons.get(rand.nextInt(buttons.size()));
        randomButton.click();
        waitVisibility(shoppingCartBadgeBy);
        return this;
    }
    
    public HomePage addTwoRandomItemsToCart (){
        
        waitVisibility(allAddToCartButtons);
        List<WebElement> buttons = driver.findElements(allAddToCartButtons);
        Random rand = new Random();
        WebElement randomButton = buttons.get(rand.nextInt(buttons.size()));
        randomButton.click();
        buttons.remove(randomButton);
        randomButton = buttons.get(rand.nextInt(buttons.size()));
        randomButton.click();
        waitVisibility(shoppingCartBadgeBy);
        return this;
    }
    
    public HomePage verifyTwoProductsAddedToCart (){
        click(addToCartButton1By);
        click(addToCartButton2By);
        click(shoppingCartContainer);

        return this;
    }
    
    public HomePage verifyTextsEquals(){
        waitVisibility(firstItemHomePage);
        waitVisibility(secondItemHomePage);
        String textJedanA = readText(firstItemHomePage);
        String textDvaA = readText(secondItemHomePage);
        click(addToCartButton1By);
        click(addToCartButton2By);
        click(shoppingCartContainer);
        waitVisibility(firstItemCheckOutPage);
        waitVisibility(secondItemCheckOutPage);
        String textJedanB = readText(firstItemCheckOutPage);
        String textDvaB= readText(secondItemCheckOutPage);
        assertTextEquals(textJedanB, textJedanA);
        assertTextEquals(textDvaA, textDvaB);
        return this;
    }
    public HomePage verifyBikeTextEquals(){
        waitVisibility(firstItemHomePage);
        String text = readText(firstItemHomePage);
        click(addToCartButton1By);
        click(shoppingCartContainer);
        waitVisibility(firstItemCheckOutPage);
        String textDva = readText(firstItemCheckOutPage);
        assertTextEquals(textDva, text);
        return this;
    }
    
}
