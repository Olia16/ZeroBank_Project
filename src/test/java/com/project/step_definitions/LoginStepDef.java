package com.project.step_definitions;

import com.project.pages.LoginPage;
import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("signin_button")).click();


    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username,String password ) {
    loginPage.login(username,password);

    }
    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String string) {
        Assert.assertEquals(string, Driver.getDriver().getTitle());

    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedErrorMessage) {
        Assert.assertEquals("Error message doesn't match", expectedErrorMessage,loginPage.actualErrorMessage.getText());
    }
}
