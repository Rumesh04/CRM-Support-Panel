package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class Performance extends BaseClass {
	
	PomClass pom = new PomClass();
	
	@Given("User is logged in to the CRM Support panel Application")
	public void user_is_logged_in_to_the_crm_support_panel_application() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User should Navigate to Support dashbroad page")
	public void user_should_navigate_to_support_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	

	
	@When("User clicks on Performance in the sidebar menu")
	public void user_clicks_on_performance_in_the_sidebar_menu() {
	   button(pom.getClickPerformance());
	}
	@Then("User should be navigate to Performance page")
	public void user_should_be_navigate_to_performance_page() {
	    Assert.assertTrue("Performance page is not displayed", pom.getPerformancePage().isDisplayed());
	}

}
