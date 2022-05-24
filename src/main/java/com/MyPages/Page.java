package com.MyPages;

//This is the abstract page class.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    public WebDriver driver;
    WebDriverWait wait;

    protected Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);               // Explicit Wait.

    }

    //Abstract Methods.

    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract void waitForElementPresent(By locator);

    public abstract void waitForPageTitle(String title);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {

        try
        {   return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
}

/*
   1- Create Certain rules there that every page should have abstract methods.
   2- We will create the getElement at runtime and return type must be WebElement.




*/