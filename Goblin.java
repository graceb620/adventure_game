/** 
 * @author Grace Bero 
 * Creates the Goblin type that inherits traits from character
 */
import java.util.Random;

public class Goblin extends Character{
    protected int stamina;
    protected int damage;

    /**
     * Constructor for Goblin Class
     * @param n, string for name of character
     */
    public Goblin(String n) {
        super(n);
        health = 100;
        stamina = 6;
        damage = 0;
    }

    /**
     * Mutators for goblin
     * @param h, int for health
     * @param s, int for stamina
     */
    public void setHealth(int h) {
        health = h;
    }
    public void setStamina(int s) {
        stamina = s;
    }

    /**
     * Accessors for goblin
     * @return health, int for health
     * @return stamina, int for stamina
     * @return damage, int for damage
     */ 
    public int getHealth() {
        return health;
    }
    public int getStamina() {
        return stamina;
    }
    public int getDamage() {
        return damage;
    }

    /**
     * Goblin attack pattern method
     * 
     * @param w, wizard to be attacked
    */
    public void attack(Wizard w) {
        
        if (stamina >= 4) {
            damage = 20;
            stamina -= 4;
            System.out.println("The goblin used stab, dealing 20 dmg!");
        }
        else if (stamina >= 2) {
            damage = 10;
            stamina -= 2;
            System.out.println("The goblin used scratch, dealing 10 dmg!");
        }
        else {
            System.out.println("The goblin is too tired to attack!");
        }
    }
    
    /**
     * Stamina Regen for goblin method
     * Regen a random amount of stamina, stamina can't go over 6
     */
    public void staminaRegen() {
        if (stamina < 6) {
            int regenChance = new Random().nextInt(7-stamina);
            stamina += regenChance;
        }
    }

    /**
     * Goblin gets attacked and loses health method
     * 
     * @param damage, int for damage taken
     */
    public void loseHealth(int damage) {
        health -= damage;
    }

    /**
     * Goblin toString method
     * 
     * @return goblinString, string with goblin name and health
     */
    public String toString() {
        String goblinString = "";
        goblinString += "Goblin: " + name + "\n";
        goblinString += "Current health: " + health + "\n";
        return goblinString;
    }
}
