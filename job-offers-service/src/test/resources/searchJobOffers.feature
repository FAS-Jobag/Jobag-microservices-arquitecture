Feature: search job offers
  Scenario: the student can you see the job offers
    Given the postulant wishes to search for job offers
    When  searches for these job offers
    Then the list of jobs offers is shown

    Given the postulant wishes to search for job offers
    And no job offers available
    When  searches for these job offers
    Then the list of jobs offers is shown without elements