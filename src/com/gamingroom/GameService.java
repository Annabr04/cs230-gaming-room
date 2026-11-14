package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine.
 * Completed from the Project One Milestone starter.
 * 
 * Three updates applied:
 * 1. Full singleton pattern (private constructor + getInstance).
 * 2. Iterator pattern for unique name checks in addGame and getGame methods.
 * 3. Added nextTeamId / nextPlayerId management for the Entity hierarchy.
 * 
 * @author Megan Brackat (based on coce@snhu.edu starter)
 */
public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<Game>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;

    // Added for team and player unique identifiers
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;

    // Singleton instance
    private static GameService service = null;

    /**
     * Private constructor prevents external instantiation.
     * Part of the singleton pattern.
     */
    private GameService() {
    }

    /**
     * Returns the single instance of GameService.
     * Creates it if it does not yet exist.
     * 
     * @return the GameService instance
     */
    public static GameService getInstance() {
        if (service == null) {
            service = new GameService();
        }
        return service;
    }

    /**
     * Construct a new game instance.
     * Uses the iterator pattern to look for an existing game with the same name.
     * If found, returns the existing instance; otherwise creates a new one.
     * 
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing; // Found — return existing instance
            }
        }

        // Not found — make a new game instance and add to list of games
        game = new Game(nextGameId++, name);
        games.add(game);

        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * Scope is package/local for testing purposes.
     * 
     * @param index index position in the list to return
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     * Uses the iterator pattern.
     * 
     * @param id unique identifier of game to search for
     * @return requested game instance or null
     */
    public Game getGame(long id) {
        Game game = null;

        // Use iterator to look for existing game with same id
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existing = iterator.next();
            if (existing.getId() == id) {
                game = existing;
                break;
            }
        }
        return game;
    }

    /**
     * Returns the game instance with the specified name.
     * Uses the iterator pattern.
     * 
     * @param name unique name of game to search for
     * @return requested game instance or null
     */
    public Game getGame(String name) {
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                game = existing;
                break;
            }
        }
        return game;
    }

    /**
     * Returns the number of games currently active
     * 
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }

    /**
     * Returns the next available team identifier and increments the counter.
     * 
     * @return next team id
     */
    public long getNextTeamId() {
        return nextTeamId++;
    }

    /**
     * Returns the next available player identifier and increments the counter.
     * 
     * @return next player id
     */
    public long getNextPlayerId() {
        return nextPlayerId++;
    }
}
