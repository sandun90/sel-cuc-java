Feature: Login function

  @SampleTest
  Scenario: Access homepage
    Given I navigate to "https://www.saucedemo.com/"
    When Login using user name "standard_user" and password "secret_sauce"
    Then User should get successfully logged in

