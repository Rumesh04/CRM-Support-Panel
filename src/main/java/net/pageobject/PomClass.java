package net.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.utility_class.BaseClass;

public class PomClass extends BaseClass {
	
	public PomClass() {
		PageFactory.initElements(driver, this);
	}
	
	//Log-in
	@FindBy(name = "email")
	private WebElement enterEmail;
	
	@FindBy(name = "password")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement clickLogin;
	
	@FindBy(xpath = "//p[text()='Email cannot be empty']")
	private WebElement emptyEmailField;
	
	@FindBy(xpath = "//p[text()='Password cannot be empty']")
	private WebElement emptyPasswordField;
	
	@FindBy(xpath = "//p[text()='Password must be at least 6 characters long']")
	private WebElement passwordCharacterLong;
	
	@FindBy(xpath = "//p[text()='Enter a valid Email address']")
	private WebElement invalidEmail;
	
	@FindBy(xpath = "//h1[text()='Support Dashboard']")
	private WebElement dashbroadPage;
	
	@FindBy(xpath = "//div[normalize-space()='Validation failed']")
	private WebElement validationFailed;
	
	@FindBy(xpath = "//div[normalize-space()='Something went wrong']")
	private WebElement unRegisterEmail;

	public WebElement getEnterEmail() {
		return enterEmail;
	}

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	public WebElement getClickLogin() {
		return clickLogin;
	}

	public WebElement getEmptyEmailField() {
		return emptyEmailField;
	}

	public WebElement getEmptyPasswordField() {
		return emptyPasswordField;
	}

	public WebElement getPasswordCharacterLong() {
		return passwordCharacterLong;
	}

	public WebElement getInvalidEmail() {
		return invalidEmail;
	}

	public WebElement getDashbroadPage() {
		return dashbroadPage;
	}

	public WebElement getValidationFailed() {
		return validationFailed;
	}

	public WebElement getUnRegisterEmail() {
		return unRegisterEmail;
	}
	
	//Support dashbroad
	@FindBy(xpath = "(//div[@class='relative']/select)[1]")
	private WebElement clickStatus;
	
	@FindBy(xpath = "//div[@class='relative']/select/option")
	private List<WebElement> filterOptions;
	
	@FindBy(xpath = "(//div[@class='relative']/select)[2]")
	private WebElement clickPriority;
	
	@FindBy(xpath = "(//div[@class='relative']/select)[3]")
	private WebElement clickTimeRange;
	
	@FindBy(xpath = "//table[@class='w-full text-sm text-left']/tbody/tr[\"+i+\"]/td")
	private List<WebElement> tableData;
	
	@FindBy(xpath = "//td/span[text()='OPEN']")
	private List<WebElement> openColumn;
	
	@FindBy(xpath = "//td/span")
	private List<WebElement> cols;

	public List<WebElement> getCols() {
		return cols;
	}

	public List<WebElement> getOpenColumn() {
		return openColumn;
	}

	public WebElement getClickStatus() {
		return clickStatus;
	}

	public List<WebElement> getFilterOptions() {
		return filterOptions;
	}

	public WebElement getClickPriority() {
		return clickPriority;
	}

	public WebElement getClickTimeRange() {
		return clickTimeRange;
	}

	public List<WebElement> getTableData() {
		return tableData;
	}
	
	//DashBroad Pagination
	@FindBy(xpath = "//select[contains(@class,'border px-2 py-1')]")
	private WebElement clickPerPage;
	
	@FindBy(xpath = "//select[contains(@class,'border px-2 py-1')]/option")
	private List<WebElement> selectPerPageOption;
	
	@FindBy(xpath = "//table/tbody/tr")
	private List<WebElement> rowsSize;

	public WebElement getClickPerPage() {
		return clickPerPage;
	}

	public List<WebElement> getSelectPerPageOption() {
		return selectPerPageOption;
	}

	public List<WebElement> getRowsSize() {
		return rowsSize;
	}
	
	@FindBy(xpath = "//div[@class='text-sm text-white-70']")
	private WebElement currentPage;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement clickNextBtn;
	
	@FindBy(xpath = "(//table/tbody/tr/td)[1]")
	private WebElement firstTicketId;
	
	@FindBy(xpath = "//button[text()='Prev']")
	private WebElement clickPreviousBtn;

	public WebElement getClickPreviousBtn() {
		return clickPreviousBtn;
	}

	public WebElement getFirstTicketId() {
		return firstTicketId;
	}

	public WebElement getCurrentPage() {
		return currentPage;
	}

	public WebElement getClickNextBtn() {
		return clickNextBtn;
	}
	
