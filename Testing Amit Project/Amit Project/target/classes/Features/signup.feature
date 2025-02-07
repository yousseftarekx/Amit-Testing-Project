Feature: User Signup

  Scenario: User registers with valid credentials
    Given user navigates to sign up page
    When user enters username "newuser" and password "newpass123"
    And user clicks on sign up button
    Then user should see a success message

  Scenario: User tries to register with an already existing username
    Given user navigates to sign up page
    When user enters username "existingUser" and password "testpass123"
    And user clicks on sign up button
    Then error message "This user already exist." is displayed
