Feature: Manage Denomination



@smoke
  Scenario: Add a new Denomination successfully
    Given the "SCRAMANAGER" is on the Denomination page
    When the user enters denomination value of 99
    And enters remarks as "Valid Denomination"
    And clicks the Submit button
    Then a success message "Denomination Added Successfully." should be displayed
@smoke
  Scenario: Add an existing Denomination
    Given the "MANAGER" is on the Denomination page
    When the user enters denomination value of 99
    And enters remarks as "Duplicate Test"
    And clicks the Submit button
    Then an error message "Denomination already exists." should be displayed

@smoke
  Scenario: Add an unApproved Denomination
    Given the "MANAGER" is on the Denomination page
    When the user enters denomination value of 80
    And enters remarks as "unApproved Test"
    And clicks the Submit button
    Then an error message "Request has already been raised for Denomination (80)" should be displayed

  Scenario: Approve a Denomination
    Given the "HEAD" is on the Denomination page
    When the user selects the pending denomination of 80
    And enters remarks as "Approved by Admin"
    And clicks the Approve button
    Then a success message should be displayed
@smokes
  Scenario Outline: Print Denomination list
    Given the "<USER>" is on the Denomination page
    When the user clicks on the Print button
    Then the Excel Download button should be displayed
    
    Examples:
    |USER|
    |MANAGER|
    |HEAD|
