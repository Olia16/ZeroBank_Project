package com.project.step_definitions;

import com.project.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();


    @When("User clicks on amount box and enters {string}")
    public void user_clicks_on_amount_box_and_enters(String amount) {
       payBillsPage.accountBox.sendKeys(amount);
    }

    @When("User click on date box and enters {string}")
    public void user_click_on_date_box_and_enters(String todayDate) {
        payBillsPage.dateBox.sendKeys(todayDate);

    }

    @When("User clicks on description box and enters {string}")
    public void user_clicks_on_description_box_and_enters(String desc) {
        payBillsPage.descriptionBox.sendKeys(desc);
    }

    @When("User clicks on Pay button")
    public void user_clicks_on_pay_button() {
        payBillsPage.payButton.click();
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedMsg) {
        String actualMsg = payBillsPage.successMsg.getText();
        Assert.assertEquals("Message doesn't match",expectedMsg,actualMsg);
    }
}
