Feature:
  As a user of movie app
  I want to check the navbar elements
  and navigating to the corresponding
  movie section to get the movies

  Scenario: Checking HomePage logo is displayed or not
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can check the home page logo is displayed or not

  Scenario: Checking elements in the Navbar
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can check the navbar elements in header section

  Scenario: Navigating to the home element
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can navigate to home section

  Scenario: Navigating to the popular element
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can navigate to popular section

  Scenario: Navigating to the search element
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can navigate to search section

  Scenario: Navigating to the account element
    Given I am in the movie login page url
    When I enter my username and password
    And I click login button
    Then I can navigate to account section
