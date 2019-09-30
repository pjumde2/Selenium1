Feature: Facebooklogin
Scenario Outline: Verify Facebook Login
Given I open facebook website
When I enter valid "<uname>" and valid "<pass>"
And I click on TestLogin button
Then I see facebook page

Examples:
   | uname | pass |
   | test | test |
   