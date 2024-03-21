@Purchase
  Feature: Purchase
    As a User I can purchase item from the inventory

  Scenario: Pick one item from inventory
    Given User open the web sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page
    When User sort product by "Price (high to low)"
    And User click button add to cart item "Sauce Labs Onesie"

  @Tugas
  Scenario: Purchase two item from inventory sorted low to high
    Given User open the web sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page
    When User sort product by "Price (low to high)"
    And User click button add to cart item "Sauce Labs Onesie"
    And User click button add to cart item "Sauce Labs Bike Light"
    And User click cart icon
    Then User redirected to cart page
    When User click button remove item "Sauce Labs Bike Light"
    And user click checkout button
    Then User redirected to checkout page
    When User input "Harry" as FirstName and "Potter" as LastName and "14211" as PostalCode and click continue
    Then User redirected to checkout payment page
    When User click finish button
    Then User redirected to checkout complete page and should see "Thank you for your order!"
