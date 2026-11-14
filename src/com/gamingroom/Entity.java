package com.gamingroom;

/**
 * Base class introduced to hold common attributes and behaviors
 * for Game, Team, and Player as shown in the domain model.
 * 
 * @author Megan Brackat
 */
public class Entity {
    private long id;
    private String name;

    /**
     * Constructs an Entity with identifier and name.
     * @param id unique identifier
     * @param name entity name
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}
