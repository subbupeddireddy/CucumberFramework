Feature: Stock Dispatch through STO and SALES



Scenario Outline: Raise a new <orderType> order through API and verify in web
  Given the user uses <orderType> API
  When the user sends a POST request
  Then a success response should be displayed
  And the <orderType> order should be displayed in the web application

Examples:
  | orderType |
  | STO       |
  | SALES     |
  
  

Scenario: Raise a new STO order through API and verify in web
  Given the user uses STO API
  When the user sends a POST request
  Then a success response should be displayed
  And the STO order should be displayed in the web application

Scenario: Cancel STO Order
  Given the user is on the STO order page
  When the user clicks on "New" and cancels the order "123456"
  Then the status is updated to "Cancel"
 @smoke 
Scenario: Add Transport Details
  Given the user is on the STO order page
  When the user clicks on "New" to add transport details
  And the user submits the vehicle information
  Then the vehicle details are displayed
  And the status is updated to "Generate Pick List"

Scenario: Generate Pick List of an Order
  Given the user is on the STO order page
  When the user clicks on "Generate Pick List", enters quantity and submits
  Then the status is updated to "Ready to scan"
