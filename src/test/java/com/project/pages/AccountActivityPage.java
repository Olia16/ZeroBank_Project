package com.project.pages;

import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;


public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy (xpath = "//thead/tr/th")
    public List<WebElement> accountColumnNames;

    public String selectedOption(){
        Select accountsOptions = new Select(accountDropDown);
        return accountsOptions.getFirstSelectedOption().getText();
    }

    public Set<String> accountOptionsList(){
        Select accountsOptionsDropDown = new Select(accountDropDown);
        return BrowserUtils.getElementsTextWithoutDouble(accountsOptionsDropDown.getOptions());
    }


}
