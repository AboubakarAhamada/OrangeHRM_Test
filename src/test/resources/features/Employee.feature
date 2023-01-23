@Employee
Feature: Scenarios related to Employee

  Background: Sign In
    Given User opens URL "https://opensource-demo.orangehrmlive.com"
    When User Enters username as "Admin" and Password as "admin123"
    And Click on Login

  @AddEmployee
  Scenario Outline: Add new Employee
    When User clicks PIM menu
    And clicks on Add Employee menu item
    Then User fills info of new Employee <firstname> <middlename> <lastname>
    And clicks on Save button
    Then User is added successfully

    Examples:
      | firstname | middlename | lastname |
      | "Aboubakar"   | "euzieuoz"     | "Ahamada"    |

  @SearchEmployee
  Scenario Outline: Search for a given employee
    When User clicks over PIM menu
    And Clicks on Employee List menu item
    When User looks for this employee <employeeName>
    And clicks on Search button
    Then it displays results

    Examples:
      | employeeName |
      | "Aboubakar"       |

  @DeleteEmployee
  Scenario Outline: Delete a given employee
    When User clicks over PIM menu
    And Clicks on Employee List menu item
    When User looks for this employee <employeeName>
    And clicks on Search button
    When User clicks on the checkbox
    And clicks on delete button
    Then confirmation pop up will appear
    When User confirms delete
    And record will be deleted

    Examples:
      | employeeName |
      | "Aboubakar" |