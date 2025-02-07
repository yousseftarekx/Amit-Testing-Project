Scenario: Add a laptop to cart and purchase
  Given user navigates to shop page
  And user selects the laptops category
  And user selects product "MacBook Pro"
  And user adds the product to cart
  And user navigates to cart
  Then product "MacBook Pro" should be visible in the cart
  And user verifies product "MacBook Pro" price is "2000"
  And user verifies total amount is "2000"
  And user clicks the place order button
  And user fills checkout form with name "John", country "USA", city "NY", credit card "123456789", month "12", and year "2025"
  And user clicks purchase button
  Then the purchase should be successful
