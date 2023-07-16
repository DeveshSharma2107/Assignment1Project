@ProdCategory @test
Feature: An E-commerce Project candere HomePage validation

	@ProdCategoryMain
  Scenario: validation of landing page main categories
    Given User opened the browser
    And User navigated to the home Application url
    When on LandingPage 12 main product categories are Displayed
    Then Following are the main product categories
      | Trending            |
      | Rings               |
      | Earrings            |
      | Pendants            |
      | Necklace            |
      | Bangles & Bracelets |
      | Mangalsutra         |
      | Chains              |
      | Solitaires          |
      | Other Jewellery     |
      | Gifts               |
      | Offers              |
