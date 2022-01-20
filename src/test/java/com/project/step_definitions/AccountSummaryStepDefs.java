package com.project.step_definitions;

import com.project.pages.AccountSummaryPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class AccountSummaryStepDefs {

    AccountSummaryPage summaryPage = new AccountSummaryPage();

    @Then("Account summary page should be displayed and have the title {string}")
    public void account_summary_page_should_be_displayed_and_have_the_title(String expectedTitle) {
     Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @Then("Account summary page should have following account types:")
    public void account_summary_page_should_have_following_account_types(List<String> expectedAccountTypes) {
    List<String> actualAccountTypes = BrowserUtils.getElementsText(summaryPage.accountTypes);
    Assert.assertEquals(expectedAccountTypes,actualAccountTypes);

    }

    @Then("Credit Accounts table must have following columns:")
    public void credit_accounts_table_must_have_following_columns(List<String> expectedCreditAccColumns) {
    List<String>actualCreditAccColumns = BrowserUtils.getElementsText(summaryPage.creditAccColumns);
    Assert.assertEquals(expectedCreditAccColumns,actualCreditAccColumns);
    }
}
