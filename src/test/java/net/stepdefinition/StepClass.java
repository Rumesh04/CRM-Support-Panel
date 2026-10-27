package net.stepdefinition;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class StepClass extends BaseClass{
	
	PomClass pom = new PomClass();

	@Given("User is on the CRM Support Panel login page")
	public void user_is_on_the_crm_support_panel_login_page() {
		
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
	    
	}

	@When("User enters Email {string} in the Email field")
	public void user_enters_email_in_the_email_field(String string) {
		setText(pom.getEnterEmail(), string);
	    
	}

	@When("User enters password {string} in the password field")
	public void user_enters_password_in_the_password_field(String string) {
	    setText(pom.getEnterPassword(), string);
	}

	@When("User Clicks on Log In button")
	public void user_clicks_on_log_in_button() {
	    button(pom.getClickLogin());
	}

	@Then("User should be redirected to Support Dashbroad {string}")
	public void user_should_be_redirected_to_support_dashbroad(String string) {
		
		WebElement actualElement;
		
		switch(string) {
		case "Email cannot be empty":
			actualElement = pom.getEmptyEmailField();
			break;
			
		case "Password cannot be empty":
			actualElement = pom.getEmptyPasswordField();
			break;
		case "Password must be at least 6 characters long":
			actualElement = pom.getPasswordCharacterLong();
			break;
		case "Validation failed":
			actualElement = pom.getValidationFailed();
			break;
		case "Enter a valid Email address":
			actualElement = pom.getInvalidEmail();
			break;
		case "Something went wrong":
			actualElement = pom.getUnRegisterEmail();
			break;
		case "Support Dashboard":
			actualElement = pom.getDashbroadPage();
			break;
			
		default:
			throw new IllegalArgumentException("No locator mapped for: "+ string);
		}
		Assert.assertTrue("Expected message is not displayed: "+string, actualElement.isDisplayed());
	    
	}

}
