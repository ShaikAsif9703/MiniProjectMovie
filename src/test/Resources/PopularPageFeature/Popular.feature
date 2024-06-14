Feature:
  As a user of movie app
  I want to login into my
  account and check whether the
  movies are displayed or not

  Scenario: Checking whether the movies are displayed or not
    Given I am in the movie application login page
    When I enter the credentials of my account
    And I login by clicking the login button
    Then I can check the movies are displayed or not