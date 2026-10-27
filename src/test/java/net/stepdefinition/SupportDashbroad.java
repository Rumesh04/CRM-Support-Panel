package net.stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class SupportDashbroad extends BaseClass {

	PomClass pom = new PomClass();

	@Given("User is logged into the CRM Support panel")
	public void user_is_logged_into_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}

	@Given("User is on the Support Dashbroad page")
	public void user_is_on_the_support_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());

	}

	@When("User selects {string} from the status dropdown")
	public void user_selects_from_the_status_dropdown(String string) {
		button(pom.getClickStatus());
		select(pom.getClickStatus(), string);
	}

	@Then("The Ticket table should display only tickets with {string} status")
	public void the_ticket_table_should_display_only_tickets_with_status(String string) {
		verifyRows();
		waitImpletic();
		int size = pom.getCols().size();
		iterateWebElement(pom.getCols(), size, string);

	}

	@When("User selects {string} from the Priority dropdown")
	public void user_selects_from_the_priority_dropdown(String string) {
		button(pom.getClickPriority());
		select(pom.getClickPriority(), string);
	}

	@Then("The Ticket table should display only tickets with {string} priority")
	public void the_ticket_table_should_display_only_tickets_with_priority(String string) {
		verifyRows();
		waitImpletic();
		int size = pom.getCols().size();
		iterateWebElement(pom.getCols(), size, string);
	}

	@When("User selects {string} from the Time Range dropdown")
	public void user_selects_from_the_time_range_dropdown(String string) {
		button(pom.getClickTimeRange());
		select(pom.getClickTimeRange(), string);
	}

	@Then("The Ticket table should display only tickets with {string} time range")
	public void the_ticket_table_should_display_only_tickets_with_time_range(String string) {
		verifyRows();
		waitImpletic();
	}

	@When("User selects {string} from the records per page dropdown")
	public void user_selects_from_the_records_per_page_dropdown(String string) {
		button(pom.getClickPerPage());
		select(pom.getClickPerPage(), string);
	}

	@Then("The table should display maximum {string} records per page")
	public void the_table_should_display_maximum_records_per_page(String string) {
		int size = pom.getRowsSize().size();
		System.out.println("Maximum records displayed in table: "+ size );
	}

	@When("User scroll down to Ticket table section")
	public void user_scroll_down_to_ticket_table_section() {
		scroll(pom.getCurrentPage());
	}

	@When("User is on the first page {string} of the ticket table")
	public void user_is_on_the_first_page_of_the_ticket_table(String string) {
	    Assert.assertTrue("Not on the first page", pom.getCurrentPage().isDisplayed());
	}

	@When("User clicks on the Next button")
	public void user_clicks_on_the_next_button() {
		String ticketIdBefore = pom.getFirstTicketId().getText();
		button(pom.getClickNextBtn());
		String ticketIdAfter = pom.getFirstTicketId().getText();
	}

	@Then("User should be Navigated to the next page {string}")
	public void user_should_be_navigated_to_the_next_page(String string) {
	    String pageNo = pom.getCurrentPage().getText();
	    Assert.assertTrue("User is not in next page", string.contains(pageNo));
	}

	@Then("The ticket table should display the records of the next page")
	public void the_ticket_table_should_display_the_records_of_the_next_page() {
		Assert.assertTrue("No records displayed on the next page", pom.getRowsSize().size()>0);
	}
	
	@When("User scroll down to Ticket table section and user is on the second page of the ticket table")
	public void user_scroll_down_to_ticket_table_section_and_user_is_on_the_second_page_of_the_ticket_table() {
		scroll(pom.getCurrentPage());
		button(pom.getClickNextBtn());
		
	}
	@When("User clicks on the previous button")
	public void user_clicks_on_the_previous_button() {
	    button(pom.getClickPreviousBtn());
	}
	
	@Then("User should be navigated to the previous page {string}")
	public void user_should_be_navigated_to_the_previous_page(String string) {
		String pageNo = pom.getCurrentPage().getText();
	    Assert.assertTrue("User is not in next page", string.contains(pageNo));
	}
	
	@Then("The ticket table should display the record of the previous page")
	public void the_ticket_table_should_display_the_record_of_the_previous_page() {
		Assert.assertTrue("No records displayed on the next page", pom.getRowsSize().size()>0);
	}
	
	@When("User clicks Search icon on the top right section of the page")
	public void user_clicks_search_icon_on_the_top_right_section_of_the_page() {
	    button(pom.getClickSearch());
	}
	
	@When("User enters {string} in the search field")
	public void user_enters_in_the_search_field(String string) {
	    setTextWithEnter(pom.getEnterSearchValue(), string);
	    scroll(pom.getCurrentPage());
	}
	@Then("The table should display the relevant {string} ticket records")
	public void the_table_should_display_the_relevant_ticket_records(String string) {
		int size = pom.getTableRecords().size();
		iterateWebElementTable(pom.getTableRecords(), size, string);
	}
	@Then("the displayed records should contain {string}")
	public void the_displayed_records_should_contain(String string) {
		int size = pom.getTableRecords().size();
		for(int i=0;i<size;i=i+2) {
			String ticketID = pom.getTableRecords().get(i).getText();
			String customer = pom.getTableRecords().get(i+1).getText();
			Assert.assertTrue("Table is not Matching", ticketID.toLowerCase().contains(string.toLowerCase()) || customer.toLowerCase().contains(string.toLowerCase()));
		}
	}
	
	@When("User clicks on the notification button")
	public void user_clicks_on_the_notification_button() {
	    button(pom.getNotificationBtn());
	}
	@Then("the notification section should be displayed")
	public void the_notification_section_should_be_displayed() {
		visibleOfElement(pom.getNotionSection());
	    Assert.assertTrue("Notification Section is not displayed", pom.getNotionSection().isDisplayed());
	}
	@Then("the notification message should be displayed")
	public void the_notification_message_should_be_displayed() {
	    int size = pom.getNotificationMessage().size();
	    for(int i=0;i<size;i++) {
	    	Assert.assertTrue(pom.getNotificationMessage().get(i).isDisplayed());
	    }
	}
	
	@Given("the Notification section is displayed")
	public void the_notification_section_is_displayed() {
		button(pom.getNotificationBtn());
		Assert.assertTrue("Notification Section is not displayed", pom.getNotionSection().isDisplayed());
	}
	@When("User clicks on notification button")
	public void user_clicks_on_notification_button() {
	    button(pom.getNotificationBtn());
	}
	@Then("the Notification section should be closed")
	public void the_notification_section_should_be_closed() {
		List<WebElement> notificationMessage = pom.getNotificationMessage();
		
		if(notificationMessage.isEmpty()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse("Notification section is still displayed", notificationMessage.get(0).isDisplayed());
		}
	}

}
