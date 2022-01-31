package com.project.step_definitions;

import com.project.pages.AddNewPayeePage;
import com.project.pages.AddNewPayeeUnderPayBillsPage;
import com.project.pages.PayeeConfirmationPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeUnderPayBillsStepDef {

    Map<String, String> infoMap;

    @Given("Add New Payee tab")
    public void add_new_payee_tab() {
        AddNewPayeeUnderPayBillsPage addNewPayee = new AddNewPayeeUnderPayBillsPage();
        addNewPayee.addNewPayee.click();
    }

    @Given("creates new payee using following information:")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfoMap) {
        AddNewPayeePage addNewPayeePage = new AddNewPayeePage();
       // infoMap.putAll(payeeInfoMap);
        addNewPayeePage.payeeNameField.sendKeys(payeeInfoMap.get("Payee name"));
        addNewPayeePage.addressField.sendKeys(payeeInfoMap.get("Payee Address"));
        addNewPayeePage.accountField.sendKeys(payeeInfoMap.get("Account"));
        addNewPayeePage.payeeDetailsField.sendKeys(payeeInfoMap.get("Payee details"));
        addNewPayeePage.addBtn.click();
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        PayeeConfirmationPage confirmMsg = new PayeeConfirmationPage();
        String actualMessage = confirmMsg.alertMessage.getText();
        Assert.assertEquals("Message doesn't match",expectedMessage,actualMessage);
    }
}
