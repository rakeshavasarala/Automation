#@now
Feature: Login Feature 3

  Background:
    Given navigate to page https://endeavour-configuration-web-autonajenkins.endeavourdemo.com

  Scenario: Scenario 1
    Given login to config web
    And log out of config web


  Scenario: Scenario 2
    And login to config web as
      | userName | password |
      | admin    | admin    |
    And log out of config web


  Scenario Outline: Scenario 3
    And login to config web as
      | userName   | password   |
      | <userName> | <password> |
    And log out of config web
  Examples:
    | userName | password |
    | admin    | admin    |
    | admin    | admin    |



