Feature: CRM Support Report Module

  Background:
    Given User should logged into the CRM Support panel
    And User is Navigate to Support dashbroad page

  @navigateToReportPage
  Scenario: Verify Nagivate to Report page
    When User clicks on Report in the sidebar menu
    Then User should be navigate to Report page

  @searchInReportPage
  Scenario Outline: Search Summary card name Using Search Functionality
    When User clicks on Report Module in the sidebar menu
    When User clicks Search icon on the top right section of the Report page
    When User enters "<search>" in the search field in Report page
    Then The Summard card should display the relevant "<search>" summary card

    Examples:
      | search             |
      | Weekly Summary     |
      | Monthly SLA Report |
      | Agent Scorecards   |
