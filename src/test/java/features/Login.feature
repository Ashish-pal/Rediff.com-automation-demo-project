Feature: Application Login

Scenario: Login with valid credentials
Given Open Any Browser
And Navigate to Login Page
When User enters username as "yiroco@rediffmail.com" and password as "Password@123" into the fields
And User clicks on Login Button
Then Verify user is able to successfully login 