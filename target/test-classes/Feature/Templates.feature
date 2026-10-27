Feature: CRM Support Template Module

Background:
Given User should be logged into the CRM Support panel 
And User is Navigate to the Support dashbroad page

@navigateToTemplatesPage
Scenario: Verify Nagivate to Templates page
When User clicks on Templates in the sidebar menu
Then User should be navigate to Templates page

@searchInTemplatesPage
Scenario Outline: Search Summary card name Using Search Functionality
When User clicks on Templates Module in the sidebar menu
When User clicks Search icon on the top right section of the Templates page 
When User enters "<search>" in the search field in Templates page
Then The Templates Name section should display the relevant "<search>" Templates name in the table

Examples:
|     search      |
|  SLA Breach Apology  |
|  Password Reset Instructions |
|  Feature Request Received  |