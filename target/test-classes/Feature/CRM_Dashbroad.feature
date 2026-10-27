Feature: CRM Support Dashbroad

Background:
Given User is logged into the CRM Support panel
And User is on the Support Dashbroad page

@status
Scenario Outline: Filter Tickets by Status
When User selects "<status>" from the status dropdown
Then The Ticket table should display only tickets with "<status>" status 

Examples:
|    status    |
| Open         |
| In Progress  |
| Resolved     |
| Closed       |

@priority
Scenario Outline: Filter Tickets by Priorities
When User selects "<priority>" from the Priority dropdown
Then The Ticket table should display only tickets with "<priority>" priority 

Examples:
|    priority    |
| High         |
| Low          |
| Medium       |

@TimeRange
Scenario Outline: Filter Tickets by Time Range
When User selects "<timeRange>" from the Time Range dropdown
Then The Ticket table should display only tickets with "<timeRange>" time range 

Examples:
|   timeRange   |
| Today         |
| This Week     |
| This Month    |


@recordsPerPage
Scenario Outline: Verify Records Per Page Selection
When User selects "<records>" from the records per page dropdown 
Then The table should display maximum "<records>" records per page 

Examples:
|   records    |
|  Show 5          |
|  Show 10          |
|  Show 20          |
|  Show 50          |

@nextPage
Scenario: Navigate to next page using Next button
When User scroll down to Ticket table section
And User is on the first page "<Page 1>" of the ticket table 
And User clicks on the Next button 
Then User should be Navigated to the next page "<Page 2 of 3>" 
And The ticket table should display the records of the next page 

@previousPage
Scenario: Navigate to the Previous page using Previous button
When User scroll down to Ticket table section and user is on the second page of the ticket table 
And User clicks on the previous button 
Then User should be navigated to the previous page "<Page 1 of 2>"
And The ticket table should display the record of the previous page 

@search
Scenario Outline: Search Tickets Functionality Using Ticket ID or Customer Name
When User clicks Search icon on the top right section of the page 
When User enters "<searchValue>" in the search field 
Then The table should display the relevant "<searchValue>" ticket records 
And the displayed records should contain "<searchValue>" 

Examples:
|     searchValue      |
|  TICKET-0653         |
|  Muthukumar siva     |

@notification
Scenario: Open Notifications section
When User clicks on the notification button 
Then the notification section should be displayed 
And the notification message should be displayed 

@notification
Scenario: Close Notification section
Given the Notification section is displayed 
When User clicks on notification button
Then the Notification section should be closed 





















