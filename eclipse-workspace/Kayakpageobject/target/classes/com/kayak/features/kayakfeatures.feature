Feature: checking functionality of kayak website
  
Scenario Outline: Select flight from the list
    Given launching the browser with url
    When Enter "<origin>" and "<Destination>" cities
    And Select dates from calender
    And click on search button
   Then selecting flight from list
    And vaidating origin and destination "<cities>"
  Examples:
|origin        |Destination|cities|
|Hyderabad     |Bengaluru  |HYD - BLR|