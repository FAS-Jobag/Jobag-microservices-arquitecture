Feature: Employer Authentication
  Scenario: Authenticate employer
    Given The employer wants to log in with his/her previous created account
    When The employer insert his/her authentication's information
    Then The application responds with the employer' primary information