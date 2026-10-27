package net.stepdefinition;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class AllTickets extends BaseClass {

	PomClass pom = new PomClass();
	String summaryCard;
	String summaryCard2;
	String summaryCard3;
	String summaryCard4;

	@Given("User is logged in to the CRM Support panel")
	public void user_is_logged_in_to_the_crm_support_panel() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
	}

	@Given("User is on the Support dashbroad page")
	public void user_is_on_the_support_dashbroad_page() {
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}

	@When("User clicks on All Ticket in the sidebar menu")
	public void user_clicks_on_all_ticket_in_the_sidebar_menu() {
		button(pom.getClickAllTicketsMenu());
	}

	@Then("User should be on the All Ticket page")
	public void user_should_be_on_the_all_ticket_page() {
		Assert.assertTrue("All Tickets Page is not displayed", pom.getAllTicketPage().isDisplayed());
	}

	@When("User clicks on the New Ticket button")
	public void user_clicks_on_the_new_ticket_button() {
		button(pom.getClickNewTicketBtn());
	}

	@When("The New Ticket Form should be displayed")
	public void the_new_ticket_form_should_be_displayed() {
		Assert.assertTrue("New Ticket form is not displayed", pom.getNewTicketForm().isDisplayed());
	}

	@Then("The form contains Customer, Subject, Desciption, Status, Priority, category and assignee of seven fields")
	public void the_form_contains_customer_subject_desciption_status_priority_category_and_assignee_of_seven_fields() {
		int size = pom.getFieldNames().size();
		iterateWebElementForm(pom.getFieldNames(), size);
	}

	@When("User clicks on New Ticket button")
	public void user_clicks_on_new_ticket_button() {
		button(pom.getClickNewTicketBtn());
	}

	@When("User selects {string} from thw Customer dropdown in the form")
	public void user_selects_from_thw_customer_dropdown_in_the_form(String string) {
		button(pom.getClickCustomerField());
		select(pom.getClickCustomerField(), string);
	}

	@When("User enters {string} in the Subject field")
	public void user_enters_in_the_subject_field(String string) {
		setText(pom.getEnterSubjectField(), string);
	}

	@When("User enters {string} in the Description field")
	public void user_enters_in_the_description_field(String string) {
		setText(pom.getEnterDescriptionField(), string);
	}

	@When("User selects {string} from the Assignee dropdown in the form")
	public void user_selects_from_the_assignee_dropdown_in_the_form(String string) {
		select(pom.getClickAssignee(), string);
	}

	@When("User selects {string} from the Priority dropdown in the form")
	public void user_selects_from_the_priority_dropdown_in_the_form(String string) {
		select(pom.getSelectPriority(), string);
	}

	@When("User selects {string} from the Category dropdown in the form")
	public void user_selects_from_the_category_dropdown_in_the_form(String string) {
		select(pom.getClickCategory(), string);
	}

	@When("User selects {string} from the Status dropdown in the form")
	public void user_selects_from_the_status_dropdown_in_the_form(String string) {
		select(pom.getSelectStatus(), string);
	}

	@When("User clicks on the Create Ticket button")
	public void user_clicks_on_the_create_ticket_button() {
		button(pom.getClickCreateTicket());
	}

	@Then("Ticket created successfully message should be displayed")
	public void ticket_created_successfully_message_should_be_displayed() {
		visibleOfElement(pom.getNewTicketPopUp());
		Assert.assertTrue("Ticket Created message is not displayed", pom.getNewTicketPopUp().isDisplayed());
	}

	@Then("The new ticket {string} should be displayed in the ticket table")
	public void the_new_ticket_should_be_displayed_in_the_ticket_table(String string) {
		visibleOfAllElement(pom.getSubjectColumn());
		boolean found = false;
		int size = pom.getSubjectColumn().size();
		for (int i = 0; i < size; i++) {
			String text = pom.getSubjectColumn().get(i).getText();
			if (text.equalsIgnoreCase(string)) {
				found = true;
				break;
			}
		}
		Assert.assertTrue("New Ticket is not displayed in the table", found);
	}

	@When("User observe the {string} count displayed in the summary card")
	public void user_observe_the_count_displayed_in_the_summary_card(String string) {
	    summaryCard = getSummaryCard(string);
	    System.out.println(string + "count: " + summaryCard);
		
	}

	@When("User scroll down to table section and select Records per page dropdown option {string}")
	public void user_scroll_down_to_table_section_and_select_records_per_page_dropdown_option(String string) {
		scroll(pom.getCurrentPage());
		button(pom.getRecordPerPage());
		button(pom.getSelectOption20());
	}

	@Then("the Total Tickets table record count should match the summary card count")
	public void the_total_tickets_table_record_count_should_match_the_summary_card_count() {
		
		visibleOfAllElement(pom.getTableRowCount());
		int tableCount = pom.getTableRowCount().size();
		Assert.assertEquals("Summary count and table count are not same", Integer.parseInt(summaryCard), tableCount);
	}

	@When("User observe the {string} count displayed in the summary card Open Ticket")
	public void user_observe_the_count_displayed_in_the_summary_card_open_ticket(String string) {
	      summaryCard2 = getSummaryCard(string);
	      System.out.println(string + "count:" + summaryCard2);
	}

	@When("User selects {string} option in the Status filter dropdown")
	public void user_selects_option_in_the_status_filter_dropdown(String string) {
		button(pom.getFilter());
		button(pom.getStatusFilterOpenOptions());
		
	}

	@Then("the Open Tickets table record count should match the summary card count")
	public void the_open_tickets_table_record_count_should_match_the_summary_card_count() {
		visibleOfAllElement(pom.getTableRowCount());
		int tableCount = pom.getTableRowCount().size();
		Assert.assertEquals("Summary count and table count are not same", Integer.parseInt(summaryCard2), tableCount);
	}

	@When("User observe the {string} count displayed in the summary card In Progress")
	public void user_observe_the_count_displayed_in_the_summary_card_in_progress(String string) {
	    summaryCard3 = getSummaryCard(string);
	    System.out.println(string + "count: " + summaryCard3);
	}

	@When("User select {string} option in the Status filter dropdown")
	public void user_select_option_in_the_status_filter_dropdown(String string) {
		button(pom.getFilter());
		button(pom.getStatusFilterInProgressOptions());
	}

	@Then("the In Progress table record count should match the summary card count")
	public void the_in_progress_table_record_count_should_match_the_summary_card_count() {
		visibleOfAllElement(pom.getTableRowCount());
		int tableCount = pom.getTableRowCount().size();
		Assert.assertEquals("Summary count and table count are not same", Integer.parseInt(summaryCard3), tableCount);
	}

	@When("User select {string} Resolved in the Status filter dropdown")
	public void user_select_resolved_in_the_status_filter_dropdown(String string) {
	    String summaryCard4 = getSummaryCard(string);
	    System.out.println(string + "count: " + summaryCard4);
	}

	@When("User selects {string} Resolved in the Status filter dropdown")
	public void user_selects_resolved_in_the_status_filter_dropdown(String string) {
		button(pom.getFilter());
		button(pom.getStatusFilterResolvedOptions());
	}

	@Then("the Resolved table record count should match the summary card count")
	public void the_resolved_table_record_count_should_match_the_summary_card_count() {
		visibleOfAllElement(pom.getTableRowCount());
		int tableCount = pom.getTableRowCount().size();
		Assert.assertEquals("Summary count and table count are not same", Integer.parseInt(summaryCard4), tableCount);
	}
	
	@When("User clicks on the Assignee dropdown of the first ticket in the table")
	public void user_clicks_on_the_assignee_dropdown_of_the_first_ticket_in_the_table() {
	    button(pom.getSelectAssignee());
	}
	@Then("The Assignee dropdown should contain the support team member names")
	public void the_assignee_dropdown_should_contain_the_support_team_member_names() {
	    int size = pom.getAssigneeOptions().size();
	    iterateWebElementForm(pom.getAssigneeOptions(), size);
	    System.out.println("Assignee member: "+ size);
	}
	
	@When("User select {string} from the Assignee dropdown of the first ticket in the table")
	public void user_select_from_the_assignee_dropdown_of_the_first_ticket_in_the_table(String string) {
		select(pom.getSelectAssignee(), string);
	    
	}
	@Then("the Assignee column of the first ticket should display {string}")
	public void the_assignee_column_of_the_first_ticket_should_display(String string) {
	    String text = pom.getSelectAssignee().getText();
	    Assert.assertTrue("Assignee option does not change the option", text.equalsIgnoreCase(string));
	}
	
	@When("User clicks the Edit action for a ticket from the first row of the table")
	public void user_clicks_the_edit_action_for_a_ticket_from_the_first_row_of_the_table() {
		scroll(pom.getActionColumn());
	    button(pom.getEditBtn());
	}
	
	@Then("the Edit Ticket form should be displayed")
	public void the_edit_ticket_form_should_be_displayed() {
	    Assert.assertTrue("Ticket Form is not displayed ", pom.getTicketFormPage().isDisplayed());
	}
	
	@When("User clicks the Edit action for ticket")
	public void user_clicks_the_edit_action_for_ticket() {
		scroll(pom.getActionColumn());
	    button(pom.getEditBtn());
	}
	@When("User selects {string} as the priority")
	public void user_selects_as_the_priority(String string) {
		button(pom.getClickEditFormPriority());
		selectPriority(string);
	}
	@When("User selects {string} as the status")
	public void user_selects_as_the_status(String string) {
	    button(pom.getClickEditFormStatus());
	    selectStatus(string);
	}
	@When("User selects {string} as the category")
	public void user_selects_as_the_category(String string) {
	    button(pom.getClickEditFormCategory());
	    selectCategory(string);
	}
	@When("User clicks the Save Change button")
	public void user_clicks_the_save_change_button() {
	    button(pom.getClickSaveChange());
	}
	@Then("The ticket should be updated successfully")
	public void the_ticket_should_be_updated_successfully() {
		visibleOfElement(pom.getTicketFormPopup());
	    Assert.assertTrue("Edit Ticket Form Pop up is not appeared", pom.getTicketFormPopup().isDisplayed());
	}
	@Then("the ticket table should display priority {string} and status {string}")
	public void the_ticket_table_should_display_priority_and_status(String string, String string2) {
	    String priority = pom.getFormPriority().getText();
	    String status = pom.getFormStatus().getText();
	    Assert.assertTrue("Priority not updated in the table", priority.equalsIgnoreCase(string));
	    Assert.assertTrue("Status not updated in the table", status.equalsIgnoreCase(string2));
	}
	
	@When("User clicks New Ticket button")
	public void user_clicks_new_ticket_button() {
		button(pom.getClickNewTicketBtn());
	}
	@When("User selects {string} in the Customer field")
	public void user_selects_in_the_customer_field(String string) {
		//button(pom.getClickCustomerField());
		select(pom.getClickCustomerField(), string);
	}
	@When("User enters {string} in Subject field")
	public void user_enters_in_subject_field(String string) {
		setText(pom.getEnterSubjectField(), string);
	}
	@When("User enters {string} in Description field")
	public void user_enters_in_description_field(String string) {
		setText(pom.getEnterDescriptionField(), string);
	}
	@When("User selects {string} from the Assignee dropdown in form")
	public void user_selects_from_the_assignee_dropdown_in_form(String string) {
		select(pom.getClickAssignee(), string);
	}
	@When("User selects {string} from the Priority dropdown in form")
	public void user_selects_from_the_priority_dropdown_in_form(String string) {
		select(pom.getSelectPriority(), string);
	}
	@When("User selects {string} from the Category dropdown in form")
	public void user_selects_from_the_category_dropdown_in_form(String string) {
		select(pom.getClickCategory(), string);
	}
	@When("User selects {string} from the Status dropdown in form")
	public void user_selects_from_the_status_dropdown_in_form(String string) {
		select(pom.getSelectStatus(), string);
	}
	@When("User clicks on Create Ticket button")
	public void user_clicks_on_create_ticket_button() {
		button(pom.getClickCreateTicket());
	}
	@Then("The new ticket {string} should be displayed in ticket table")
	public void the_new_ticket_should_be_displayed_in_ticket_table(String string) {
		
		WebElement actualResult;
		
		switch(string) {
		case "leadId is not allowed to be empty":
			actualResult = pom.getEmptyCustomerField();
			break;
		case "title is not allowed to be empty":
			actualResult = pom.getEmptySubjectField();
			break;
		case "description is not allowed to be empty":
			actualResult = pom.getEmptyDescribleField();
			break;
		case "priority is not allowed to be empty":
			actualResult = pom.getEmptyPriorityField();
			break;
		case "category is not allowed to be empty":
			actualResult = pom.getEmptyCategoryField();
			break;
		case "status is not allowed to be empty":
			actualResult = pom.getEmptyStatusField();
			break;
		case "assignTo is not allowed to be empty":
			actualResult = pom.getEmptyAssigneeField();
			break;
			default:
				throw new IllegalArgumentException("No locator mapped for: "+ string);
		}
		Assert.assertTrue("Expected message is not displayed: "+string, actualResult.isDisplayed());
	}
	
	@When("The Records Table Section should be displayed")
	public void the_records_table_section_should_be_displayed() {
	    Assert.assertTrue("Table is not displyed", pom.getTable().isDisplayed());
	}
	
	@When("User clicks on the {string} column header")
	public void user_clicks_on_the_column_header(String string) {
	    switch(string.trim().toLowerCase()) {
	    case "ticketid":
	    	button(pom.getTicketId());
	    	break;
	    	
	    case "customer":
	    	button(pom.getCustomer());
	    	break;
	    case "subject":
	    	button(pom.getSubject());
	    	break;
	    case "priority":
	    	button(pom.getPriority());
	    	break;
	    case "status":
	    	button(pom.getStatus());
	    	break;
	    default:
	    	throw new RuntimeException("Column not found: "+string);
	    }
	}
	@Then("Table records  should be displalyed Ascending order of {string} column")
	public void table_records_should_be_displalyed_ascending_order_of_column(String string) {
	    printTable();
	}

}
