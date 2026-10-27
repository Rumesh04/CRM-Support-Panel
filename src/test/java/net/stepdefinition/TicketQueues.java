package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class TicketQueues extends BaseClass{
	
	PomClass pom = new PomClass();
	
	@Given("User is logged into the CRM Support Panel")
	public void user_is_logged_into_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}
	@Given("User is on the Support Dashbroad page CRM panel")
	public void user_is_on_the_support_dashbroad_page_crm_panel() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@When("User clicks on Ticket QUeues in the side menu")
	public void user_clicks_on_ticket_q_ueues_in_the_side_menu() {
	    button(pom.getClickTicketQueues());
	}
	@Then("User should be on the Ticket Queues page CRM panel")
	public void user_should_be_on_the_ticket_queues_page_crm_panel() {
	    Assert.assertTrue("Ticket Queues is not displayed", pom.getTicketQueuesPage().isDisplayed());
	}
	@Then("the Summary cards {string}, {string}, {string} and {string} should be displayed")
	public void the_summary_cards_and_should_be_displayed(String string, String string2, String string3, String string4) {
	    int size = pom.getSummaryCardQueue().size();
	    for(int i=0;i<size;i++) {
	    	String text = pom.getSummaryCardQueue().get(i).getText();
	    	Assert.assertTrue(text.equalsIgnoreCase(string) || text.equalsIgnoreCase(string2) || text.equalsIgnoreCase(string3) || text.equalsIgnoreCase(string4));
	    }
	}
	
	@When("User clicks on the {string} summary card")
	public void user_clicks_on_the_summary_card(String string) {
	    int size = pom.getSummaryCardQueue().size();
	    for(int i=0;i<size;i++) {
	    	String text = pom.getSummaryCardQueue().get(i).getText();
	    	//System.out.println("Summary card text: "+text);
	    	if(text.equalsIgnoreCase(string)) {
	    		pom.getSummaryCardQueue().get(i).click();
	    		return;
	    	}
	    }
	    throw new AssertionError("Summary card not found: "+ string);
	    
	}
	@Then("The table heading should display {string}")
	public void the_table_heading_should_display(String string) {
	    Assert.assertTrue("Correct Queue table heading is not displayed", pom.getQueueTableHeading().equals(string));
	}
	@Then("the Ticket table should display the queue records")
	public void the_ticket_table_should_display_the_queue_records() {
	    
	}

}
