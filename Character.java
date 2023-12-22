/**
 * @author Grace Bero 
 * Creates a character class to be inherited from 
 */

public class Character {
    protected String name;
    protected int health;

    /**
     * Constructor for Character Class
     * @param n, string for name of character
     * @param a, int for armor of character
     */
    public Character(String n) {
        name = n;
        health = 100;
    }

    /**
     * Mutators for name, health, and lives
     * 
     * @param n, string for name of character
     * @param h, int for health of character
     */
    public void setName(String n) {
        name = n;
    }

    public void setHealth(int h) {
        health = h;
    }


    /**
     * Public Accessors for name, health, and lives
     * 
     * @return name, string for name of character
     * @return health, int for health of character
     */
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    
    /**
     * toString method for Character class
     * @return characterString, string with character name and health
     */
    public String toString() {
        String characterString = "";
        characterString += "Character name: " + name + "\n";
        characterString += "Current health: " + health + "\n";
        return characterString;
    }

}