Feature: CRM Support All Tickets - New Ticket Form

Background:
Given User is logged in to the CRM Support panel
And User is on the Support dashbroad page
When User clicks on All Ticket in the sidebar menu
Then User should be on the All Ticket page

@newTicketForm
Scenario: Open New Ticket Form
When User clicks on the New Ticket button 
And The New Ticket Form should be displayed 
Then The form contains Customer, Subject, Desciption, Status, Priority, category and assignee of seven fields

#@priorityOption
#Scenario: Verify the Priority Option in the New Ticket Form
#When User clicks on the New Ticket button 
#Then The Priority dropdown should contain "Critical", "High", "Medium", and "Low" option 

@createTicket
Scenario Outline: Create a new ticket with valid details
When User clicks on New Ticket button
And User selects "<customer>" from thw Customer dropdown in the form 
And User enters "<subject>" in the Subject field
And User enters "<description>" in the Description field
And User selects "<assignee>" from the Assignee dropdown in the form
And User selects "<priority>" from the Priority dropdown in the form
And User selects "<category>" from the Category dropdown in the form
And User selects "<status>" from the Status dropdown in the form
And User clicks on the Create Ticket button
Then Ticket created successfully message should be displayed
And The new ticket "<subject>" should be displayed in the ticket table

Examples:
|  customer    |  subject          |  description                  |  priority  |   category  |    status   |    assignee    |
|  Siva Kumar  |  Login issue      |  Unable to login to account   |  critical  |  complaint  |   open      |   gokul        |
|  Siva Kumar  |  Payment failed   |  Payment not processed        |  high      |  request    |   inprogress|    gokul       |
|  Siva Kumar  |  Profile update   |  Cannot update profile photo  |  medium    |  inquiry    |   resolved  |    gokul       |
|  Siva Kumar  |  Feedback         |  Suggestion for new feature   |  low       |  technical  |   closed    |    gokul       |

@mandatoryFields
Scenario Outline: Validate mandatory fields in the New Ticket form
When User clicks New Ticket button
And User selects "<customer>" in the Customer field 
And User enters "<subject>" in Subject field
And User enters "<description>" in Description field
And User selects "<assignee>" from the Assignee dropdown in form
And User selects "<priority>" from the Priority dropdown in form
And User selects "<category>" from the Category dropdown in form
And User selects "<status>" from the Status dropdown in form
And User clicks on Create Ticket button
Then The new ticket "<errorMessage>" should be displayed in ticket table

Examples:
|  customer     |  subject          |  description                  |  priority     |   category    |    status   |    assignee    |   errorMessage       |
|select Customer|  Feedback         |  Unable to login to account   |  critical     |  complaint    |   open      |   gokul        |leadId is not allowed to be empty|
|  Siva Kumar   |                   |  Payment not processed        |  high         |  request      |   inprogress|    gokul       |title is not allowed to be empty|
|  Siva Kumar   |  Profile update   |                               |  medium       |  inquiry      |   resolved  |    gokul       |description is not allowed to be empty|
|  Siva Kumar   |  Feedback         |  Suggestion for new feature   |Select Priority|  technical    |   closed    |    gokul       |priority is not allowed to be empty|
|  Siva Kumar   |  Feedback         |  Suggestion for new feature   |   medium      |Select Category|   closed    |    gokul       |category is not allowed to be empty|
|  Siva Kumar   |  Feedback         |  Suggestion for new feature   |   medium      |  technical    |Select Status|    gokul       |status is not allowed to be empty|
|  Siva Kumar   |  Feedback         |  Suggestion for new feature   |   medium      |  technical    |   closed    |Select assignee |assignTo is not allowed to be empty|

@summaryCardTotalTicket
Scenario: Verify Total Tickets count matches table records
When User observe the "Total Tickets" count displayed in the summary card 
And User scroll down to table section and select Records per page dropdown option "20"
Then the Total Tickets table record count should match the summary card count  

@summaryCardOpenTicket
Scenario: Verify the Open Tickets count matches table records
When User observe the "Open Tickets" count displayed in the summary card Open Ticket 
And User selects "<Open>" option in the Status filter dropdown 
Then the Open Tickets table record count should match the summary card count  

@summaryCardInProgress
Scenario: Verify the In Progress count matches table records
When User observe the "In Progress" count displayed in the summary card In Progress  
And User select "<In Progress>" option in the Status filter dropdown 
Then the In Progress table record count should match the summary card count 

@summaryCardClosedToday
Scenario: Verify the Closed Today count matches table records
When User observe the "Closed Today" count displayed in the summary card 
And User select "<Resolved>" Resolved in the Status filter dropdown 
Then the Resolved table record count should match the summary card count

@assigneeOptions
Scenario: Verify the Assignee dropdown options in the Ticket table
When User clicks on the Assignee dropdown of the first ticket in the table 
Then The Assignee dropdown should contain the support team member names 

@changeAssignee
Scenario Outline: Change the Assignee of a ticket from the table
When User select "<assignee>" from the Assignee dropdown of the first ticket in the table 
Then the Assignee column of the first ticket should display "<assignee>"

Examples:
|   assignee   |
|  Muthukumar  | 

@editTicket
Scenario: Open the edit from the Action column
When User clicks the Edit action for a ticket from the first row of the table 
Then the Edit Ticket form should be displayed 

@editTicketForm
Scenario Outline: In Edit Form Update Ticket Priority and Status
When User clicks the Edit action for ticket 
And User selects "<priority>" as the priority 
And User selects "<status>" as the status 
And User selects "<category>" as the category 
And User clicks the Save Change button 
Then The ticket should be updated successfully 
And the ticket table should display priority "<priority>" and status "<status>"

Examples:
|   priority    |    status    |  category  |
| high          |   open       | complaint  |
| low           |  inprogress  | complaint  |
| medium        |  resolved    | complaint  |


@tableSort
Scenario Outline: Verify Sort Functionality in Table
When The Records Table Section should be displayed
And User clicks on the "<column>" column header 
Then Table records  should be displalyed Ascending order of "<column>" column

Examples:
|  column    |
| TICKETID  |
| Customer   |
| Subject    |
| Priority   |
| Status     |


















