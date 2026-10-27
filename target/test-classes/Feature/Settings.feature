Feature: CRM Support Settings Module

Background:
Given User should be logged in the CRM Support panel 
And User is Navigate to the dashbroad page

@navigateToSettingsPage
Scenario: Verify Navigate to Settings Page
When User clicks on Settings in the sidebar menu
Then User should be navigate to Settings page

@checkboxInSettings
Scenario Outline: Enable and Disable notification checkboxes
When User clicks on Settings module in the sidebar menu
And User the clicks the "<checkbox>" checkbox in notification preference section
Then the "<checkbox>" checkbox should be enabled
When User the clicks the "<checkbox>" checkbox
Then the "<checkbox>" checkbox should be disabled in notification preference section

Examples:
|  checkbox       |
|Email me on SLA breach   |
|Notify on ticket reassignment|
|Daily summary digest|






