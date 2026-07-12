Feature: Log in feature for WEB UI

  Scenario: User log in using registered account
    Given User on the homepage
    When User click on menu "Log in"
    And User fill out the correct username "nikenriri"
    And User fill out the correct password "150500Niken"
    And User click on login button
    Then Page shows the user name