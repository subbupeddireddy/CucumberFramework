Feature: Login page functinality



@smoke
Scenario Outline: Login with valid crdentials 
Given the user is on the Login page
When the <user> sigin with valid credentials
Then the user signin to application
And the Dashboard page is displayed

Examples:
|user|
|MANAGER|
|HEAD|
