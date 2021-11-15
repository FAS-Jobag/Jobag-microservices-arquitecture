Feature: create interviews
  Scenario: the employer creates satisfactory interview
    Given the employer wants to create an interview
    When complete all data
    Then the interview is created

  Scenario: the employer does not enter the mandatory data
    Given the employer wants to create an interview
    When does not complete all data
    Then the interview not is created