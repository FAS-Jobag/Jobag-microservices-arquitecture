Feature: List scheduled interviews
  Scenario: the job offer has scheduled interviews
    Given the employer wants to see the interviews of a job offer
    When verify the interviews associated to job offer
    Then the list of interviews is displayed


  Scenario: the job offer does not have scheduled interviews
    Given the employer wants to see the interviews of a job offer
    And the job offer does not have interviews
    When verify the interviews associated to job offer
    Then the list of interviews is displayed with zero items
