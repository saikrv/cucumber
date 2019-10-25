@acceptance
Feature: verify the accepted criteria for the given REST API.

  Scenario Outline: GET Reponse body values to be asserted
    When User submit the GET request as per the data in  Json/property file  "<Name>"
    And User should validate success status code  "<statuscode>"
    And User should validate response for boolean value "<Statement>"
    Then User should validate response body list values for  "<PromoName>" ,"<Description>"

    Examples: 
      | Name           | statuscode | Statement | PromoName | Description                                    |
      | Carbon credits |        200 | true      | Gallery   | 2x larger image in desktop site search results |
