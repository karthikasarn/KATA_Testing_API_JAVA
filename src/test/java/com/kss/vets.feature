Feature: To validate the vet APIs

Scenario Outline: create a vet for each speciality
    When user wants to create a vet with '<jsondata>'
    Then validate the creation of vet

Examples: 
| jsondata | 
| { "firstName": "franklin", "id": 11, "lastName": "templeton", "specialties": [   { "id": 3, "name": "xray"   }]} |
| { "firstName": "frank", "id": 11, "lastName": "temple", "specialties": [   { "id": 3, "name": "xray"   }]} |