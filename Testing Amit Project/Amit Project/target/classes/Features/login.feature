Feature: User Login

  Scenario: User logs in with correct credentials
    Given user go to login page
    And user enter username "newuser" and password "newpass123"
    And user clicks on login button
    Then login error message "Invalid login credentials" is displayed

  Scenario: User logs in with incorrect credentials
    Given user go to login page
    And user enter username "nonexistent" and password "wrongpass"
    And user clicks on login button
    Then login error message "User not found" is displayed
