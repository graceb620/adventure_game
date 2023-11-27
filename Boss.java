/**
 * @author Grace Bero
 * Creates the boss type that inherits traits from character
 */

import java.util.Random; 

public class Boss extends Character implements CharacterInterface {
    protected int bloodlust;

    /**
     * Constructor for Boss Class
     * @param n, string for name
     */
    public Boss(String n) {
        super(n, 6);
        health = 200;
        bloodlust = 0;
    }

    /** 
     * Mutators for boss
     * @param b, int for bloodlust
     */
    public void setBloodlust(int b) {
        bloodlust = b;
    }

    /**
     * Boss bloodlust regen method
     */
    public void bloodlustRegen() {
        if (bloodlust < 5) {
            bloodlust += 1;
        }
    }

    /**
     * Stamina Regen for Boss method
     * Regen a random amount of stamina, stamina can't go over 6
     */
    public void staminaRegen() {
        if (stamina < 6) {
            int regenChance = new Random().nextInt(7-stamina);
            stamina += regenChance;
        }
    }

    /**
     * Boss gets attacked and loses health method
     */
    public void loseHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("You have defeated Vlad!");
        }
    }

    public void gainHealth(int damage) {
        health += damage;
    }


    /**
     * Boss Attack pattern
     * @param w, wizard to be attacked
     */
    public void attack() {
        if (bloodlust == 5) {
            damage = 50;
            bloodlust = 0;
            gainHealth(25);
            System.out.println("Vlad got consumed by bloodlust letting out a huge surge of power! You take 50 damage and he heals 25 health!");
        } else if (stamina >= 4) {
            stamina -= 4;
            damage = 20;
            System.out.println("Vlad used Blood Cyphon, dealing 20 dmg!");
        } else {
            stamina -= 2;
            damage = 10;
            System.out.println("Vlad used Bite, dealing 10 dmg!");
        }
    }

    /**
     * Vlad gets put to sleep method
     * If this happens, Vlad loses all bloodlust
     */
    public void goSleep() {
        bloodlust = 0;
        System.out.println("Vlad has been put to sleep, he can't attack!");
    }

    /**
     * ToString for boss
     * @return output, string with boss name, health, and bloodlust
     */
    public String toString() {
        String output = "";
        output += "Boss: " + name + "\n";
        output += "Health: " + health + "\n";
        output += "Bloodlust: " + bloodlust + "\n";
        return output;
    }

}

