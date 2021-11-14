Feature: Register as an Employer

  Scenario: Employer manages to register successfully
    Given The employer enters the application
    When Press the option to register by affiliating position in a company and a password
    Then You are notified by text message that the registration was successful

  Scenario: The employer is unable to register
    Given The employer enters the application
    When Press the option to register and it does not fill in the data properly
    Then The registration process is not carried out because you must enter valid data