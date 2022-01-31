package com.project.step_definitions;

import com.project.pages.PayBillsPage;
import com.project.utils.BrowserUtils;
import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.List;



public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBills=new PayBillsPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {


        String url = ConfigurationReader.getProperty("url") + "login.html";
        Driver.getDriver().get(url);
//        WebElement userNameField = Driver.getDriver().findElement(By.id("user_login"));
//        WebElement passwordField = Driver.getDriver().findElement(By.id("user_password"));
        payBills.userNameField.sendKeys("username");
        payBills.passwordField.sendKeys("password" + Keys.ENTER);

    }

    @Given("the user accesses the Purchase Foreign Currency tab")
    public void the_user_accesses_the_purchase_foreign_currency_tab()  {

        WebElement purchaseForeignCurrencyBtn = Driver.getDriver().findElement(By.linkText("Purchase Foreign Currency"));
        purchaseForeignCurrencyBtn.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyList) {

        Select listSelect = new Select(PayBillsPage.currencyList);
        List<String> actualCurrencyList = BrowserUtils.getElementsText(listSelect.getOptions());
        actualCurrencyList.remove(0);
        for (String s : expectedCurrencyList) {
            Assert.assertTrue(actualCurrencyList.contains(s));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        WebElement calculateBtn=Driver.getDriver().findElement(By.id("pc_calculate_costs"));
        calculateBtn.click();

    }


    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
        alert.accept();


    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        WebElement calculateBtn=Driver.getDriver().findElement(By.id("pc_calculate_costs"));
        calculateBtn.click();

    }
}
