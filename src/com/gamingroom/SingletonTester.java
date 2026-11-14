package com.gamingroom;

/**
 * A class to test a singleton's behavior.
 * Completed from the Project One Milestone starter.
 * 
 * @author Megan Brackat (based on coce@snhu.edu starter)
 */
public class SingletonTester {

    public void testSingleton() {

        System.out.println("\nAbout to test the singleton...");

        // Obtain local reference to the singleton instance
        GameService service = GameService.getInstance();

        // a simple for loop to print the games
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }

        System.out.println("Singleton test complete. Only one GameService instance is in use.");
    }
}
