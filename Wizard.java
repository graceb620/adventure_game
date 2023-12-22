/** 
* @author Grace Bero  
* Creates the wizard type that inherits traits from character 
 */
import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    protected int mana;
    protected ArrayList<Spell> spellList;
    protected int healthPotions;
    protected int damage;
    protected int lives;

    /**
     * Constructor for Wizard Class
     * @param n, string for name of character
     */
    public Wizard(String n) {
        super(n);
        mana = 8;
        spellList = new ArrayList<Spell>();
        healthPotions = 0;
        lives = 3;
    }

    /**
     * Mutator for mana of wizard
     * @param m, int for mana
     * @param l, int for lives
     * @param h, int for health potions
     */
    public void setMana(int m) {
        mana = m;
    }
    public void setLives(int l) {
        lives = l;
    }
    public void setHealthPotions(int h) {
        healthPotions = h;
    }

    /**
     * Mutators for adding/removing spells from spell list
     * @param s, string for spell
     */
    public void addSpell(Spell s) {
        spellList.add(s);
    }
    public void removeSpell(Spell s) {
        spellList.remove(s);
    }

    /**
     * Accessors for mana and spell list
     * @return mana, spellList, lives
     */
    public int getMana() {
        return mana;
    }
    public List<Spell> getSpellList() {
        return spellList;
    }
    public int getLives() {
        return lives;
    }

    /**
     * Casts a spell method
     * @param s, spell to be casted
     * @return true if spell is casted, false if not enough mana
     */
    public boolean castSpell(Spell s) {
        if (mana >= s.getManaCost()) { //checks to see if wizard has enough mana to cast spell
            if (s.equals("h")) {
                mana -= s.getManaCost();  //if so, subtracts mana cost from mana
                damage = s.getDamage(); //sets damage to damage of spelld
                System.out.println("You cast " + s.getSpellName() + " healing " + s.getDamage() + " health!");  
            } else {
                mana -= s.getManaCost();  //if so, subtracts mana cost from mana
                damage = s.getDamage(); //sets damage to damage of spelld
                System.out.println("You cast " + s.getSpellName() + " dealing " + s.getDamage() + " damage!");
            }
            return true; //returns true if spell is casted
        } else { 
            System.out.println("You don't have enough mana to cast " + s.getSpellName() + "!");
            return false;
        }
    }

    /**
     * Wizard loses a life method
     */
    public void loseLife() {
        lives--;
    }

    /**
     * Wizard gets hypnotized method
     * If this happens, wizard loses all lives and game ends
     */
    public void getHypnotized() {
        lives = 0;
        if (lives == 0) {
            System.out.println("You have been hypnotized and are now a slave to Vlad! \nGAME OVER!");
            System.exit(0);
        }
    }

    /**
     * Wizard loses health method
     * If health is less than or equal to 0, wizard loses a life and health is reset to 100
     * @param damage, int for damage
     */
    public void loseHealth(int damage) {

        if (health <= 0) {
            loseLife();
            health = 100;
        }
    }

    /**
     * Regenerates mana method
     * Mana regenerates by 2, but can't go over 8
     */
    public void regenerateMana() {
        if (mana < 8) {
            mana += 2;
            if (mana > 8) {
                mana = 8;
            }
        }
    }

    /**
     * Wizard health to full method
     */
    public void healthToFull() {
        health = 100;
    }

    /**
     * Wizard mana to full method
     */
    public void manaToFull() {
        mana = 8;
    }

    /**
     * Health potion used method
     * If wizard has health potions, health is increased by 50 and health potions decrease by 1
     */
    public void healthPotion() {
        if (healthPotions > 0) {
            health += 50;
            healthPotions--;
        }
        else {
            System.out.println("You don't have any health potions!");
        }
    }

    /**
     * Wizard gains health method
     * @param damage, int for damage
     */
    public void gainHealth(int damage) {
        health += damage;
    }


    /**
     * toString method for Wizard class
     * @return String representation of Wizard
     */
    public String toString() {
        String wizardString = "";
        wizardString += "Name: " + getName() + "\n";
        wizardString += "Current Health: " + getHealth() + "\n";
        wizardString += "Current Mana: " + getMana() + "\n";
        wizardString += "Current Lives: " + getLives() + "\n";
        wizardString += "Health Potions: " + healthPotions + "\n";
        return wizardString;
    }

}

