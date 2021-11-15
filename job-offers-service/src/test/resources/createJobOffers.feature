Feature: Create Job Offers
  Scenario: the employer publishes his job offer
    Given the employer wants to publish a job offer
    When publishes his job offer
    Then the job offer is associated with the employer

  Scenario: the employer sees all job offer that created
    Given the employer created a job offer
    When consults the job offers that he has created
    Then his list of job offers is displayed