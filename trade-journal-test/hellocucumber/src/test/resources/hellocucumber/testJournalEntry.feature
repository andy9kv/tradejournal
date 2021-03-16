Feature: Test get all journal entries

  Scenario Outline: Make a request to the server and expect to get all entries
    Given there are <trade> trades logged
    When I request for trades to the get <endpoint>
    Then I should see all the trades

  Examples:
    |       endpoint         |     trade     |
    |    "/trade/journal"    |       1       |
