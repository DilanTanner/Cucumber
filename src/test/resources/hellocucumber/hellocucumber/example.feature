@tag
Feature: Testing Selenium and Cucumber Setup
  You will use this to test out various scenarios and features of Selenium

  @tag1
  Scenario: Opens CranberryEagle website and subscribes with dummy data.
    Given Open Chrome and navigate to a site
    When Enter the email address and first name
    Then Scrolls down the page and clicks on the link at the bottom
