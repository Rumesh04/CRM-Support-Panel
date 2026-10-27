Feature: CRM Support Performance Module

Background:
Given User is logged in to the CRM Support panel Application
And User should Navigate to Support dashbroad page

@navigateToPerformancePage
Scenario: Verify Nagivate to performance page
When User clicks on Performance in the sidebar menu
Then User should be navigate to Performance page




