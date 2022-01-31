package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPayeePage {


    public AddNewPayeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameField;

    @FindBy(id = "np_new_payee_address")
    public WebElement addressField;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountField;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsField;

    @FindBy(id = "add_new_payee")
    public WebElement addBtn;

}
