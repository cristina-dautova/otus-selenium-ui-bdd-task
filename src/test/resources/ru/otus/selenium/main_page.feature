Feature: Main page

  @main_page
  Scenario: Open course by number
    Given I opened "chrome" browser
    Given I am on Main Page
    When I click course tile 1
    Then I should be taken to Course Page
    And I see correct course name

  @main_page
  Scenario: Open course by course name
    Given I opened "chrome" browser
    Given I am on Main Page
    When I click course tile containing "Java"
    Then I should be taken to Course Page
    And I see search word in course name

  @main_page
  Scenario: Open course by date
    Given I opened "chrome" browser
    Given I am on Main Page
    When I search courses starting from the date "5 марта"
    Then I see courses information in console
