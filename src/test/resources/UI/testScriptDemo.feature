@all
Feature: Checking ability add items to wishlist and filter products from wish list;

  Background:
    Given i am on product selection page

  Scenario: As an user I should be able to select items to wishlist then select low cost item to cart
    Given i add four different products to my wish list
    When i view my wishlist table
    Then i find total four selected items in my Wishlist
    When i search for lowest price product
    And i am able to add the lowest price item to my cart
    Then i am able to verify the item in my cart
