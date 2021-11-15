Feature: Create ProfessionalProfile
  Scenario Outline: As I postulant i want create my professional profile
    Given I enter the profile platform
    And I create my proffesional profile with my <ocupation> and <experience>
    Then I want to see a successfully <message>
    Examples:
      | ocupation           | experience  | message                        |
      | "Fronted Developer" | "25"        | "Profile created succesfully" |
