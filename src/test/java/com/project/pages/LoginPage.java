package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_login")
    public WebElement loginField;

    @FindBy(id = "user_password")
    public WebElement passwordField;

    public void login(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);
    }

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement actualErrorMessage;


}
