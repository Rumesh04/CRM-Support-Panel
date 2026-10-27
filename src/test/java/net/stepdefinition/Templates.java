package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class Templates extends BaseClass {
	
	PomClass pom = new PomClass();
	
	@Given("User should be logged into the CRM Support panel")
	public void user_should_be_logged_into_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User is Navigate to the Support dashbroad page")
	public void user_is_navigate_to_the_support_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@When("User clicks on Templates in the sidebar menu")
	public void user_clicks_on_templates_in_the_sidebar_menu() {
	    button(pom.getClickTemplatesMenu());
	}
	@Then("User should be navigate to Templates page")
	public void user_should_be_navigate_to_templates_page() {
	    Assert.assertTrue("Templates page is not displayed", pom.getTemplatesPage().isDisplayed());
	}
	
	@When("User clicks on Templates Module in the sidebar menu")
	public void user_clicks_on_templates_module_in_the_sidebar_menu() {
		button(pom.getClickTemplatesMenu());
	}
	@When("User clicks Search icon on the top right section of the Templates page")
	public void user_clicks_search_icon_on_the_top_right_section_of_the_templates_page() {
	    button(pom.getClickTemplatesPageSearch());
	}
	@When("User enters {string} in the search field in Templates page")
	public void user_enters_in_the_search_field_in_templates_page(String string) {
	    setTextWithEnter(pom.getEnterSearchDataInTemplates(), string);
	}
	@Then("The Templates Name section should display the relevant {string} Templates name in the table")
	public void the_templates_name_section_should_display_the_relevant_templates_name_in_the_table(String string) {
		Assert.assertTrue("Correct Templates name is not displayed", pom.getSearchDataInTemplatesTable().getText().equals(string));
	}

}