	//search functionality
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement clickSearch;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search tickets, customers, ')]")
	private WebElement enterSearchValue;
	
	@FindBy(xpath = "//table//tr[td[1] and td[2]]/td[position()<=2]")
	private List<WebElement> tableRecords;

	public List<WebElement> getTableRecords() {
		return tableRecords;
	}

	public WebElement getClickSearch() {
		return clickSearch;
	}

	public WebElement getEnterSearchValue() {
		return enterSearchValue;
	}
	//notification 
	@FindBy(xpath = "//button[@aria-label='Notifications']")
	private WebElement notificationBtn;
	
	@FindBy(tagName = "h2")
	private WebElement notionSection;
	
	@FindBy(tagName = "li")
	private List<WebElement> notificationMessage;
	
	public WebElement getNotificationBtn() {
		return notificationBtn;
	}

	public WebElement getNotionSection() {
		return notionSection;
	}

	public List<WebElement> getNotificationMessage() {
		return notificationMessage;
	}

	//All Tickets Module
	//New Ticket Form
	@FindBy(xpath = "(//a[@data-discover='true'])[2]")
	private WebElement clickAllTicketsMenu;
	
	@FindBy(xpath = "//h1[text()='All Tickets']")
	private WebElement allTicketPage;
	
	@FindBy(xpath = "(//button[contains(@class,'flex items-center gap-2')])[2]")
	private WebElement clickNewTicketBtn;
	
	@FindBy(xpath = "//h2[text()='Create New Ticket']")
	private WebElement newTicketForm;
	
	@FindBy(tagName = "label")
	private List<WebElement> fieldNames;

	public List<WebElement> getFieldNames() {
		return fieldNames;
	}

	public WebElement getClickAllTicketsMenu() {
		return clickAllTicketsMenu;
	}

	public WebElement getAllTicketPage() {
		return allTicketPage;
	}

	public WebElement getClickNewTicketBtn() {
		return clickNewTicketBtn;
	}

	public WebElement getNewTicketForm() {
		return newTicketForm;
	}
	
	//Create New Form
	@FindBy(name = "leadId")
	private WebElement clickCustomerField;
	
	@FindBy(tagName = "input")
	private WebElement enterSubjectField;
	
	@FindBy(name = "description")
	private WebElement enterDescriptionField;
	
	@FindBy(name = "assignTo")
	private WebElement clickAssignee;
	
	@FindBy(name = "priority")
	private WebElement selectPriority;
	
	@FindBy(name = "category")
	private WebElement clickCategory;
	
	@FindBy(name = "status")
	private WebElement selectStatus;
	
	@FindBy(xpath = "//button[text()='Create Ticket']")
	private WebElement clickCreateTicket;
	
	@FindBy(xpath = "//table//tr[td[3]]/td[position()=3]")
	private List<WebElement> subjectColumn;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
	private WebElement newTicketPopUp;

	public WebElement getClickCustomerField() {
		return clickCustomerField;
	}

	public WebElement getEnterSubjectField() {
		return enterSubjectField;
	}

	public WebElement getEnterDescriptionField() {
		return enterDescriptionField;
	}

	public WebElement getClickAssignee() {
		return clickAssignee;
	}

	public WebElement getSelectPriority() {
		return selectPriority;
	}

	public WebElement getClickCategory() {
		return clickCategory;
	}

	public WebElement getSelectStatus() {
		return selectStatus;
	}

	public WebElement getClickCreateTicket() {
		return clickCreateTicket;
	}

	public List<WebElement> getSubjectColumn() {
		return subjectColumn;
	}

	public WebElement getNewTicketPopUp() {
		return newTicketPopUp;
	}
	
	@FindBy(xpath = "//p[text()='\"leadId\" is not allowed to be empty']")
	private WebElement emptyCustomerField;
	
	@FindBy(xpath = "//p[text()='\"title\" is not allowed to be empty']")
	private WebElement emptySubjectField;
	
	@FindBy(xpath = "//p[text()='\"description\" is not allowed to be empty']")
	private WebElement emptyDescribleField;
	
	@FindBy(xpath = "//p[text()='\"assignTo\" is not allowed to be empty']")
	private WebElement emptyAssigneeField;
	
	@FindBy(xpath = "//p[text()='\"category\" is not allowed to be empty']")
	private WebElement emptyCategoryField;
	
	@FindBy(xpath = "//p[text()='\"priority\" is not allowed to be empty']")
	private WebElement emptyPriorityField;
	
	@FindBy(xpath = "//p[text()='\"status\" is not allowed to be empty']")
	private WebElement emptyStatusField;
	
	public WebElement getEmptyCustomerField() {
		return emptyCustomerField;
	}

