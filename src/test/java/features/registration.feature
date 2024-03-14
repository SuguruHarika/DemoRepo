Feature: Register for an account in tutorial ninja application
  Scenario: Registering to the ninja application
    Given i navigate to register application
    When i enter below details for filling the fields
      |firstname|suguru                    |
      |lastname |harika                    |
      |email    |suguruselenium5897@gmail.com|
      |telephone|984y665366                |
      |password |harika987                 |
    Then i click on the agree button
    Then i click on the continue button
    And i registered successfully and able to see Your Account Has Been Created!