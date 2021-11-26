Feature: Postulant Authentication
  Scenario: Authenticate postulant
    Given The postulant wants to log in with his/her previous created account
    When The postulant insert his/her authentication's information
    Then The application responds with the Postulant' primary information