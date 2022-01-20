package com.project.step_definitions;

import com.project.pages.PayBillsPage;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("User is on the pay bills page")
    public void user_is_on_the_pay_bills_page() {
        Driver.getDriver().findElement(By.linkText("Pay Bills")).click();
    }
    @Given("the {string} title is displayed")
    public void the_title_is_displayed(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title does NOT match", expectedTitle, actualTitle);
    }
    @When("User click on payee box and select {string}")
    public void user_click_on_payee_box_and_select(String payeeOption) {
        Select select = new Select(payBillsPage.payeeBox);
        select.selectByVisibleText(payeeOption);
    }
    @When("User clicks on account box and selects {string}")
    public void user_clicks_on_account_box_and_selects(String accountOption) {
        Select select = new Select(payBillsPage.accountBox);
        select.selectByVisibleText(accountOption);
    }

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
