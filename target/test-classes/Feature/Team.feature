Feature: CRM Support Team Module

Background:
Given User is logged in to CRM Support panel Application
And User is Navigate to the dashbroad page CRM Panel 

@navigateToTeamPage
Scenario: Verify Navigate to Team Page
When User clicks on Team in the sidebar menu
Then User should be navigate to Team page




