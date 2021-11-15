Feature: Create Postulant
  Scenario Outline: As I user i want create my postulant profile
    Given I enter the registration platform
    And I create my postulant profile with my <email>
    Then I want to see a successfull <message>
    Examples:
      | email               | message                       |
      | "example@gmail.com" | "Account create successfully" |