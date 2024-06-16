Feature: SauceDemo Login Test

  @sanity @master
  Scenario: CheckOut
    Given the products are added to cart
    And user is on Your cart page
    When the user clicks checkout
    And User input checkout details below
      | firstname | 1234 |
      | lastname  | 1234 |
      | postcode  | 1234 |
    Then user clicks finish button and user is checkout is complete



