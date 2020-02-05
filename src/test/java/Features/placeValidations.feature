Feature: Validating place API's

#  Scenario: Verify if Place is been successfully added using AddPlace API
#    Given Add Place Payload
#    When user calls the "AddPlaceAPI" with post call
#    Then the API call get success message with status code 200
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"
#
#  Scenario Outline: Verify if Place is been successfully added using AddPlace API with multiple data
#    Given Add Place Payload with "<name>" and "<language>" and "<address>"
#    When user calls the "AddPlaceAPI" with post call
#    Then the API call get success message with status code 200
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"
#    Examples:
#    |name|language|address|
#    |testName|testLanguage|testAddress|
#    |testName2|testLanguage2|testAddress2|
#
#  Scenario: Verify if Place is been successfully added using AddPlace API with different methods
#    Given Add Place Payload
#    When user calls the "AddPlaceAPI" with "post" call
#    Then the API call get success message with status code 200
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"

  Scenario Outline: Verify if Place is been successfully added with the help of get method
    Given Add Place Payload with "<name>" and "<language>" and "<address>"
    When user calls the "AddPlaceAPI" with "post" call
    Then the API call get success message with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place id  created with "<name>" by "GetPlaceAPI" call
    Examples:
      | name | language | address |
      |testName|testLanguage|testAddress|

  Scenario: Verify if Place is been successfully deleted using DeletePlaceAPI
    Given delete place payload
    When user calls the "DeletePlaceAPI" with "post" call
    Then the API call get success message with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

#    Test comment 1


