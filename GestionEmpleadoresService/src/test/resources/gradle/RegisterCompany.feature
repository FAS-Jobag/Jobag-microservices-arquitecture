Feature: The employer creates the template of the company where he wants to recruit staff

  Scenario: Employer manages to specify company data
    Given The employer wants to enter the company data
    When Is at the time of company registration
    Then The employer can place in the fields, the information of the company

  Scenario: The employer can view the details of the company that they have completed in their profile
    Given The employer wants to see the data they have completed
    When Enter the company profile after registration
    Then The employer will be able to see the data of the company that has just entered