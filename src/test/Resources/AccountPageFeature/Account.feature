Feature:
  As a user of movie
  website I want to check
  all the ui elements in
  the account page

  Scenario: Checking all the ui elements in account page
    Given I'm in the movie login page url
    When I login into my account with requirements
    And I press the login button
    Then I can be able to check all the ui elements

  Scenario: Logout Functionaity
    Given I'm in the movie login page url
    When I login into my account with requirements
    And I press the login button
    Then I can be go to account and logout successfully