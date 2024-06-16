Feature: SauceDemo Test

  @master
  Scenario: Add Six Items To Cart
    Given the user is on the Product page
    When the user sorts the products
    And User clicks add to cart button
    Then the six products should be added to cart waiting checkout



