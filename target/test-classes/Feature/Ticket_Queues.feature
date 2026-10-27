Feature: CRM Support Ticket Queues Module

Background:
Given User is logged into the CRM Support Panel
And User is on the Support Dashbroad page CRM panel 
When User clicks on Ticket QUeues in the side menu
Then User should be on the Ticket Queues page CRM panel

@queueCard
Scenario: Verify the Summary cards in the Ticket Queues page
Then the Summary cards "Unassigned Queue", "Technical Queue", "Billing Queue" and "Escalations Queue" should be displayed 

@queueCardClick
Scenario Outline: Click a summary card and verify its data in the table
When User clicks on the "<card>" summary card 
Then The table heading should display "<heading>"
And the Ticket table should display the queue records 

Examples:
|  card            |   heading           |         
| Technical Queue  | Technical Queue     |
| Billing Queue    | Billing Queue       |
| Escalations Queue| Escalations Queue   |
| Unassigned Queue | Unassigned Queue    |
















