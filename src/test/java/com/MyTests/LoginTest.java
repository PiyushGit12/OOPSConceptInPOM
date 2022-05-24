package com.MyTests;

import com.MyPages.HomePage;
import com.MyPages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class LoginTest extends BaseTest {


    @Test()
    public void verifyLoginPageTitleTest(){

       String title = page.getInstance(LoginPage.class).getLoginPageTitle();
       System.out.println(title);
        Assert.assertEquals(title, "HubSpot login");

    }

    @Test()
    public void verifyLoginPageHeaderTest(){

        String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Don't have an account?");

    }

    @Test()
    public void doLoginTest(){

      HomePage homePage = page.getInstance(LoginPage.class).doLogin("SomeUserName@gmail.com","Password");
      String headerHome = homePage.getHomePageHeader();
      System.out.println(headerHome);
      Assert.assertEquals(headerHome, "Getting started with HubSpot");

    }














}

/*
  1- Every loginTest page should extends your BaseTest class.
  2- In this method verifyLoginPageTitleTest  I need to call getLoginPageTitle method from LoginPage class.So for that we need to
     create the Object of LoginPage.So you have two choices either you create:-
     a- LoginPage Lp = new LoginPage();
     b- I want the help of Generics ,So Page.getInstance Method  and page is coming from BaseTest class that's why we have created
      a Page over there.So that we can inherit this page class reference in loginTest class.

      So Page.getInstance(LoginPage.class).getLoginPageTitle() and store it in String.


* */