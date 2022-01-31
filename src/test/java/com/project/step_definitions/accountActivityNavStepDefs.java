package com.project.step_definitions;

import com.project.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accountActivityNavStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();


    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String expOption) {
        if(expOption.equals(accountSummaryPage.savings.getText()))
        accountSummaryPage.savings.click();

        else if(expOption.equals(accountSummaryPage.brokerage.getText()))
            accountSummaryPage.brokerage.click();

        else if(expOption.equals(accountSummaryPage.checking.getText()))
            accountSummaryPage.checking.click();

        else if(expOption.equals(accountSummaryPage.creditCard.getText()))
            accountSummaryPage.creditCard.click();

        else if(expOption.equals(accountSummaryPage.loan.getText()))
                accountSummaryPage.loan.click();

        else System.err.println("Account option not available");

    }
}
