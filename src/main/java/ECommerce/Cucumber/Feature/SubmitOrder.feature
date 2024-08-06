#Author: jananisivaraj1@gmail.com
@tag 
Feature: Placing order in ECommerce Application
  This file will execute test cases to check the direct case of placing order



  @tag1
  Scenario Outline: Submit Order
  	Given Lauch the required URL
    Given Log in to application using <EmailID> and <Password>
    And add the <ProductName> to the cart
    When cart page is loaded, verify the <ProductName> is present
    And go to checkout page and fill the details and continue
    Then Verify the order is placed and shows "THANKYOU FOR THE ORDER."
   



    Examples: 
      | EmailID  									| Password | ProductName  |
      | jananisivaraj1@gmail.com  | Zuzu@7155| ZARA COAT 3 |
