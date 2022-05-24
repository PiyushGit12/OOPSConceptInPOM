package com.MyTests;

import com.MyPages.BasePage;
import com.MyPages.Page;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

     public WebDriver driver;
     public Page page;


    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUpTest(String browser)  {


        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("No Browser is defined in XML file........");
        }

        driver.get("https://app.hubspot.com/login");

//        Thread.sleep(6000);

        page = new BasePage(driver);
        // we are using Child class(BasePage) of Page class(parent class) to calling constructor of page class.
        //Other wise you will get NUll Pointer.

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}


/*
  1- This public void setUp(String browser)   Browser value as a parameter pass from testng.xml so just read that parameter
    I am using parameters annotation value = browser.Will define my browser in my testNG.xml

  2- This page we have to initialize is = to . now we are going to call the constructor of Page class.bcz we have to pass the driver
     to the page.Created driver instance on line 23,27 but he have to pass it to the page then only it will we applied to all the pages.
     we have to pass this driver to page class constructor, so the page class constructor given to all to the BasePage class and LoginPage class.
     Bcz with all my pages i need my driver
     We cannot create the instance of Page class bcz that is a Abstract class.So how to create or call the constructor of Page class.
     With the help of child class of the Page class and that is BasePage class.



* */