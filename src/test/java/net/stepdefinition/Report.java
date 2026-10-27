package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class Report extends BaseClass{
	
	PomClass pom = new PomClass();
	
	@Given("User should logged into the CRM Support panel")
	public void user_should_logged_into_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User is Navigate to Support dashbroad page")
	public void user_is_navigate_to_support_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@When("User clicks on Report in the sidebar menu")
	public void user_clicks_on_report_in_the_sidebar_menu() {
		waitImpletic();
	    button(pom.getClickReport());
	}
	@Then("User should be navigate to Report page")
	public void user_should_be_navigate_to_report_page() {
	    Assert.assertTrue("Report is not displayed", pom.getReportPage().isDisplayed());
	}
	
	@When("User clicks on Report Module in the sidebar menu")
	public void user_clicks_on_report_module_in_the_sidebar_menu() {
		button(pom.getClickReport());
	}
	
	@When("User clicks Search icon on the top right section of the Report page")
	public void user_clicks_search_icon_on_the_top_right_section_of_the_report_page() {
	    button(pom.getClickReportPageSearch());
	}
	@When("User enters {string} in the search field in Report page")
	public void user_enters_in_the_search_field_in_report_page(String string) {
	    setTextWithEnter(pom.getEnterSearchDataInReport(), string);
	}
	@Then("The Summard card should display the relevant {string} summary card")
	public void the_summard_card_should_display_the_relevant_summary_card(String string) {
	    Assert.assertTrue("Correct summary card is not displayed", pom.getReportSummaryCard().getText().equals(string));
	}

}
