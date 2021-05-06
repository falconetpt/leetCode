Feature: Roman numeral

  Scenario Outline:
    Given a input <value>
    When i invoque conversion
    Then the result should be value <result>
    Examples:
      | value | result |
      | "i"     | 1      |
      | "ii"    | 2      |
      | "iii"   | 3      |
      | "iv"    | 4      |
      | "v"     | 5      |
      | "ix"     | 9      |
      | "xiv"     | 14      |
      | "xl"     | 40      |
      | "xcix"     | 99      |