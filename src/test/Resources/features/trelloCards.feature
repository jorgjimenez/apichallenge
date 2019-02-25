Feature: management card
  as a user in trello
  i want to create, move and add coments in a card

  Scenario: create card
    Given The user want to create card in list TO DO
    When the user send request to create the card
    Then the card is created in the list TO DO

  Scenario: Add memberS
    Given the user has already created a card
    When the user add a member in the card
    Then the member has been added to the card

