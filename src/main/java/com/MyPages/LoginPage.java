package com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    //Page Locators

    private By emailId = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginBtn");
    private By header = By.id("//i18n-string[@data-key ='login.signupLink.text']");




    public LoginPage(WebDriver driver)
    {
        super(driver);
    }


    //Getters


    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle(){
        return getPageTitle();
    }

    public String getLoginPageHeader(){
        return getPageHeader(header) ;
    }

    public HomePage doLogin(String username, String pwd){
        getEmailId().sendKeys(username);
        getPassword().sendKeys(pwd);
        getLoginButton().click();

        return getInstance(HomePage.class) ;
    }

   // Do Login without any username and password.(Negative Testing) { method OverLoading  }

    public void doLogin(){
        getEmailId().sendKeys("");
        getPassword().sendKeys("");
        getLoginButton().click();

    }









}


/*

   1- We do some Negative testing with method OverLoading.So here we don't need to pass any getInstance bcz it will after click
      on login button it will not do anything,so this is simply void in nature.


 */