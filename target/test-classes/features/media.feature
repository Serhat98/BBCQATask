@media
Feature: User should get the Media Data

Background:
  Given User get credentials
  When I make a get request to Media endpoint

  @positive @smoke
  Scenario:Verify HTTP status code and response time

    Then status code should be 200
    And response time should be less than 1000 milliseconds

  Scenario: Verify id and segment type
    Then Id field should never be null or empty
    And Segment type field is always music

  Scenario: Verify primary field
    Then primary field in title_list is never null or empty

    @smoke
  Scenario: Verify only one track playing
    Then only one track in the list is playing

  Scenario: Verify date value
    Then header should contain date value as Fri, 21 May



