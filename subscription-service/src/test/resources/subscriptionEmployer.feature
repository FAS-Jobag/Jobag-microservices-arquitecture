Feature: Crud subscription employer

  Scenario: Create a new subscription to employers
    Given the administrator set the data of a new subscription
    When run de function to create new subscription to employer
    Then the administrator get a data of a new subscription to employer

  Scenario: Update an existent subscription to employers 
    Given the administrator set the data of an existent subscription and the id
    When run the function to update an existent subscription employer
    Then the administrator get data of a existent subscription to employer updated

  Scenario: Delete an existent subscriptrion to employers
    Given the administrator set the id of an existent subscription
    When run the function to delete an existent subscription to employers
    And run the function to search an existent subscription to employers by the id of deleted subscription to employer
    Then the administrator get a not found subscription to employer

  Scenario: Search all existent subscription to employers
    When the administrator run the function to search all existent subscription to employers
    Then the administrator get the list of existents subscriptions to employers
