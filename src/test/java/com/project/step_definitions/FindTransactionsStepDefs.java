package com.project.step_definitions;

import com.project.pages.FindTransactionsTabPage;
import com.project.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.input.DataFormat;
import org.junit.Assert;

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
        for(String eachDate : dateAsString){
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


}
