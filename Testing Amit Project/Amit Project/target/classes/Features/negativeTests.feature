Feature: Negative Tests for User Signup and Login

  # Negative Scenario for Signup
  Scenario: User tries to register with an already existing username
    Given user go to sign up page
    And user enter username "existingUser" and password "password123"
    And user clicks on sign up button
    Then error message "This user already exist." is displayed

  Scenario: User tries to register with an invalid password (too short)
    Given user go to sign up page
    And user enter username "newuser" and password "123"
    And user clicks on sign up button
    Then error message "Password is too short." is displayed

  # Negative Scenario for Login
  Scenario: User tries to log in with incorrect username
    Given user go to login page
    And user enter login username "nonexistentUser" and password "password123"
    And user clicks on login button
    Then login error message "User not found" is displayed

  Scenario: User tries to log in with incorrect password
    Given user go to login page
    And user enter login username "existingUser" and password "wrongpassword"
    And user clicks on login button
    Then login error message "Incorrect username or password." is displayed
