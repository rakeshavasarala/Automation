Feature: Login Feature 3

  Scenario: Scenario 1
    Given navigate to page https://endeavour-configuration-web-autonajenkins.endeavourdemo.com
    Given login to config web

  @now
  Scenario: Scenario 2
  #Given navigate to page https://endeavour-configuration-web-autonajenkins.endeavourdemo.com
    And login to config web as
      | userName | password |
      | admin    | admin    |

    And read data table as rows
      | salutation | firstName | lastName | dob        |
      | Mr         | Rakesh    | A        | 01-01-2000 |

    And read data table as columns
      | salutation | Mr         |
      | firstName  | Rakesh     |
      | lastName   | A          |
      | dob        | 01-01-2000 |

    And read VALUE_CAPABLE_MU as enum

    When I load a table like
      | date1      | time1        | date2      |
      | 2014-06-17 | 17:30:00.000 | 2014-06-18 |

    And update the password settings
      | minimumLength                    | 8    |
      | numericCharactersRequired        | 1    |
      | uppercaseAlphaCharactersRequired | 1    |
      | lowercaseAlphaCharactersRequired | 1    |
      | specialCharactersRequired        | 1    |
      | passwordExpiryPeriod             | 45   |
      | passwordHistorySize              | 10   |
      | forcePasswordChangeOnFirstLogin  | true |

    And update the password settings
      | minimumLength                    | 8    |
      | numericCharactersRequired        | 1    |
      | uppercaseAlphaCharactersRequired | 1    |
      | lowercaseAlphaCharactersRequired | 1    |
      | specialCharactersRequired        | 1    |
      | passwordExpiryPeriod             | 45   |
      | passwordHistorySize              | 10   |
      | forcePasswordChangeOnFirstLogin  | TRUE |


    Given the users adam, bob, john

    Given the date is 2012-03-01T06:54:12

    Given the calendar date is 2012-03-01T06:54:12

