package com.gamingroom;

/**
 * Application start-up program.
 * Completed from the Project One Milestone starter.
 * 
 * @author Megan Brackat (based on coce@snhu.edu starter)
 */
public class ProgramDriver {

    /**
     * The one-and-only main() method
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Obtain reference to the singleton instance
        GameService service = GameService.getInstance();

        System.out.println("\nAbout to test initializing game data...");

        // initialize with some game data
        Game game1 = service.addGame("Game #1");
        System.out.println(game1);
        Game game2 = service.addGame("Game #2");
        System.out.println(game2);

        // Demonstrate unique name enforcement
        Game game1Duplicate = service.addGame("Game #1");
        System.out.println("Duplicate Game #1 returned same instance: " + (game1 == game1Duplicate));

        // use another class to prove there is only one instance
        SingletonTester tester = new SingletonTester();
        tester.testSingleton();

        // Additional demonstration of teams and players
        Team teamA = game1.addTeam("Team Alpha");
        System.out.println(teamA);
        Player p1 = teamA.addPlayer("Player One");
        System.out.println(p1);
    }
}
