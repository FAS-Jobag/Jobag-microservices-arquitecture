Feature: Access video call for the interview
  Scenario: the postulant can see a video call available
    Given the postulant wants see the interviews of a job offer
    When searches the interviews associated to job offer
    Then the list of interviews is shown

  Scenario: the postulant cannot see a video call available
    Given the postulant wants see the interviews of a job offer
    And the job offer does not have interviews
    When searches the interviews associated to job offer
    Then the list of interviews is shown without elements
