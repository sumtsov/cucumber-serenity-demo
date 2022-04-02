Feature: cash withdrawal

  Scenario: cash withdrawal
    Given the following accounts are available:
      | id | balance | ccy |
      | 1  | 1000.25 | USD |
      | 2  | 2000.15 | EUR |
    When 100.35 USD is withdrawn from account 1
    And 200.35 EUR is withdrawn from account 2
    Then account 1 balance should be 899.90 USD
    And account 2 balance should be 1799.80 EUR
