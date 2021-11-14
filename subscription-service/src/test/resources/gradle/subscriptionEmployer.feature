Feature: Crud subscription employer

  Scenario: Create a new subscription to employers
    Given the administrator set the data of a new subscription
    When run de function to create new subscription to employer
    Then the administrator get a data of a new subscription to emloyer

  Scenario: Update an existend subscription to employers 
    Given the administrator set the data of an existend subscription and the id
    When run the function to update an existend subscription employer
    Then the administrator get data of a existend subscription to employer updated

  Scenario: Delete an existend subscriptrion to employers
    Given the administrator set the id of an existend subscription
    When run the function to delete an existend subscription to employers
    And run the function to search an existend subscripto to employers by the id of deleted subscription to employer
    Then the administrator get a not found subscription to employer
