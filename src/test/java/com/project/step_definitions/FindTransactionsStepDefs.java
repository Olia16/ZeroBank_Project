package com.project.step_definitions;

import com.project.pages.FindTransactionsTabPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.input.DataFormat;
import org.junit.Assert;

import java.time.LocalDate;

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


}
