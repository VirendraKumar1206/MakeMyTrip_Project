#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Hotel Booking on MakeMyTrip

  @tag1
  Scenario: Book a hotel
    Given Open browser
    And Enter url
    When Click on hotels
    And Click on location
    And Fetch dates
    And Click on apply button
    And Select price from dropdown
    And Click on search button
    Then Search result should be display
    And List of hotels should be display
    When Click on breakfast include checkbox
    And Click on ratings checkbox
    And Click on mountain view checkbox
    And Select Hotel Blanket Hotel & Spa Munnar
    And Click on Bookthisnow button
    And Add guest details
    And Click on paynow button
    Then Booking should be confirmed
