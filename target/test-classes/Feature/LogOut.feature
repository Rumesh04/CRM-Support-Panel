Feature: User Logout Functionality

@logout
Scenario: Navigate to login page after clicking Log Out
Given the User is logged in to Support Dashboard 
And the user clicks the support profile
And the logout confirmation popup is displayed
When the user clicks the Log Out button 
Then the user should be logged out successfully
And the user should be redirected to the login page






