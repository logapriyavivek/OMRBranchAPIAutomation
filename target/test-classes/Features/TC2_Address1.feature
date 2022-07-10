@Address
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for Add new Address "<first_name>", "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>" and "<address_type>"
    When User send "POST" request for add new address
    Then User verify the status code is 200
    And User verify the Create address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name     | mobile     | apartment | state | city | country | zipcode | address     | address_type |
      | Logapriya  | Vivekanandhan | 9952073232 | apartment |    33 | 3378 |     101 |  202020 | Kodambakkam | home         |

  Scenario Outline: Verify the existing address is updated to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body to update existing address "<first_name>", "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>" and "<address_type>"
    When User send "PUT" request to update the exsiting address
    Then User verify the status code is 200
    And User verify the Update address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name     | mobile     | apartment | state | city | country | zipcode | address     | address_type |
      | Logapriya  | Vivekanandhan | 9952073232 | apartment |    33 | 3378 |     101 |  202020 | Kodambakkam | home         |

  Scenario: Verify to Get address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "GET" request to get the existing address
    Then User verify the status code is 200
    And User verify the Get address response message matches "OK"

  Scenario: Verify to Delete address to the application through api
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "DELETE" request to delete the address
    Then User verify the status code is 200
    And User verify the Delete address response message matches "Address deleted successfully"
