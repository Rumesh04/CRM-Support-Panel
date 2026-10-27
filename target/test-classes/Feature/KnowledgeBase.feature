Feature: CRM Support Knowledge Base Module

Background:
Given User should be logged in to CRM Support panel 
And User is Navigate to the dashbroad page of the CRM Panel

@navigateToKnowledgePage
Scenario: Verify Navigate to Knowledge Base Page
When User clicks on Knowledge Base in the sidebar menu
Then User should be navigate to Knowledge Base page

@searchInKnowledgePage
Scenario Outline: Search Article name Using Search Functionality
When User clicks on Knowledge Base Module in the sidebar menu
When User clicks Search icon on the top right section of the Knowledge Base page 
When User enters "<search>" in the search field in Knowledge Base page
Then The Article table section should display the relevant "<search>" Knowledge Base Article name in the table

Examples:
|     search      |
|  Resolving API authentication timeouts  |
|  How to process a billing refund |
|  Setting up SSO for sub-organizations  |




