Feature: To validate the pet APIs

Scenario Outline: add a new pet
    When user wants to add a new pet with '<jsonFile>'
    Then validate the <statusCode> and pet details added

Examples: 
| jsonFile                            | statusCode |
| src/test/resources/add_pet_201.json |        200 |
