/**
 * characterTesting.java
 * File to test to ensure that character classes are working properly
 * @Author Grace Bero
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class characterTesting {
    //Test to see if we can successfully get wizards name
    @Test
    public void testWizardName() {
        Wizard w = new Wizard("Grace");
        assertEquals("Grace", w.getName());
    }

    //Test to see if the health of boss is corect after taking damage
    @Test
    public void testBossHealth() {
        Boss b = new Boss("Vlad");
        b.loseHealth(50);
        assertEquals(150, b.getHealth());
    }

    //Test to see if the game ends if the wizard gets hypnotized
    @Test
    public void testWizardHypnotized() {
        Wizard w = new Wizard("Grace");
        w.getHypnotized();
        assertEquals(0, w.getLives());
    }
}
