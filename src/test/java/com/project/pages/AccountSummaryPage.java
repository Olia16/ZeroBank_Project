package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h2")
   public List<WebElement>accountTypes;

    @FindBy(xpath = "(//table)[3]//thead/tr/th")
    public List<WebElement>creditAccColumns;

}
