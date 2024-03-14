Feature: Login-page Feature
  this feature deal with all components of tutorial ninja application
  Scenario Outline: user should be able to login the application page with valid credentials
    Given Navigate to the homepage of tutorial ninja application
    When navigate to the login page
    Then enter Username as "<username>" and Password as "<password>"
    And click on login button
    Then user should be able to login based on My Account login status
    Examples:
    |username                  |password|
    |harika.selenium1@gmail.com|harika0803  |
    |suguru.harika78@gmail.com |harika8768  |
    |harika.sele098@gmail.com  |dhaya0987   |