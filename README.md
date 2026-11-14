# CS 230 Project One - The Gaming Room Game Application

This repository contains the completed software design and Java prototype for The Gaming Room client, built from the Project One Milestone starter code.

## Three Updates Applied
1. **Singleton pattern fully implemented** in `GameService` (private constructor, static instance, and `getInstance()` method). This guarantees only one service instance exists in memory.
2. **Iterator pattern used** for unique-name checks in `addGame()`, `getGame(long)`, `getGame(String)`, `addTeam()`, and `addPlayer()`. Existing names return the existing instance instead of creating duplicates.
3. **Entity base class created** and `Game`, `Team`, and `Player` refactored to inherit from it. Added `nextTeamId` / `nextPlayerId` management so every entity receives a unique identifier.

## Structure
- `src/com/gamingroom/`
  - `Entity.java` – base class with id and name
  - `Game.java` – extends Entity; manages teams
  - `Team.java` – extends Entity; manages players
  - `Player.java` – extends Entity
  - `GameService.java` – singleton with iterator-based lookups
  - `ProgramDriver.java` – main test driver
  - `SingletonTester.java` – proves single GameService instance
- `CS 230 Project One Milestone UML.png` – original UML diagram

## How to Run
Import the project into Eclipse as “CS 230 Project One Game App” and run `ProgramDriver`, or compile the sources under `src` and run the class.

## Design Document
See the accompanying Software Design Document for the executive summary, design constraints, and domain-model description that references the provided UML.
