package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game.
 * Refactored to inherit from Entity.
 * 
 * @author Megan Brackat (based on coce@snhu.edu starter)
 */
public class Game extends Entity {
    // Teams belonging to this game (instance list, not static)
    private List<Team> teams = new ArrayList<>();

    /**
     * Constructor with an identifier and name.
     * Calls the Entity parent constructor.
     */
    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a team if the name is unique within this game.
     * Uses the iterator pattern to search existing teams.
     * 
     * @param name the unique name of the team
     * @return the existing or newly created Team
     */
    public Team addTeam(String name) {
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            Team existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing; // Name already in use
            }
        }
        // Unique name — create with next team ID from the service
        Team team = new Team(GameService.getInstance().getNextTeamId(), name);
        teams.add(team);
        return team;
    }

    @Override
    public String toString() {
        return "Game [id=" + getId() + ", name=" + getName() + "]";
    }
}
