package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTests {
    
    int numberOfAllItems = 6;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    

    @Test   
    public void numberOfHomePageItems(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyNumberOfProducts(numberOfAllItems);
    

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test   
    public void addedTwoProductsToCartVerificationTryOne(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyNumberOfProducts(numberOfAllItems);
    homePage.addTwoRandomItemsToCart();
    
        

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}
@Test   
    public void addedTwoProductsToCartVerification(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyNumberOfProducts(numberOfAllItems);
    homePage.verifyTextsEquals();
    
        

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}


}
