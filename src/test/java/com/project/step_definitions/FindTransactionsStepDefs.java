package com.project.step_definitions;

import com.project.pages.FindTransactionsTabPage;
import com.project.utils.BrowserUtils;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsStepDefs {

    FindTransactionsTabPage transactionsTabPage = new FindTransactionsTabPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        transactionsTabPage.findTransactionsTab.click();
    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String toDate) {
       transactionsTabPage.dateFrom.sendKeys(dateFrom);
       transactionsTabPage.toDate.sendKeys(toDate);

    }
    @When("clicks search")
    public void clicks_search() {
        transactionsTabPage.findBtn.click();
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {


//   //div[@id='all_transactions_for_account']//td[contains(text(),2012)]
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

    }

    String description = "";

    @When("the user enters description {string}")
    public void theUserEntersDescription(String input) {
        description = input.toUpperCase();
        transactionsTabPage.descriptionBox.clear();
        transactionsTabPage.descriptionBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String correctDescription) {
        List<WebElement> actualOutputFromRT = transactionsTabPage.getInputFromResultsTable(description);
        for(WebElement each : actualOutputFromRT){
            String actualOutput = each.getText();
            Assert.assertTrue(actualOutput.contains(correctDescription));
            System.out.println(each.getText());
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String wrongDescription) {
        List<WebElement> actualOutputFromRT = transactionsTabPage.getInputFromResultsTable(description);
        for(WebElement each : actualOutputFromRT){
            String actualOutput = each.getText();
            Assert.assertFalse(actualOutput.contains(wrongDescription));
            System.out.println(each.getText());
        }
    }

    @Then("results table should show at least one result under {string} and {string}")
    public void results_table_should_show_at_least_one_result_under_and(String type, String otherType) {
        int count = 0;
        for(WebElement each : transactionsTabPage.getColumn(type)){
            if(!each.getText().isEmpty()){
                count++;
            }
        }
        Assert.assertTrue(count>0);
        count = 0;
        for(WebElement each : transactionsTabPage.getColumn(otherType)){
            if(!each.getText().isEmpty()){
                count++;
            }
        }
        Assert.assertTrue(count>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        BrowserUtils.sleep(3);
        Select select = new Select(transactionsTabPage.typeDropdown);
        select.selectByVisibleText(type);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
        int count = 0;
        for(WebElement each : transactionsTabPage.getColumn(type)){
            if(!each.getText().isEmpty()){
                count++;
            }
        }
        Assert.assertTrue(count>0);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String otherType) {
        for(WebElement each : transactionsTabPage.getColumn(otherType)){
            Assert.assertEquals("",each.getText());
        }
    }

}
