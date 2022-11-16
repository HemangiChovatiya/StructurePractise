Feature: As a user, I should be able to register so that I can use my account facility

  Scenario: I should be register successfully
    Given I am on register page
    When I enter required registration details
    Then I should be able to register successfully
