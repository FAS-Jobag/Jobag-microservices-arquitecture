Feature: The employer purchases a monthly plan

  Scenario: The employer purchases the monthly plan
    Given the employer is interested in purchasing a monthly plan
    When You can find it in the “Subscriptions” section and select the option “Buy a plan” for a monthly plan
    Then the employer acquires the plan

  Scenario: The employer has a monthly plan and purchases a new monthly plan
    Given the employer has a monthly plan
    When You can find it in the "Subscriptions" section and select the "Boost plan" option for a monthly plan
    Then the employer acquires the new selected plan