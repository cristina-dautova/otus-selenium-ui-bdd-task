Feature: Online page

  @online_page
  Scenario: Show course info by price
    Given I opened "firefox" browser
    Given I am on Online Page
    Then I see course with "minimum" price value