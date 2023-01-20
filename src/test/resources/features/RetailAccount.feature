Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'mohammad@tekschool.us' and password 'Tek@1234567'
    And User click on login button
    And User should be logged in into Account

  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'TestB' and Phone '2021012254'
    And User click on Update button
    Then User profile information should be updated

  Scenario: Verify user can update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Tek@123456       | Tek@1234567 | Tek@1234567     |
    And User click on Change Password button
    Then a messasge should be displayed 'Password Updated Successfully'

  Scenario: Verify User can add a payment method
    When User click on Account option
    * User click on Add a payment method link
    * User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 9876123456789123 | Ali        |              11 |           2024 |          123 |
    * User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'

  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User select card with ending '9123'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 9876123456787896 | Ali        |              10 |           2025 |          486 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated successfully'

  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User select card with ending '9123'
    And User click on remove option of card section
    Then payment details should be removed

  Scenario: Verify User can add an address
    When User click on Account option
    And User click on Add address option
    And User fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And User fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'
    
	
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
