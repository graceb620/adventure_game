/**
 * @author Grace Bero
 * Program that utilizes classes, Wizard, Boss, Spell, and Goblin classes to create a text based game
 */

import java.util.Scanner;

public class Game {
    /**
     * This is the main method that runs the game
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Wizard w;
        Boss b;
        Goblin g;
        Spell ult, basic, heal, sleep, physical; //Spells for player to use
        String combatRules, combatRules2, answer, divideString;
        boolean valid, valid2, sleepStatus, combat, playerTurn;
        
        //Creation of characters w, b, g
        w = new Wizard("TBD"); 
        b = new Boss("Vlad"); 
        g = new Goblin("Blinky"); 

        divideString = "---------------------------------------------------------------------------------------------------------------"; //Created for ease of reading purposes
        
        //Creation of characters
        ult = new Spell("Fireball", 50, 6, "f");
        basic = new Spell("Spark", 25, 3, "s");
        heal = new Spell("Heal", 20, 2, "h");
        sleep = new Spell("Sleep", 0, 6, "z");
        physical = new Spell("Physical Attack", 10, 0, "p");

        w.spellList.add(physical); //Physical is always an option for the player no need to learn it

        //Creating a string to display combat rules
        combatRules = ""; 
        combatRules += "- Combat is turn based. You may choose to cast a spell, physical attack, or use a health potion during your turn \n";
        combatRules += "- Casting spells costs mana. You can have a max of 8 mana and regenerate 2 mana per turn cycle \n";
        combatRules += "- You may only cast a spell if you have enough mana, you may only use a health potion if you have one in your inventory \n";
        combatRules += "- On your turn, your options will appear, and you will press the key associated with desired action \n";
        combatRules += "    - Spell will appear as: Key to press - Spell name - damage/healing amount - mana cost\n";
        combatRules += "Press 'x' to continue";
        
        //Creating a string to display combat rules for boss
        combatRules2 = "";
        combatRules2 += "- Vlad will continuously gain 'bloodlust' every turn \n";
        combatRules2 += "- When Vlad reaches 5 bloodlust, he will use his ultimate attack, dealing 50 damage, and regaining 25 health \n";
        combatRules2 += "- If Vlad is put to sleep, he will lose all of his bloodlust and be unable to attack on his next turn \n";
        combatRules2 += "Press 'x' to continue";
        
        //Welcome to the game intro 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello, welcome to the game! What is your name?");
        w.setName(keyboard.nextLine());
        System.out.println(divideString);
        System.out.println("Welcome " + w.getName() + "!");
        System.out.println("The game will give you a series of options to choose from, you will type the corresponding letter with the option.");
        System.out.println("\n");

        //Introducing player to the choose your own adventure aspect of the game
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Let's do an example: Would you like to continue? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("a")) {
                System.out.println("Great! You are ready to play!");
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                System.out.println("Too bad! You are playing anyways!");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        System.out.println("\n");
        System.out.println("You are a student at Wizard academy");

        //Learning a basic spell, spark
        valid = false;
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("You have charms class now. Do you go to class? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("a")) {
                System.out.println("You go to class and learn a new spell!");
                System.out.println("You learned " + basic.getSpellName() + "!");
                w.spellList.add(basic); //Add basic to the player's spell list
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                System.out.println("You can't skip class silly!");
                System.out.println("You go to class and learn a new spell!");
                System.out.println("You learned " + basic.getSpellName() + "!");
                w.spellList.add(basic); //Add basic to the player's spell list
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again  
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        System.out.println("Spark is a basic spell that deals 25 damage and costs 3 mana.");

        //Learning a more advanced spell, Fireball
        System.out.println("\n");
        System.out.println("Your professor notices your affinity for fire and offers to teach you a more complex spell.");
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Do you accept their offer? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString); // Print a line to divide the text
            if (answer.equals("a")) {
                System.out.println("You learn " + ult.getSpellName() + "!");
                System.out.println("Fireball is a powerful spell that deals 50 damage and costs 6 mana.");
                w.spellList.add(ult); //Add ult to the player's spell list
                valid = true; // Set valid to true to exit the loop
            
            } else if (answer.equals("b")) {
                //This is a built in warning to make sure the player understands that not learning the spell could make the game harder
                valid2 = false; // Set valid2 to false to enter the inner loop
                while (!valid2) { //Loop will continue until user enters a valid option
                    System.out.println("Not learning this spell could make the game harder for you. \nDo you still refuse? \n a) Yes \n b) No");
                    answer = keyboard.nextLine(); //Get user input
                    System.out.println(divideString);
                    if (answer.equals("a")) {
                        System.out.println("You decline your professor's offer and do not learn " + ult.getSpellName() + ".");
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else if (answer.equals("b")) {
                        System.out.println("You learn " + ult.getSpellName() + "!");
                        w.spellList.add(ult); //Add ult to the player's spell list
                        System.out.println("Fireball is a powerful spell that deals 50 damage and costs 6 mana.");
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else { //If the user does not enter a valid option, they will be prompted to try again
                        System.out.println("You did not enter a valid option, please try again.");
                    }
                }
            
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        System.out.println("\n");
        
        //Transition scene
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Your day has ended, would you like to go to sleep? \n a) Yes \n b) No");
            answer = keyboard.nextLine();
            System.out.println(divideString);
            if (answer.equals("a")) {
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                System.out.println("You attempt to stay up all night but end up passing out anyways.");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
    
        System.out.println("Zzzzzzzzzzz *snore* Zz");
        System.out.println("\n");
        System.out.println("You wake up to the sound of screaming!");
        
        //Introduces the goblin enemy
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("ENCOUNTER: A goblin has broken into the academy! \nYou must defeat it! \nPress 'x' to continue.");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("x")) {
                System.out.println("Brief guide to combat:");
                valid = true; // Set valid to true to exit the loop
            } else {  //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        //Brief guide to combat 
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println(combatRules); // Print combat rules
            answer = keyboard.nextLine(); //Get user input
            if (answer.equals("x")) {
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println(divideString);
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        System.out.println(divideString);

        //Begin combat with goblin
        combat = true; // Set combat to true to enter combat loop
        playerTurn = true; // Set playerTurn to true to start with player's turn
        System.out.println("\n");
        while (combat) {
            valid = false; // Set valid to false to enter the loop
            if (playerTurn && w.getLives() > 0) {
                while (!valid) {
                    System.out.println(w.toString());
                    System.out.println(g.toString());
                    System.out.println("What would you like to do?");
                    
                    for (int counter = 0; counter < w.spellList.size(); counter++) { //Prints out the player's spell list for them to choose from
                        System.out.println(w.spellList.get(counter).toString());
                    }

                    answer = keyboard.nextLine(); //Get user input
                    System.out.println(divideString);
                    
                    //Player chooses spell
                     if (answer.equals("f")) { 
                        if (w.getMana() >= ult.getManaCost()) {
                            w.castSpell(ult); //Player casts ult
                            g.loseHealth(ult.getDamage()); //Goblin loses health = to ult damage
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + ult.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else if (answer.equals("s")) { 
                        if (w.getMana() >= basic.getManaCost()) {
                            w.castSpell(basic); //Player casts basic
                            g.loseHealth(basic.getDamage()); //Goblin loses health = to basic damage
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + basic.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else if (answer.equals("p")) { 
                        w.castSpell(physical); //Player casts physical
                        g.loseHealth(physical.getDamage()); //Goblin loses health = to physical damage
                        valid = true; // Set valid to true to exit the loop
                        playerTurn = false; // Set playerTurn to false to end player's turn
                    } else { //If they don't enter a valid option they will be prompted to try again
                        System.out.println("You did not enter a valid option, please try again.");
                    }
                }
                w.regenerateMana(); //Wizard regenerates mana at the end of the turn
            
            //Goblin's turn
            } else if (!playerTurn && g.getHealth() > 0) {
                g.attack(w); //Goblin attacks wizard using attack method
                w.loseHealth(g.getDamage()); //Wizard loses health = to goblin damage
                g.staminaRegen(); //Goblin regenerates stamina at the end of the turn
                playerTurn = true; // Set playerTurn to true to end goblin's turn
                System.out.println(divideString);

            } else if (w.getLives() <= 0) { //If the player dies the game will end
                System.out.print("You have died! \nGAME OVER");
                System.exit(0);

            } else if (g.getHealth() <= 0) { //If the goblin dies the combat loop will end
                System.out.println("You have defeated the goblin!");
                combat = false; // Set combat to false to exit the loop
            }
        }

        //Transition to next scene
        System.out.println("\n");
        System.out.println("You pass out and wake up in the infirmary.");
        System.out.println("You are told that you were injured in the fight and the nurse offers to teach you a healing spell.");

        //Learning heal spell
        valid = false;  // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Do you accept their offer? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString); 
            if (answer.equals("a")) { 
                System.out.println("You learn " + heal.getSpellName() + "!"); 
                System.out.println("Heal is a spell that heals 20 health and costs 2 mana.");
                w.spellList.add(heal); //Add heal to the player's spell list
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                
                //This is a built in warning to make sure the player understands that not learning the spell could make the game harder
                valid2 = false; // Set valid2 to false to enter the inner loop
                while (!valid2) { 
                    System.out.println("Not learning this spell could make the game harder for you. \nDo you still refuse? \n a) Yes \n b) No");
                    answer = keyboard.nextLine(); //Get user input
                    System.out.println(divideString);
                    if (answer.equals("a")) {
                        System.out.println("You decline the nurse's offer and do not learn " + heal.getSpellName() + ".");
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else if (answer.equals("b")) {
                        System.out.println("You learn " + heal.getSpellName() + "!");
                        w.spellList.add(heal); //Add heal to the player's spell list
                        System.out.println("Heal is a spell that heals 20 health and costs 2 mana.");
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else { //If the user does not enter a valid option, they will be prompted to try again
                        System.out.println("You did not enter a valid option, please try again.");
                    }
                }
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        System.out.println("\n");
        System.out.println("The nurse offers you health potions to help you on your journey.");
        
        //Getting health potions
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Do you accept their offer? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString); // Print a line to divide the text
            if (answer.equals("a")) {
                System.out.println("You now have 3 health potions!");
                System.out.println("Health potions heal 50 health and allow you to go over your max health.");
                w.healthPotions = 3; //Set wizard health potions to 3
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                System.out.println("You decline their offer and do not receive health potions.");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        //Transition Scene
        System.out.println(divideString);
        System.out.println("Your health and mana are back to full after visiting the infirmary.");
        w.healthToFull(); //set wizards health to full
        w.manaToFull(); //set wizards mana to full
        
        //This is a transitional scene to make the game flow better and reduce the amount of text that prints at once
        valid = false; // Set valid to false to enter the loop
            while (valid == false) {
                System.out.println("\n");
                System.out.println("Press 'x' to continue");
                answer = keyboard.nextLine(); //Get user input
                if (answer.equals("x")) {
                    valid = true; // Set valid to true to exit the loop
                } else { //If the user does not enter a valid option, they will be prompted to try again
                    System.out.println("You did not enter a valid option, please try again.");
                }
            }
        
        //Transition 
        System.out.println(divideString);
        System.out.println("You run into the headmaster while going to your dorm.");
        System.out.println("He tells you that the goblin was a scout for an evil vampire named Vlad who plans to attack the academy tonight.");
        System.out.println("\n");
        System.out.println("He asks you to go to his lair and defeat Vlad before he can attack the academy.");
        
        //Accepting the headmaster's Quest
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Do you accept his request? \n a) Yes \n b) No");
            answer = keyboard.nextLine();
            System.out.println(divideString); // Print a line to divide the text
            if (answer.equals("a")) { //This will continue the game
                System.out.println("You find it a bit strange that he is asking a first year to do this, but you agree.");
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) { //Choosing no will end the game
                System.out.println("You decline the headmaster's request and go back to your dorm.");
                System.out.println("You go to sleep and wake up the next day to find that Vlad has attacked the academy.");
                System.out.println("You are killed in the attack.");
                System.out.println("GAME OVER");
                System.exit(0); //Ends the game
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        System.out.println("\n");
        System.out.println("The headmaster offers to teach you a sleep spell");
        
        //Learning sleep spell
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("Do you accept their offer? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString); 
            if (answer.equals("a")) { 
                System.out.println("You learn " + sleep.getSpellName() + "!");
                System.out.println("Sleep is a spell that will put an enemy to sleep, making them unable to act during their next turn, and costs 6 mana.");
                w.spellList.add(sleep); //Add sleep to the player's spell list
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                
                //This is a built in warning to make sure the player understands that not learning the spell could make the game harder
                valid2 = false; // Set valid2 to false to enter the inner loop
                while (!valid2) {
                    System.out.println("Not learning this spell could make the game harder for you. \nDo you still refuse? \n a) Yes \n b) No");
                    answer = keyboard.nextLine(); //Get user input
                    System.out.println(divideString);
                    if (answer.equals("a")) {
                        System.out.println("You decline the headmasters offer and do not learn " + sleep.getSpellName() + ".");
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else if (answer.equals("b")) {
                        System.out.println("You learn " + sleep.getSpellName() + "!");
                        System.out.println("Sleep is a spell that will put an enemy to sleep, making them unable to act during their next turn, and costs 6 mana.");
                        w.spellList.add(sleep); //Add sleep to the player's spell list
                        valid2 = true; // Set valid2 to true to exit the inner loop
                        valid = true; // Set valid to true to exit the outer loop
                    } else { //If the user does not enter a valid option, they will be prompted to try again
                        System.out.println("You did not enter a valid option, please try again.");
                    }
                }
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        System.out.print("\n");
        System.out.println("The headmaster offers you a pair of brass knuckles so you can defend yourself.");

        //Getting brass knuckles
        valid = false; // Set valid to false to enter the loop
        while (!valid) { 
            System.out.println("Do you accept his offer? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            physical.setDamage(15); //Set physical damage to 15
            if (answer.equals("a")) {
                System.out.println("You now have brass knuckles!");
                System.out.println("Your physical attack now does 15 damage!");
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) {
                System.out.println("You decline his offer.");
                System.out.println("Brass knuckles are quite barbaric in your opinion.");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        System.out.println("\n");
        System.out.println("You leave the headmaster's office and head to Vlads Lair.");
        System.out.println("You arrive at the gate. This is your last chance to back out.");

        //Entering Vlad's Lair
        valid = false; // Set valid to false to enter the loop
        while (!valid) { 
            System.out.println("Do you enter? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("a")) {
                System.out.println("You enter the lair and come face to face with Vlad.");
                valid = true; // Set valid to true to exit the loop
            } else if (answer.equals("b")) { //Choosing no will end the game
                System.out.println("You decide to go back to your dorm.");
                System.out.println("You go to sleep and wake up the next day to find that Vlad has attacked the academy.");
                System.out.println("You are killed in the attack.");
                System.out.println("GAME OVER");
                System.exit(0); //Ends the game
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        //Convo between player and Vlad before fight
        System.out.println("\n");
        System.out.println("Vlad: Hello, I was expecting them to send a more experienced wizard to fight me.");
        System.out.println("Vlad: Doesn't it make you angry that they're sending you to die?");
        System.out.println("Vlad: Why don't you join me? I can make you powerful.");
        System.out.println("\n");
        
        valid = false; // Set valid to false to enter the loop
        while (!valid) {
            System.out.println("Do you join vlad? \n a) Yes \n b) No");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("a")) { //Choosing yes will end the game
                System.out.println("You feel compelled to say yes.");
                w.getHypnotized(); 
            } else if (answer.equals("b")) {
                System.out.println("You refuse to join Vlad and prepare to fight.");
                System.out.println("Vlad: So be it, I will try to make your death swift and painless");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        //Introduces the boss enemy Vlad
        System.out.println("\n");
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println("ENCOUNTER: You have entered combat with vlad! \nYou must defeat him! \nPress 'x' to continue.");
            answer = keyboard.nextLine(); //Get user input
            System.out.println(divideString);
            if (answer.equals("x")) {
                System.out.println("Brief guide to combat:");
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        //Brief guide to combat
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println(combatRules); // Print combat rules
            answer = keyboard.nextLine(); //Get user input
            if (answer.equals("x")) {
                System.out.println(divideString); 
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println(divideString);
                System.out.println("You did not enter a valid option, please try again.");
            }
        }
        
        //Brief guide to combat with Vlad specifically. Seperated so the user doesn't get overwhelmed with text
        valid = false; // Set valid to false to enter the loop
        while (!valid) { //Loop will continue until user enters a valid option
            System.out.println(combatRules2); // Print combat rules
            answer = keyboard.nextLine(); //Get user input
            if (answer.equals("x")) {
                valid = true; // Set valid to true to exit the loop
            } else { //If the user does not enter a valid option, they will be prompted to try again
                System.out.println(divideString);
                System.out.println("You did not enter a valid option, please try again.");
            }
        }

        //Begin combat with Vlad
        System.out.println(divideString);
        combat = true; // Set combat to true to enter combat loop
        playerTurn = true; // Set playerTurn to true to start with player's turn
        sleepStatus = false; // Set sleepStatus to false to start with Vlad awake
        System.out.println("\n");
        while (combat) {
            valid = false; // Set valid to false to enter the loop
            if (playerTurn && w.getLives() > 0) {
                while (!valid) { 
                    System.out.println(w.toString()); //Prints out the player's stats
                    System.out.println(b.toString()); //Prints out Vlad's stats
                    System.out.println("What would you like to do?");

                    //Prints out the player's spell list and options to do during turn
                    for (int counter = 0; counter < w.spellList.size(); counter++) { 
                        System.out.println(w.spellList.get(counter).toString());
                    }
                    System.out.println("1 - Use a health potion");

                    answer = keyboard.nextLine(); //Get user input
                    System.out.println(divideString);
                    
                    //Player chooses spell
                     if (answer.equals("f")) {
                        if (w.getMana() >= ult.getManaCost()) {
                            w.castSpell(ult); //Player casts ult
                            b.loseHealth(ult.getDamage()); //Vlad loses health = to ult damage
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + ult.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else if (answer.equals("s")) {
                        if (w.getMana() >= basic.getManaCost()) {
                            w.castSpell(basic); //Player casts basic
                            b.loseHealth(basic.getDamage()); //Vlad loses health = to basic damage
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + basic.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }    
                    } else if (answer.equals("h")) {
                        if (w.getMana() >= heal.getManaCost()) {
                            w.castSpell(heal); //Player casts heal
                            w.gainHealth(heal.getDamage()); //Wizard gains health = to heal damage
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + heal.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else if (answer.equals("z")) {
                        if (w.getMana() >= sleep.getManaCost()) {
                            w.castSpell(sleep); //Player casts sleep
                            b.goSleep(); //Vlad goes to sleep
                            sleepStatus = true; //Set sleepStatus to true to make sure Vlad doesn't attack
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have enough mana this will print and they will be prompted to try again
                            System.out.println("You do not have enough mana to cast " + heal.getSpellName() + "!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else if (answer.equals("p")) {
                        w.castSpell(physical); //Player casts physical
                        g.loseHealth(physical.getDamage()); //Vlad loses health = to physical damage
                        valid = true; // Set valid to true to exit the loop
                        playerTurn = false; // Set playerTurn to false to end player's turn
                    } else if (answer.equals("1")) {
                        if (w.healthPotions > 0) {
                            w.healthPotion(); //Player uses health potion
                            valid = true; // Set valid to true to exit the loop
                            playerTurn = false; // Set playerTurn to false to end player's turn
                        } else { //If they dont have any health potions this will print and they will be prompted to try again
                            System.out.println("You do not have any health potions!");
                            System.out.println("Why don't you try something else?");
                            System.out.println("\n");
                        }
                    } else {
                        System.out.println("You did not enter a valid option, please try again.");
                    }
                }
                w.regenerateMana(); //Wizard regenerates mana at the end of the turn
                b.bloodlustRegen(); //Vlad regenerates bloodlust at the beginning of the turn
            } else if (!playerTurn && b.getHealth() > 0) {
                if (!sleepStatus); { //If Vlad is not asleep he will attack
                    if (b.stamina >= 2) {
                        b.attack(w); //Vlad attacks wizard using attack method
                        w.loseHealth(b.getDamage()); //Wizard loses health = to Vlad damage
                        b.staminaRegen(); //Vlad regenerates stamina at the end of the turn
                        playerTurn = true; // Set playerTurn to true to end Vlad's turn
                    } else { //Vlad attempts to hypnotize the player if stamina is below 2
                        System.out.println(divideString);
                        System.out.println("Vlad: You should join me, you know its the right thing to do.");
                        System.out.println("He looks deep into your eyes and you feel your mind slipping away.");
                        
                        valid = false; // Set valid to false to enter the loop
                        while (!valid) {
                            System.out.println("What do you do? \n a) Resist \n b) Give in");
                            answer = keyboard.nextLine(); //Get user input
                            System.out.println(divideString);
                            if (answer.equals("a")) {
                                System.out.println("You resist Vlad's hypnosis!");
                                valid = true; // Set valid to true to exit the loop
                                playerTurn = true; // Set playerTurn to true to end Vlad's turn
                            } else if (answer.equals("b")) { //Choosing "Give in" will end the game
                                System.out.println("You give in to Vlad's hypnosis!");
                                w.getHypnotized(); //Wizard gets hypnotized and the game ends
                            } else { //If the user does not enter a valid option, they will be prompted to try again
                                System.out.println("You did not enter a valid option, please try again.");
                            }
                        }
                    }
                    System.out.println(divideString);
                } if (sleepStatus) { //If Vlad is asleep he will not attack
                    System.out.println("Vlad is asleep and cannot attack!");
                    sleepStatus = false; //Set sleepStatus to false to make sure Vlad can attack next turn
                    playerTurn = true; // Set playerTurn to true to end Vlad's turn
                }
            } else if (w.getLives() <= 0) { //If the player dies the game will end
                System.out.print("You have died! \nGAME OVER");
                System.exit(0); //Ends the game
            } else if (b.getHealth() <= 0) { //If Vlad dies the combat loop will end
                System.out.println("You have defeated Vlad!!!");
                combat = false; // Set combat to false to exit the loop
            }
        }   
        
        // Transition to ending
        System.out.println(divideString);
        System.out.println("You back to the academy and are greeted by the headmaster.");
        System.out.println("Headmaster: You have done well young wizard, you have saved the academy.");
        System.out.println("The End");  
        System.exit(0); //Ends the game 
        keyboard.close(); //Close the scanner
    }   
}

