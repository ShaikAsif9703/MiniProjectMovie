Feature: As a movie app user
  I want to check the names of
  the movies required and navigate
  to the necessary movie details

  Scenario: Checking Headings of each section
    Given I am in the movie page url
    When I gave credentials of username and password
    And I click on login button
    Then navigate to home page and check the headings of each section

  Scenario: Checking the play button is displayed or not
    Given I am in the movie page url
    When I gave credentials of username and password
    And I click on login button
    Then Navigated to the home page and check the play button

  Scenario: Checking the Trending Now movies are displayed or not
    Given I am in the movie page url
    When I gave credentials of username and password
    And I click on login button
    Then I check the trending now and Original movies and count

    Scenario: Checking the footer contact us section
      Given I am in the movie page url
      When I gave credentials of username and password
      And I click on login button
      Then I check icons of footer section and contact us