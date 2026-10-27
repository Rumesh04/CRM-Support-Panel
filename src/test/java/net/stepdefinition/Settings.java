package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class Settings extends BaseClass {

	PomClass pom = new PomClass();

	@Given("User should be logged in the CRM Support panel")
	public void user_should_be_logged_in_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());

	}

	@Given("User is Navigate to the dashbroad page")
	public void user_is_navigate_to_the_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());

	}

	@When("User clicks on Settings in the sidebar menu")
	public void user_clicks_on_settings_in_the_sidebar_menu() {
		button(pom.getClickSettingsMenu());

	}

	@Then("User should be navigate to Settings page")
	public void user_should_be_navigate_to_settings_page() {
		Assert.assertTrue("Settings page is not displayed", pom.getSettingsPage().isDisplayed());

	}
	
	@When("User clicks on Settings module in the sidebar menu")
	public void user_clicks_on_settings_module_in_the_sidebar_menu() {
		button(pom.getClickSettingsMenu());
	}
	@When("User the clicks the {string} checkbox in notification preference section")
	public void user_the_clicks_the_checkbox_in_notification_preference_section(String string) {
	    switch(string) {
	    case "Email me on SLA breach":
	    	button(pom.getEmailCheckBox());
	    	break;
	    case "Notify on ticket reassignment":
	    	button(pom.getNotificationCheckBox());
	    	break;
	    case "Daily summary digest":
	    	button(pom.getDailyCheckBox());
	    	break;
	    default:
	    	throw new RuntimeException("Checkbox not found: "+string);
	    }
	}
	@Then("the {string} checkbox should be enabled")
	public void the_checkbox_should_be_enabled(String string) {
		Assert.assertTrue(pom.getEmailCheckBox().isEnabled() || pom.getNotificationCheckBox().isEnabled() || pom.getDailyCheckBox().isEnabled());
	}
	@When("User the clicks the {string} checkbox")
	public void user_the_clicks_the_checkbox(String string) {
		switch(string) {
	    case "Email me on SLA breach":
	    	button(pom.getEmailCheckBox());
	    	break;
	    case "Notify on ticket reassignment":
	    	button(pom.getNotificationCheckBox());
	    	break;
	    case "Daily summary digest":
	    	button(pom.getDailyCheckBox());
	    	break;
	    default:
	    	throw new RuntimeException("Checkbox not found: "+string);
	    }
	}
	@Then("the {string} checkbox should be disabled in notification preference section")
	public void the_checkbox_should_be_disabled_in_notification_preference_section(String string) {
		Assert.assertTrue(pom.getEmailCheckBox().isEnabled() || pom.getNotificationCheckBox().isEnabled() || pom.getDailyCheckBox().isEnabled());
	}

}
