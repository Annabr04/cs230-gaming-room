package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team.
 * Refactored to inherit from Entity.
 * 
 * @author Megan Brackat (based on coce@snhu.edu starter)
 */
public class Team extends Entity {
    // Players belonging to this team
    private List<Player> players = new ArrayList<>();

    /**
     * Constructor with an identifier and name.
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a player if the name is unique within this team.
     * Uses the iterator pattern to search existing players.
     * 
     * @param name the unique name of the player
     * @return the existing or newly created Player
     */
    public Player addPlayer(String name) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing; // Name already in use
            }
        }
        // Unique name — create with next player ID from the service
        Player player = new Player(GameService.getInstance().getNextPlayerId(), name);
        players.add(player);
        return player;
    }

    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + "]";
    }
}
