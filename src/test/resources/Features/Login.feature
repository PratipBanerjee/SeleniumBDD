# new feature
# Tags: optional
    
Feature: Verify User is able to Login using an automated Test
    
    Scenario: Verify User Is Able To Login
    Given Login as a User "<RowNumber>"
    Then Validate the presence of Login Successfull Message
    
    Examples:
    | RowNumber |
    | 1 |
