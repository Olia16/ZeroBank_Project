package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayeeConfirmationPage {
    public PayeeConfirmationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "alert_content")
    public WebElement alertMessage;

}
