package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class KnowledgeBase extends BaseClass {
	
	PomClass pom = new PomClass();
	
	@Given("User should be logged in to CRM Support panel")
	public void user_should_be_logged_in_to_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User is Navigate to the dashbroad page of the CRM Panel")
	public void user_is_navigate_to_the_dashbroad_page_of_the_crm_panel() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@When("User clicks on Knowledge Base in the sidebar menu")
	public void user_clicks_on_knowledge_base_in_the_sidebar_menu() {
		button(pom.getClickKnowledgeMenu());
	    
	}
	@Then("User should be navigate to Knowledge Base page")
	public void user_should_be_navigate_to_knowledge_base_page() {
		Assert.assertTrue("Knowledge Base page is not displayed", pom.getKnowledgePage().isDisplayed());
	}
	
	@When("User clicks on Knowledge Base Module in the sidebar menu")
	public void user_clicks_on_knowledge_base_module_in_the_sidebar_menu() {
		button(pom.getClickKnowledgeMenu());
	}
	@When("User clicks Search icon on the top right section of the Knowledge Base page")
	public void user_clicks_search_icon_on_the_top_right_section_of_the_knowledge_base_page() {
	    button(pom.getClickKnowledgePageSearch());
	}
	@When("User enters {string} in the search field in Knowledge Base page")
	public void user_enters_in_the_search_field_in_knowledge_base_page(String string) {
	    setTextWithEnter(pom.getEnterSearchDataInKnowledge(), string);
	}
	@Then("The Article table section should display the relevant {string} Knowledge Base Article name in the table")
	public void the_article_table_section_should_display_the_relevant_knowledge_base_article_name_in_the_table(String string) {
		Assert.assertTrue("Correct summary card is not displayed", pom.getSearchDataInKnowledgeTable().getText().equals(string));
	}

}
