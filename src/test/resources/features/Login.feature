@Login
Feature: Login
  As a User I can log in with valid credential

  Scenario: Login with valid credential
    Given User open the web sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page

@TC2
  Scenario Outline: Login with invalid credential
    Given User open the web sauce demo
    When User input "<userName>" as userName and "<password>" as password and click login
    Then User see "<errorMessage>" as error text
    Examples:
      | userName      | password     | errorMessage                                                              |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      |               |              | Epic sadface: Username is required                                        |
      | lekJodi       | Paten        | Epic sadface: Username and password do not match any user in this service |