	public WebElement getEmptySubjectField() {
		return emptySubjectField;
	}

	public WebElement getEmptyDescribleField() {
		return emptyDescribleField;
	}

	public WebElement getEmptyAssigneeField() {
		return emptyAssigneeField;
	}

	public WebElement getEmptyCategoryField() {
		return emptyCategoryField;
	}

	public WebElement getEmptyPriorityField() {
		return emptyPriorityField;
	}

	public WebElement getEmptyStatusField() {
		return emptyStatusField;
	}

	//summaryCard
	@FindBy(tagName = "h2")
	private List<WebElement> summaryCardCount;
	
	@FindBy(xpath = "//select[@class='border px-2 py-1 rounded border-white/20 text-black']")
	private WebElement recordPerPage;
	
	@FindBy(xpath = "//select[@class='border px-2 py-1 rounded border-white/20 text-black']/option[@value='20']")
	private WebElement selectOption20;
	
	public WebElement getSelectOption20() {
		return selectOption20;
	}

	@FindBy(xpath = "//table/tbody/tr")
	private List<WebElement> tableRowCount;
	
	@FindBy(xpath = "(//div[@class='relative w-48']/button)[1]")
	private WebElement filter;
	
	@FindBy(xpath = "//div[@class='flex items-center gap-2 text-slate-500']/span")
	private List<WebElement> summaryCardHeading;
	
	@FindBy(xpath = "(//h2)[1]")
	private WebElement totalTicketCardCount;
	
	@FindBy(xpath = "(//div[@class='absolute z-50 mt-1 w-full rounded-lg border border-gray-200 bg-white shadow']/div)[2]")
	private WebElement statusFilterOpenOptions;
	
	@FindBy(xpath = "(//div[@class='absolute z-50 mt-1 w-full rounded-lg border border-gray-200 bg-white shadow']/div)[3]")
	private WebElement statusFilterInProgressOptions;
	
	@FindBy(xpath = "(//div[@class='absolute z-50 mt-1 w-full rounded-lg border border-gray-200 bg-white shadow']/div)[5]")
	private WebElement statusFilterResolvedOptions;

	public WebElement getStatusFilterResolvedOptions() {
		return statusFilterResolvedOptions;
	}

	public WebElement getStatusFilterInProgressOptions() {
		return statusFilterInProgressOptions;
	}

	public WebElement getStatusFilterOpenOptions() {
		return statusFilterOpenOptions;
	}

	public WebElement getTotalTicketCardCount() {
		return totalTicketCardCount;
	}

	public List<WebElement> getSummaryCardHeading() {
		return summaryCardHeading;
	}

	public List<WebElement> getSummaryCardCount() {
		return summaryCardCount;
	}

	public WebElement getRecordPerPage() {
		return recordPerPage;
	}

	public List<WebElement> getTableRowCount() {
		return tableRowCount;
	}

	public WebElement getFilter() {
		return filter;
	}
	
	//Assignee DropDown
	@FindBy(xpath = "(//select[@class='rounded-md border border-gray-300 px-2 py-1 text-sm text-black'])[1]")
	private WebElement selectAssignee;
	
	@FindBy(xpath = "(//select[@class='rounded-md border border-gray-300 px-2 py-1 text-sm text-black'])[1]/option")
	private List<WebElement> assigneeOptions;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
	private WebElement assigneePopUp;
	
	@FindBy(xpath = "(//select[@class='rounded-md border border-gray-300 px-2 py-1 text-sm text-black'])[1]/option[2]")
	private WebElement selectesOption;

	public WebElement getSelectesOption() {
		return selectesOption;
	}

	public WebElement getSelectAssignee() {
		return selectAssignee;
	}

	public List<WebElement> getAssigneeOptions() {
		return assigneeOptions;
	}

	public WebElement getAssigneePopUp() {
		return assigneePopUp;
	}
	
	//Edit Form
	@FindBy(xpath = "//table//tr[th]/th[9]")
	private WebElement actionColumn;
	
	@FindBy(xpath = "(//div[@class='flex gap-3']/button)[1]")
	private WebElement editBtn;
	
	@FindBy(name = "status")
	private WebElement clickEditFormStatus;
	
	@FindBy(name = "priority")
	private WebElement clickEditFormPriority;
	
	@FindBy(name = "category")
	private WebElement clickEditFormCategory;
	
	@FindBy(xpath = "//button[text()='SaveChanges']")
	private WebElement clickSaveChange;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
	private WebElement ticketFormPopup;
	
	@FindBy(xpath = "//table//tr[1][td]/td[4]")
	private WebElement formPriority;
	
