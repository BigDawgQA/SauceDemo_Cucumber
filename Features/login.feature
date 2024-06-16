Feature: SauceDemo Login Test

  @sanity @master
  Scenario: Successful Login
    Given the user is on SauceDemo login page
    When the user enters valid username: "standard_user" and password: "secret_sauce"
    And User clicks login button
    Then the user should see the product page


  @master
  Scenario Outline: Login Data Driven Test
    Given the user is on SauceDemo login page
    When the user enters valid username: "<username>">  and password: "<password>">
    And User clicks login button
    Then the user should see the product page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | visual_user             | secret_sauce |




