package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class Team extends BaseClass{
	
	PomClass pom = new PomClass();
	
	@Given("User is logged in to CRM Support panel Application")
	public void user_is_logged_in_to_crm_support_panel_application() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User is Navigate to the dashbroad page CRM Panel")
	public void user_is_navigate_to_the_dashbroad_page_crm_panel() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@When("User clicks on Team in the sidebar menu")
	public void user_clicks_on_team_in_the_sidebar_menu() {
	    button(pom.getClickTeamMenu());
	}
	@Then("User should be navigate to Team page")
	public void user_should_be_navigate_to_team_page() {
		Assert.assertTrue("Team page is not displayed", pom.getTeamPage().isDisplayed());
	}

}
