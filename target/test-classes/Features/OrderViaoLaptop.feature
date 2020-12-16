# new feature
# Tags: optional
    
Feature: Verify User is able to order Sony vaio Laptop using an automated Test
    
Scenario: Order a Nokia Lumia Phone
    Given Login as a User "Broker"
    And Select the Product "Sony vaio i5"
    And Add product to cart
    Then Verify Product is added to Cart
    And Place the Order
    Then Enter the Order Details and Confirm the Order
    And Logout from application
