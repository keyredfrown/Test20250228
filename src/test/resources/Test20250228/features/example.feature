Feature: As as form user
  I need to be able to submit all valid input

  Scenario Outline: The Test Input field should accept all valid input
    Given I am on the form
    When I enter "<validTextString>" in the Text Input field
    Then the text "<validTextString>" should display correctly in the Text Input field
    And The form can be submitted successfully

    Examples:
    |validTextString                    |
    |abcdefghijklmnopqrstuvwxyz         |
    |1234567890                         |
    |!£$%^&*()-=_+{}[]:;@'#`            |
    |ABCDEFGHIJKLMNOPQRSTUVWXYZ         |


  Scenario Outline: Should be able to select and submit all expected options
    Given I am on the form
    When I select "<option>" from the dropdown select control
    Then the text "<option>" should be the the visible selection in the dropdown select control
    And The form can be submitted successfully

    Examples:
    |option|
    |One   |
    |Two   |
    |Three |