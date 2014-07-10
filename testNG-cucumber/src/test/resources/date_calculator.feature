Feature: Feature 1

  @pass
  Scenario: Scenario 1
    Given today is 2011-01-20
    When I ask if Jan 19, 2011 is in the past
    Then the result should be yes

  @fail
  Scenario: Scenario 2
    Given today is 2011-01-20
    When I ask if Jan 21, 2011 is in the past
    Then the result should be no