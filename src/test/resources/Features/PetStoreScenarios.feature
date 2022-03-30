# new feature
# Tags: optional
    
Feature: As an automation tester, I want to validate the add,delete, count available pets functionality of the Pet Store, using an automated script
    
    
    Scenario: Verify Customer is able to add and delete a pet from Pet Store
    
        Given Add a pet to Pet Store with Name as "testdoggo1"
        When Delete the Pet recently added
        Then Validate the Pet got deleted
    
    
    Scenario: Verify Customer is able to add and delete a pet from Pet Store
    
        Given Add a pet to Pet Store with Name as "testdoggo1"
        When Get the count of total available pets
        And Delete the Pet recently added
        Then Validate the total count of available pets is reduced