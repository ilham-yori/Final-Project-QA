Feature: Cart and Checkout Feature

  Background: User already logged in to the account
    Given User sucessfully login to the account

  Scenario: Add the item to the cart and make the order
    When User choose the category of the product "Laptops"
    And User click on the item "MacBook air"
    And User click on the button "Add to cart"
    Then System shows the notification "Product added."
    When User move to page "Cart"
    And User click on the button "Place Order"
    And User complete the order information
    And User confirm the order "Purchase"
    Then System shows the order summary and message "Thank you for your purchase!"