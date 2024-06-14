Feature:
  As a user of movie web
  application I want to search
  certain movies and check whether
  the movies are displayed or not
  in the search results

  Scenario: Checking the display of movies of search results
    Given I am in the application login page
    When I enter into my account
    And I click search and enter a movie name
    Then I can get the list of entered movie results

  Scenario: Checking the non-display of movies of search results
    Given I am in the application login page
    When I enter into my account
    And I click search and enter a movie
    Then I can get the error message of entered movie results