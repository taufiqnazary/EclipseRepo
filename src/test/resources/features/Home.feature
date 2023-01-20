Feature: Retail Home Page

  Background: 
    Given User is on retail website


  Scenario: Verify Retail Page logo
    Then User verify retail page logo is present

  
  Scenario: Verify User can search in Electronics Department
    When User change the category to 'Electronics'
    And User search for an item 'PlayStation'
    And User click on Search icon
    Then Item should be present

  
  Scenario: Verify User can click on All section
    When User click on All section
    Then User verifies 'Shop By department' is present

  
  Scenario: Verify Cart icon is present
    Then User verifies cart icon is present
