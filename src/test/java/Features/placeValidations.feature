Feature: Validating place API's

  Scenario: Verify if Place is been successfully added using AddPlace API
    Given Add Place Paylod
    When user calls the "AddPlaceAPI" with post call
    Then the API call get success message with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

  Scenario Outline: Verify if Place is been successfully added using AddPlace API
    Given Add Place Paylod with "<name>" and "<language>" and "<address>"
    When user calls the "AddPlaceAPI" with post call
    Then the API call get success message with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Examples:
    |name|language|address|
    |testName|testLanguage|testAddress|
    |testName2|testLanguage2|testAddress2|
