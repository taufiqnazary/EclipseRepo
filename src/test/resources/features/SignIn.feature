Feature: Sign In Feature

  #this is comment
  Background: 
    Given User is on retail website
    When User click on Sign in option
	
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'mohammad@tekschool.us' and password 'Tek@12345'
    And User click on login button
    Then User should be logged in into Account

  @signInTest
  Scenario Outline: Verify user can login with different email and pass
    And User enter email <email> and password <password>
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                    | password    |
      | 'mohammad@tekschool.us'  | 'Tek@12345' |
      | 'mohammad1@tekschool.us' | 'Tek@12345' |
      | 'mohammad2@tekschool.us' | 'Tek@12345' |

  @signUpTest
  Scenario: Verify user can create an account into Retail website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name     | email                   | password  | confirmPassword |
      | panthers | panthersxy69@tekschool.us | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page

  
  Scenario Outline: Verify user can create an account into Retail website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name   | email   | password   | confirmPassword   |
      | <name> | <email> | <password> | <confirmPassword> |
    And User click on SignUp button
    Then User should be logged into account page

    Examples: 
      | name     | email                       | password  | confirmPassword |
      | panthers | panthers112@tekschool.us    | Tek@12345 | Tek@12345       |
      | panthers | panthersxy1123@tekschool.us | Tek@12345 | Tek@12345       |
      | panthers | panthersxy1144@tekschool.us | Tek@12345 | Tek@12345       |
      | panthers | panthersxy114@tekschool.us  | Tek@12345 | Tek@12345       |
