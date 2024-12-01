Feature: The Register flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page buttons
    And The register form is populated with data
    And The privacy toggle bar is enabled
    When The continueButton is clicked
    Then The URL contains the following keyword "success"


    @run
    Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
      Given The Home Page is displayed
      And Register Page is accessed from the Home Page buttons
      And The register form is populated with data
      #And The privacy toggle bar is enabled
      When The continueButton is clicked
      Then The URL contains the following keyword "register"
