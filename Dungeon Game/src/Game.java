import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    static Scanner sc = new Scanner(System.in);
    public static int option;
    public static int x = 0;

    //player initialisation
    public static Player user = new Player();

    //weapon initialisation
    public static Enemy minion = new Enemy();
    public static Enemy tarantos = new Enemy();

    //weapon initialisation
    public static Weapon melee = new Weapon();
    public static Weapon ranged = new Weapon();

    //loot room initialisation
    public static LootRoom room1 = new LootRoom();
    public static TrappedRoom room2 = new TrappedRoom();

    public static void playerSetup() {
        System.out.print("Greetings adventurer! What would you like me to call you?\nUsername: ");
        user.name = sc.nextLine();
        System.out.println("\nWelcome " + user.name + "! Ahead of you lies various treasures and enemies to be uncovered, good luck!");
        user.health = 20;
    }

    public static void enemyInit() {
        minion.health = 10;
        minion.damage = 2;

        tarantos.health = 20;
        tarantos.damage = 5;
    }

    public static void weaponInit() {
        melee.type = "Katana";
        melee.damage = 4;
        melee.reach = false;

        ranged.type = "Bow and Arrow";
        ranged.damage = 3;
        ranged.reach = true;
    }

    public static void chestInit() {
        room1.chest = true;
        room1.loot = "Health Potion";

        room2.trickChest = true;
        room2.trapDamage = 7;
    }

    public static void gameOver() {
        System.out.println("\nGAME OVER\n-----------------------");
        System.out.println("1: Play again\n2: Exit game");
        System.out.print("Option: ");
        option = sc.nextInt();

        switch (option) {
            case 1 -> {
                gameStart();
            }
            case 2 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("\nThat is not a valid option, try again.");
                gameOver();
            }
        }
    }

    public static void healthCheck() {
        if(user.health <= 0) {
            gameOver();
        }
    }

    public static void trappedChest(String roomName) {
        if(roomName.equals("Room 2")) {
            System.out.println("As you open the chest, you hear a the mechanical grind of gears as something locks into place.");
            System.out.println("A wooden latch opens, which releases a wrecking ball that strikes you square in the face.");

            user.health =- room2.trapDamage;
            System.out.println("\n" + user.health + " <- " + user.name + "'s health");
            healthCheck();

            System.out.println("\nYou slowly get up to a sitting position and check the chest to find it to be completely empty, and lie back down in defeat");
            System.out.println("\nWith nothing left to do, you get up, dust yourself off and look around.");
            x = 1;
            room2();
        }
    }

    public static void minionFightMelee() {
        while(user.health > 0 && minion.health >= 0) {
            //user attacks
            minion.health -= melee.damage;
            System.out.println(minion.health + "/10 <- Minion's health");

            //check if minion is defeated
            if(minion.health <= 0) {
                System.out.println("\nYou defeated the minion!");
                minionFightMelee();
            }

            //slight pause
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //minion attacks
            user.health -= minion.damage;
            System.out.println(user.health + " <- " + user.name + "'s health\n");

            //check if user is defeated
            healthCheck();

            //slight pause
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        room1();
    }

    public static void tarantosFightMelee() {
        while(user.health > 0 && tarantos.health >= 0) {
            //user attacks
            tarantos.health -= melee.damage;
            System.out.println(tarantos.health + "/10 <- Tarantos's health");

            //check if minion is defeated
            if(minion.health <= 0) {
                System.out.println("\nYou defeated the tarantos!");
                tarantosFightMelee();
            }

            //slight pause
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //minion attacks
            user.health -= tarantos.damage;
            System.out.println(user.health + " <- " + user.name + "'s health\n");

            //check if user is defeated
            healthCheck();

            //slight pause
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        room1();
    }
    

    //this is the starting room
    public static void gameStart() {
        System.out.println("The walls are made from stone brick and the room is lit up with torches. You see two ways to go, right and left.");
        System.out.println("Which do you choose?\n-----------------------");

        System.out.println("1: Right\n2: Left");
        System.out.print("Option: ");
        option = sc.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("\nYou choose to go RIGHT into the next room.");
                room1();
            }
            case 2 -> {
                System.out.println("\nYou choose to go LEFT into the next room.");
                room2();
            }
            default -> {
                System.out.println("\nThat is not a valid option, try again.");
                gameStart();
            }
        }
    }

    /*
    *
    * this is the RIGHT BRANCH of the dungeon
    *
    * */

    //this is the room to the RIGHT of the start room
    public static void room1() {
        if(minion.health >= 0) {
            System.out.println("As you enter the next room, you see a chest in the middle, as well as a minion sitting by a campfire and grunting.");
            System.out.println("Do you approach?\n-----------------------");

            System.out.println("1: Yes, approach the minion\n2: No, go back to the previous room");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nYou approach the minion.");
                    minionFightMelee();
                }
                case 2 -> {
                    System.out.println("\nYou choose to go BACK into the starting room.");
                    gameStart();
                }
                default -> {
                    System.out.println("\nThat is not a valid option, try again.");
                    room1();
                }
            }
        } else if(x == 0) {
            System.out.println("The minion is defeated and a treasure chest lies in the middle.");
            System.out.println("Do you loot it?\n-----------------------");

            System.out.println("1: Yes, open the chest\n2: No, ignore the chest and move to the next room\n3: Go back to the starting room");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    if (room1.chest) {
                        System.out.println("\nYou open the chest and find a " + room1.loot + ".");

                    } else {
                        System.out.println("\nYou open the chest and find that it has already been looted.");
                    }
                    x = 1;
                    room1();
                }
                case 2 -> {
                    System.out.println("\nYou ignore the chest in the room.");
                    x = 1;
                    room1();
                }
                case 3 -> {
                    System.out.println("\nYou go back into the room you started in.");
                    gameStart();
                }
                default -> {
                    System.out.println("\nThat is not a valid option, try again.");
                    room1();
                }
            }
        } else {
            x = 0;
            System.out.println("There are three ways to go, forward, left and back to the starting room.");
            System.out.println("Which way do you go?\n-----------------------");

            System.out.println("1: Go forward\n2: Go left\n3: Go back to the starting room");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nYou continue on FORWARD into the next room.");
                    room3();
                }
                case 2 -> {
                    System.out.println("\nYou go to the room on your LEFT.");
                    //room5();
                }
                case 3 -> {
                    System.out.println("\nYou go back into the room you started in.");
                    gameStart();
                }
                default -> {
                    System.out.println("\nThat is not a valid option, try again.");
                    room1();
                }
            }
        }
    }

    //going forward from room1
    public static void room3() {
        System.out.println("You move the curtains of vines out of your way and enter a room filled with sunlight.");
        System.out.println("Do you approach?\n-----------------------");

        System.out.println("1: Yes, approach the minion\n2: No, go back to the previous room");
        System.out.print("Option: ");
        option = sc.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("\nYou approach the minion.");
                minionFightMelee();
            }
            case 2 -> {
                System.out.println("\nYou choose to go BACK into the starting room.");
                gameStart();
            }
            default -> {
                System.out.println("\nThat is not a valid option, try again.");
                room1();
            }
        }
    }

    /*
     *
     * this is the LEFT BRANCH of the dungeon
     *
     * */

    //this is the room to the LEFT of the start room
    public static void room2() {
        if(x == 0) {
            System.out.println("You enter a dimly lit room which is completely empty. In the centre you see a chest sitting alone.");
            System.out.println("Do you open it?\n-----------------------");

            System.out.println("1: Yes\n2: No, ignore the chest\n3: Go back to the starting room");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nYou choose to open and loot the chest.");
                    trappedChest("Room 2");
                }
                case 2 -> {
                    System.out.println("\nYou ignore the chest and decide to explore the dungeon further.");
                    x = 1;
                    room2();
                }
                case 3 -> {
                    System.out.println("\nYou go back to the room you started.");
                    gameStart();
                }
                default -> {
                    System.out.println("\nThat is not a valid option, try again.");
                    room2();
                }
            }
        } else {
            x = 0;
            System.out.println("There are two rooms in front of you to go to, forward and right. You can also return to the previous room.");
            System.out.println("Which way do you go?\n-----------------------");

            System.out.println("1: Go right\n2: Go forward\n3: Go back to the starting room");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nYou continue on FORWARD into the next room.");
                    //room4();
                }
                case 2 -> {
                    System.out.println("\nYou go to the room on your LEFT.");
                    //room6();
                }
                case 3 -> {
                    System.out.println("\nYou go back into the room you started in.");
                    gameStart();
                }
                default -> {
                    System.out.println("\nThat is not a valid option, try again.");
                    room2();
                }
            }
        }
    }

    public static void main(String[] args) {
        playerSetup();
        enemyInit();
        weaponInit();
        System.out.println("\nYou open the great doors to the mysterious dungeon and a strong stench immediately fills the air.");
        gameStart();
    }
}