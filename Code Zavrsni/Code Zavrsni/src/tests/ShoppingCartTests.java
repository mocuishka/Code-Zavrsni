package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopingCartPage;

public class ShoppingCartTests extends BaseTests{

    int numberOfAllItems = 6;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String firstName = "Mladen";
    String lastName = "Sretenovic";
    String zipCode = "34000";
    String expectedText = "Thank you for your order!";
    
    @Test   
    public void thePriceIsRight(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ShopingCartPage shopingCartPage = new ShopingCartPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyNumberOfProducts(numberOfAllItems);
    shopingCartPage.goToCheckout();
    shopingCartPage.checkOutInformationSubmit(firstName,lastName,zipCode);
    shopingCartPage.calculateThePrice();
    shopingCartPage.goToCheckOutPage();
    shopingCartPage.verifyOrderCompletion(expectedText);    
    
        

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}


    
}
