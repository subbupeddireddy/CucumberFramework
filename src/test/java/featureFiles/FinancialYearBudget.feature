#@Author: Subbu

Feature:  Financial year budget Adding and Approving

 
@sanity
Scenario: Financial year Budget Adding
Given the "MANAGER" is on Financial Year Budget page
When the user adds the <18000> and submit
Then the success message is displayed
And the budget displayed in list view
 
 
 
 
  @sanity
Scenario: Financial year Budget Approve
Given the "HEAD" is on Financial Year Budget page
When the user submits the Financial year budget
Then the success message is displayed
 
  @smoke
Scenario Outline: Print and download the Financial Year Budget
  Given the "<user>" is on Financial Year Budget page
  When the user clicks on the Financial Year Budget print button
  Then the Excel file should be downloaded successfully
Examples:
|user|
|MANAGER|
|HEAD|




