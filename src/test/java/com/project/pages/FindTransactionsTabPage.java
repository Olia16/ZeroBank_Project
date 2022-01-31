package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsTabPage {

    public FindTransactionsTabPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;



}
