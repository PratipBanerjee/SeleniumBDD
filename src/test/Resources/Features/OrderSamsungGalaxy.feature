# new feature
# Tags: optional

Feature: Verify User is able to order Samsung Galaxy Phone using an automated Test

    Scenario: Order a Samsung Galaxy Phone
        Given Login as a User "Underwriter"
        And Select the Product "Samsung galaxy s6"
        And Add product to cart
        Then Place the Order
        Then Enter the Order Details and Confirm the Order
        And Logout from application