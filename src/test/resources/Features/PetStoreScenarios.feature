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
    
    
    Scenario Outline: Verify Customer is able to add and order a pet from Pet Store for 20 times.
    
                        ### Pre Requisites ###
        Given Customer will do this for number of pets "<NumberOfTimes>"
        
        Given Add a pet to Pet Store with Name as "testdoggo1"
        When Get the count of total available pets
        Then Order a Pet
        And Delete the Pet recently added
        Then Validate the total count of available pets is reduced

        Examples:
            | NumberOfTimes |
            | 1 |
            | 2 |
            | 3 |
            | 4 |
            | 5 |
            | 6 |
            | 7 |
            | 8 |
            | 9 |
            | 10 |
            | 11 |
            | 12 |
            | 13 |
            | 14 |
            | 15 |
            | 16 |
            | 17 |
            | 18 |
            | 19 |
            | 20 |