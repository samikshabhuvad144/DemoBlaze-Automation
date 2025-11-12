Feature: End to End Automation of DemoBlaze Website

  Scenario: Automate all functionalities of DemoBlaze
    Given User launches the DemoBlaze website
    When User logs into the website
    Then User adds products from all categories to the cart
    And User deletes one product and places the order
    And User fills order details and purchases
    Then User opens contact form and sends a message
    And User plays and closes the About Us video
    Then User navigates through the carousel and logs out
    And User closes the browser
