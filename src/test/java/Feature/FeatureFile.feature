Feature: CRM Support Panel

Scenario Outline: Login With Valid and Invalid Credentials
Given User is on the CRM Support Panel login page
When User enters Email "<Email>" in the Email field
And User enters password "<Password>" in the password field
And User Clicks on Log In button
Then User should be redirected to Support Dashbroad "<ExpectedResult>"

Examples:
|     Email             |      Password          |        ExpectedResult        |
|                       |     Gokul@123          |  Email cannot be empty       |
|gokulraj.kiaq@gmail.com|                        |  Password cannot be empty    |
|gokulraj.kiaq@gmail.com|     Gokul              |Password must be at least 6 characters long|
|gokulraj.kiaq@gmail.com|    gokul@1234          | Validation failed            |
|gokulraj.kiaqgmail.com |      Gokul@1234        | Enter a valid Email address  |
|raj.kiaq@gmail.com     |    Gokul@1234          | Something went wrong         |
|gokulraj.kiaq@gmail.com|      Gokul@1234        | Support Dashboard            |  




