/**
 * @author Grace Bero
 * Creates a spell class that can be used to create spells
 */

public class Spell {
    protected String spellName;
    protected int damage;
    protected int staminaCost;
    protected String keyAssociation;

    /**
     * Constructor for Attacks Class
     * @param s, string for spell name
     * @param d, int for damage
     * @param m, int for mana cost
     * @param k, string for key association
     */
    public Spell(String s, int d, int st, String k) {
        spellName = s;
        damage = d;
        staminaCost = st;
        keyAssociation = k;
    }

    /**
     * Mutators for spell name, damage, and mana cost
     * @param spell, string for spell name
     * @param dmg, int for damage
     * @param stam, int for stamina cost
     * @param key, string for key association
     */
    public void setSpellName(String s) {
        spellName = s;
    }
    public void setDamage(int d) {
        damage = d;
    }
    public void setStamina(int st) {
        staminaCost = st;
    }
    public void setKeyAssociation(String k) {
        keyAssociation = k;
    }

    /**
     * Accessors for spell name, damage, and mana cost
     * @return spellName, damage, manaCost, keyAssociation
     */
    public String getSpellName() {
        return spellName;
    }
    public int getDamage() {
        return damage;
    }
    public int getStaminaCost() {
        return staminaCost;
    }
    public String getKeyAssociation() {
        return keyAssociation;
    }

    /**
     * toString method for Attacks class
     * @return String representation of Attack
     */
    public String toString() {
        return keyAssociation + " - " + spellName + " - Dmg/Healing: " + damage + " - Mana: " + staminaCost + "\n";
    }

}
