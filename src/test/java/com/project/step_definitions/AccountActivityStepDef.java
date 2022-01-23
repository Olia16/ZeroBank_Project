package com.project.step_definitions;


import com.project.pages.AccountActivityPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Set;

public class AccountActivityStepDef {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user navigates to Account Activity page")
    public void the_user_navigates_to_account_activity_page() {
        //BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.linkText("Account Activity")).click();
    }
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedAATitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Page does NOT match", expectedAATitle,actualTitle);
    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedAccountType) {
        String actualAccountType = accountActivityPage.selectedOption();
        Assert.assertEquals("Account does NOT match", expectedAccountType,actualAccountType);
    }
    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedAccountList) {
        Set<String> actualAccountList = accountActivityPage.accountOptionsList();
        System.out.println("actualAccountList " + actualAccountList);
        System.out.println("expectedAccountList "+ expectedAccountList);
        Assert.assertTrue("Assertion fail", expectedAccountList.containsAll(actualAccountList));

    }
    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(accountActivityPage.accountColumnNames);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }



}
