Feature:
  As a user of movie website
  I want to check the movies
  in both home and popular sections

  Scenario: Checking all UI elements in home section
    Given I'm in the login page
    When I enter into my account with credentials
    And I click on the home section movie
    Then I check all UI elements in home section

  Scenario: Checking all UI elements in popular section
    Given I'm in the login page
    When I enter into my account with credentials
    And I click on the popular section movie
    Then I check all UI elements in popular section