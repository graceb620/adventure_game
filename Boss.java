/**
 * @author Grace Bero
 * Creates the boss type that inherits traits from character
 */

import java.util.Random;


public class Boss extends Wizard {
    protected int stamina;
    protected int damage;
    protected int bloodlust;
    

    /**
     * Constructor for Boss Class
     * @param n, string for name of character
     */
    public Boss(String n) {
        super(n);
        health = 200;
        stamina = 6;
        mana = 100;
        bloodlust = 0;
    }

    /**
     * Mutators for boss
     * @param h, int for health
     * @param s, int for stamina
     * @param m, int for mana
     * @param b, int for bloodlust
     */
    public void setHealth(int h) {
        health = h;
    }
    public void setStamina(int s) {
        stamina = s;
    }
    public void setMana(int m) {
        mana = m;
    }
    public void setBloodlust(int b) {
        bloodlust = b;
    }

   
    /**
     * Accessors for boss
     * @return health, stamina, mana, bloodlust
     */
    public int getHealth() {
        return health;
    }
    public int getStamina() {
        return stamina;
    }
    public int getMana() {
        return mana;
    }
    public int getBloodlust() {
        return bloodlust;
    }
    public int getDamage() {
        return damage;
    }

    /**
     * Boss Casts a spell method
     * 
     * @param s, spell to be casted
     */
    public boolean castSpell(Spell s) {
        mana -= s.getManaCost();
        damage = s.getDamage();
        System.out.println("Vlad cast " + s.getSpellName() + " dealing " + s.getDamage() + " damage!"); 
        return true;  
    }   
    
    /**
     * Boss bloodlust regen
     * Regen 1 bloodlust, bloodlust can't go over 5
     */
    public void bloodlustRegen() {
        if (bloodlust < 5) {
            bloodlust += 1;
        }
    }

    /**
     * Boss Attack pattern
     * @param w, wizard to be attacked
     */
    public void attack(Wizard w) {
        if (bloodlust == 5) {
            castSpell(new Spell("Bloodlust", 50, 0, "c"));
            damage = 50;
            bloodlust = 0;
            health += 25;
        } else if (stamina >= 4) {
            castSpell(new Spell("Blood Cyphon", 20, 0, "b"));
            stamina -= 4;
            damage = 20;
        } else {
            castSpell(new Spell("Bite", 10, 0, "a"));
            stamina -= 2;
            damage = 10;
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

