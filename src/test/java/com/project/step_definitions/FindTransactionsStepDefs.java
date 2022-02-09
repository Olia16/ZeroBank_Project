package com.project.step_definitions;

import com.project.pages.FindTransactionsTabPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    FindTransactionsTabPage transactionsTabPage = new FindTransactionsTabPage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        transactionsTabPage.findTransactionsTab.click();

    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String toDate) {
        transactionsTabPage.dateFromField.clear();
        transactionsTabPage.dateFromField.sendKeys(dateFrom);
        transactionsTabPage.toDateField.clear();
        transactionsTabPage.toDateField.sendKeys(toDate);

    }
    @When("clicks search")
    public void clicks_search() {
        transactionsTabPage.findBtn.click();
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        //converting fromDate param to simple data format
        Date from = dateFormat.parse(fromDate);
        Date to = dateFormat.parse(toDate);

        //converting result dates into list of string
        List<String> dateAsString = BrowserUtils.getElementsText(transactionsTabPage.resultDates);
        List<Date> actualDates = new ArrayList<>();
        BrowserUtils.sleep(2);
        for(String eachDate : dateAsString){
            BrowserUtils.sleep(2);
            actualDates.add(dateFormat.parse(eachDate));
        }
        for (Date actualDate : actualDates){
            boolean isBetween = (actualDate.after(from)) || actualDate.equals(from) &&
                    actualDate.before(to) || actualDate.equals(to);
            Assert.assertTrue(isBetween);
        }

    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {

        List<String> dateAsString = BrowserUtils.getElementsText(transactionsTabPage.resultDates);
        List<Date> actualDates = new ArrayList<>();
        for(String eachDate : dateAsString){
            actualDates.add(dateFormat.parse(eachDate));
        }

        int count = 0;
        for(int i = 1; i < actualDates.size(); i++){
            Date max = actualDates.get(count++);
            Assert.assertTrue(max.after(actualDates.get(i)));

        }
    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String firstDate) {
        List<String> dateAsString = BrowserUtils.getElementsText(transactionsTabPage.resultDates);
        Assert.assertFalse(dateAsString.contains(firstDate));

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
        Assert.assertTrue(count>=1);
    }
    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select select = new Select(transactionsTabPage.typeDropdown);
        select.selectByVisibleText(type);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(transactionsTabPage.getColumn(type).get(0))));

        BrowserUtils.sleep(2);
        int count = 0;
        for(WebElement each : transactionsTabPage.getColumn(type)){
            if(!each.getText().isEmpty()){
                count++;
            }
        }
        Assert.assertTrue(count>=1);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String otherType) {
        for(WebElement each : transactionsTabPage.getColumn(otherType)){
            Assert.assertEquals("",each.getText());
        }
    }

}
