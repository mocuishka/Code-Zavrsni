package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTests extends BaseTests{
    
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String lockedOutUser = "locked_out_user";
    String errorMessageStr = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String errorMessageEmptyUsername = "Epic sadface: Username is required";
    String emptyPassword = "";
    String errorMessageEmptyPassword = "Epic sadface: Password is required";
    
@Test
    public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
    @Test
    public void verifyUnSuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(lockedOutUser, password);
    homePage.verifyUnSuccesfulLogin(errorMessageStr);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
    public void verifyUnSuccesfulLoginEmptyUsername(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    homePage.verifyUnSuccesfulLogin(errorMessageEmptyUsername);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }


}

@Test
    public void verifyUnSuccesfulLoginEmptyPassword(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    homePage.verifyUnSuccesfulLogin(errorMessageEmptyPassword);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }


}



}
