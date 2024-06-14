Feature: Login Functionality
  As a user of movie website
  I want to login into my account
  with proper and improper credentials
  to check whether it is correctly
  working or not

  Scenario: Checking the website logo is displayed or not
    Given I am in the login page url
    Then I check whether the logo is diaplayed or not

  Scenario: Checking heading text is LOGIN
    Given I am in the login page url
    Then I check the heading text is Login

  Scenario: Checking the username label is USERNAME
    Given I am in the login page url
    Then I can check the username label is USERNAME

  Scenario: Checking the password label is PASSWORD
    Given I am in the login page url
    Then I can check the password label is PASSWORD

  Scenario: click on login button without credentials
    Given I am in the login page url
    When I click on the login button
    Then Error login message will be displayed

  Scenario: Login Functionality without credentials
    Given I am in the login page url
    When I click on the login button
    Then Error login message will be displayed

  Scenario: Login Functionality without providing username credential
    Given I am in the login page url
    When I gave only password without username
    And I click on the login button
    Then Error message will be displayed about credential

  Scenario: Login Functionality without providing password credential
    Given I am in the login page url
    When I gave only username without password
    And I click on the login button
    Then Error message will be displayed about credential

  Scenario: Login Functionality with Invalid credentials
    Given I am in the login page url
    When I gave the wrong credentials
    And I click on the login button
    Then Error message will be displayed about wrong credential

  Scenario: Login Functionality with valid credentials
    Given I am in the login page url
    When I gave the correct credentials
    And I click on the login button
    Then navigate to home page
