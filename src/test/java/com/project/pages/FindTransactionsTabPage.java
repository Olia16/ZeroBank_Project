package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindTransactionsTabPage {

    public FindTransactionsTabPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFromField;

    @FindBy(id = "aa_toDate")
    public WebElement toDateField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> resultDates;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    public List<WebElement> getInputFromResultsTable(String input){
        return Driver.getDriver().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[contains(text(),'"+input+"')]"));
    }

    public List<WebElement> getColumn(String type){
        int index = 0;
        if(type.equals("Deposit")){
            index = 3;
        }else if(type.equals("Withdrawal")){
            index = 4;
        }
        return Driver.getDriver().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td["+index+"]"));
    }



}
