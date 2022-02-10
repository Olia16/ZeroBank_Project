package com.project.pages;

import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "sp_payee")
    public WebElement payeeBox;

    @FindBy(id = "sp_account")
    public WebElement accountBox;

    @FindBy(id = "sp_amount")
    public WebElement amountBox;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    @FindBy(id = "sp_description")
    public WebElement descriptionBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[@title='$ 1000 payed to payee bofa']")
    public WebElement successMsg;

    @FindBy(id = "pc_currency")
    public static WebElement currencyList;

    @FindBy(id = "user_login")
    public  WebElement userNameField;

    @FindBy(id = "user_password")
    public WebElement passwordField;





}
