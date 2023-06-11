package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {
    
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chromedriver", "C:\\Users\\MladenKaca\\Desktop\\Code academy\\Code Zavrsni\\Code Zavrsni\\lib\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        int randomNumber = (int)(Math.random()*6) + 1;
        System.out.println(randomNumber);
    }
    
    @After 
    public void teardown(){
        driver.quit();
    }

}
