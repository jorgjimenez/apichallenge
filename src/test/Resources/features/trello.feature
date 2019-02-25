Feature: Basics Crud in board
  as a user in trello
  i want to access to information of board

  Scenario: Get list from a board
    Given The user wants to know the list that he has is a board
    When the user sends the petition for get the lists of his board
    Then the trello api should response only with the list of specific board