	@FindBy(xpath = "//table//tr[1][td]/td[5]")
	private WebElement formStatus;
	
	@FindBy(xpath = "//h2[@class='text-xl font-semibold text-gray-900']")
	private WebElement ticketFormPage;
	
	@FindBy(xpath = "//select[@name='priority']/option]")
	private List<WebElement> priorityOptions;
	
	@FindBy(xpath = "//select[@name='priority']/option")
	private List<WebElement> selectEditFormStatus;
	
	@FindBy(xpath = "//h2[starts-with(normalize-space,'Edit')]/ancestor::div[.//select[@name='priority']][1]//select[@name='priority']")
	private WebElement clickEditFormPrioritys;
	

	public WebElement getClickEditFormPrioritys() {
		return clickEditFormPrioritys;
	}

	

	public List<WebElement> getPriorityOptions() {
		return priorityOptions;
	}

	public List<WebElement> getSelectEditFormStatus() {
		return selectEditFormStatus;
	}

	public WebElement getTicketFormPage() {
		return ticketFormPage;
	}

	public WebElement getActionColumn() {
		return actionColumn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getClickEditFormStatus() {
		return clickEditFormStatus;
	}

	public WebElement getClickEditFormPriority() {
		return clickEditFormPriority;
	}

	public WebElement getClickEditFormCategory() {
		return clickEditFormCategory;
	}

	public WebElement getClickSaveChange() {
		return clickSaveChange;
	}

	public WebElement getTicketFormPopup() {
		return ticketFormPopup;
	}

	public WebElement getFormPriority() {
		return formPriority;
	}

	public WebElement getFormStatus() {
		return formStatus;
	}
	
	//TicketQueuePage
	@FindBy(xpath = "//span[@class='flex items-center gap-3' and text()='Ticket Queues']")
	private WebElement clickTicketQueues;
	
	@FindBy(tagName = "h1")
	private WebElement ticketQueuesPage;

	public WebElement getClickTicketQueues() {
		return clickTicketQueues;
	}

	public WebElement getTicketQueuesPage() {
		return ticketQueuesPage;
	}
	
	//summaryCard
	@FindBy(xpath = "//span[@class='text-xs font-semibold tracking-wide truncate']")
	private List<WebElement> summaryCardQueue;
	
	@FindBy(xpath = "//h4[@class='text-gray-900 font-semibold pt-4 mx-4 ']")
	private WebElement queueTableHeading;

	public WebElement getQueueTableHeading() {
		return queueTableHeading;
	}

	public List<WebElement> getSummaryCardQueue() {
		return summaryCardQueue;
	}
	
	//AllTicket Sort
	@FindBy(tagName = "table")
	private WebElement table;
	
	@FindBy(xpath = "//table/thead/tr/th")
	private List<WebElement> tableColumn;
	
	@FindBy(xpath = "//table//tr[td[1]]//td[position()<=5]")
	private List<WebElement> tableDataAllTicket;
	
	@FindBy(xpath = "//table/thead/tr/th[1]")
	private WebElement TicketId;
	
	@FindBy(xpath = "//table/thead/tr/th[2]")
	private WebElement customer;
	
	@FindBy(xpath = "//table/thead/tr/th[3]")
	private WebElement subject;
	
	@FindBy(xpath = "//table/thead/tr/th[4]")
	private WebElement priority;
	
	@FindBy(xpath = "//table/thead/tr/th[5]")
	private WebElement status;

	public WebElement getTicketId() {
		return TicketId;
	}

	public WebElement getCustomer() {
		return customer;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getPriority() {
		return priority;
	}

	public WebElement getStatus() {
		return status;
	}

	public WebElement getTable() {
		return table;
	}

	public List<WebElement> getTableColumn() {
		return tableColumn;
	}

	public List<WebElement> getTableDataAllTicket() {
		return tableDataAllTicket;
	}
	
	//performance
	@FindBy(xpath = "//span[text()='Performance']")
	private WebElement clickPerformance;
	
	@FindBy(tagName = "h1")
	private WebElement performancePage;

	public WebElement getClickPerformance() {
		return clickPerformance;
	}

	public WebElement getPerformancePage() {
		return performancePage;
	}
	
	//ReportPage
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement clickReport;
	
	@FindBy(tagName = "h1")
	private WebElement reportPage;

	public WebElement getClickReport() {
		return clickReport;
	}

	public WebElement getReportPage() {
		return reportPage;
	}
	
	
	@FindBy(xpath = "//div[@class=\"flex shrink-0 items-center gap-2 sm:gap-3 px-8 px-4\"]/button")
	private WebElement clickReportPageSearch;
	
	@FindBy(tagName = "input")
	private WebElement enterSearchDataInReport;
	
	@FindBy(xpath = "//div[@class=\"flex items-center gap-2 text-slate-500\"]")
	private WebElement reportSummaryCard;

	public WebElement getClickReportPageSearch() {
		return clickReportPageSearch;
	}

	public WebElement getEnterSearchDataInReport() {
		return enterSearchDataInReport;
	}

	public WebElement getReportSummaryCard() {
		return reportSummaryCard;
	}
	
	//TemplatesPage
	@FindBy(xpath = "//span[text()='Templates']")
	private WebElement clickTemplatesMenu;
	
	@FindBy(tagName = "h1")
	private WebElement templatesPage;

	public WebElement getClickTemplatesMenu() {
		return clickTemplatesMenu;
	}

	public WebElement getTemplatesPage() {
		return templatesPage;
	}
	
	@FindBy(xpath = "//div[@class='flex shrink-0 items-center gap-2 sm:gap-3 px-8 px-4']/button")
	private WebElement clickTemplatesPageSearch;
	
	@FindBy(tagName = "input")
	private WebElement enterSearchDataInTemplates;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement searchDataInTemplatesTable;

	public WebElement getClickTemplatesPageSearch() {
		return clickTemplatesPageSearch;
	}

	public WebElement getEnterSearchDataInTemplates() {
		return enterSearchDataInTemplates;
	}

	public WebElement getSearchDataInTemplatesTable() {
		return searchDataInTemplatesTable;
	}
	
	//SettingsPage
	@FindBy(xpath = "//span[text()='Settings']")
	private WebElement clickSettingsMenu;
	
	public WebElement getClickSettingsMenu() {
		return clickSettingsMenu;
	}

	public WebElement getSettingsPage() {
		return settingsPage;
	}

	@FindBy(tagName = "h1")
	private WebElement settingsPage;
	
	@FindBy(name = "emailOnSlaBreach")
	private WebElement emailCheckBox;
	
	@FindBy(name = "notifyOnReassignment")
	private WebElement notificationCheckBox;
	
	@FindBy(name = "dailySummaryDigest")
	private WebElement dailyCheckBox;

	public WebElement getEmailCheckBox() {
		return emailCheckBox;
	}

	public WebElement getNotificationCheckBox() {
		return notificationCheckBox;
	}

	public WebElement getDailyCheckBox() {
		return dailyCheckBox;
	}
	
	//KnowledgeBase
	@FindBy(xpath = "//span[text()='Knowledge Base']")
	private WebElement clickKnowledgeMenu;
	
	@FindBy(tagName = "h1")
	private WebElement KnowledgePage;

	public WebElement getClickKnowledgeMenu() {
		return clickKnowledgeMenu;
	}

	public WebElement getKnowledgePage() {
		return KnowledgePage;
	}
	
	@FindBy(xpath = "//div[@class='flex shrink-0 items-center gap-2 sm:gap-3 px-8 px-4']/button")
	private WebElement clickKnowledgePageSearch;
	
	@FindBy(tagName = "input")
	private WebElement enterSearchDataInKnowledge;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement searchDataInKnowledgeTable;

	public WebElement getClickKnowledgePageSearch() {
		return clickKnowledgePageSearch;
	}

	public WebElement getEnterSearchDataInKnowledge() {
		return enterSearchDataInKnowledge;
	}

	public WebElement getSearchDataInKnowledgeTable() {
		return searchDataInKnowledgeTable;
	}
	
	//TeamPage
	@FindBy(xpath = "//span[text()='Team']")
	private WebElement clickTeamMenu;
	
	@FindBy(tagName = "h1")
	private WebElement TeamPage;

	public WebElement getClickTeamMenu() {
		return clickTeamMenu;
	}

	public WebElement getTeamPage() {
		return TeamPage;
	}
	
	//Logout
	@FindBy(xpath = "//p[text()='SUPPORT']")
	private WebElement clickSupport;
	
	@FindBy(xpath = "//h3[text()='Are You Logging Out?']")
	private WebElement logoutPopup;
	
	@FindBy(xpath = "//button[text()='Log Out']")
	private WebElement clickLogoutBtn;
	
	@FindBy(xpath = "//p[text()='Customer Relationship Management']")
	private WebElement loginPage;

	public WebElement getClickSupport() {
		return clickSupport;
	}

	public WebElement getLogoutPopup() {
		return logoutPopup;
	}

	public WebElement getClickLogoutBtn() {
		return clickLogoutBtn;
	}

	public WebElement getLoginPage() {
		return loginPage;
	}

}
