import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);
	
	//Variables
	static int pHP;
	String name;
	int choice;
	int items = 0;

	//Enemies
	static Enemy eFour = new Enemy("Doblin");
	static Enemy eSix = new Enemy("Tarantos");

	//Weapons
	static Weapon wpnEqp;
	static Weapon wTwo = new Weapon("dagger");
	static Weapon wThree = new Weapon("catapult");
	static Weapon wTen = new Weapon("katana");
	static Weapon wEleven = new Weapon("bow and arrow");

	public static void main(final String[] args) {
		final Main game = new Main();
		game.playerSetUp();
		game.intro();
	
		/*if (fargonHP==0) {
			System.out.println("\nYou defeated the monster.");
			System.out.println("\nGuard: Wow! you defeated the forest monster! Thank you kind stranger, please come into our town. Welcome to Kandaro!");
				victory();
		}
		else if (ligonHP==0) {
			System.out.println("\nYou defeated the monster.");
			System.out.println("\\nGuard: Wow! you defeated the lake monster! Thank you kind stranger, please come into our town. Welcome to Kandaro!");
				victory();
		}
		else if (metranHP==0) {
			System.out.println("\nYou defeated the monster.");
			System.out.println("\nGuard: Wow! you defeated the mountain monster! Thank you kind stranger, please come into our town. Welcome to Kandaro!");
				victory();
		}*/
	}
	
	public void playerSetUp() {
		System.out.println("What is your name, adventurer?");
		pHP = 5;
		
		name = scanner.nextLine();
		System.out.println("Welcome, " + name + "!");
	
		wTwo.wpnDmg(1);
		wTwo.wpnStatus(false);

		wThree.wpnDmg(2);
		wThree.wpnStatus(false);

		wTen.wpnDmg(4);
		wTen.wpnStatus(false);

		wEleven.wpnDmg(3);
		wEleven.wpnStatus(false);

		eFour.nmyHP(2);
		eFour.nmyAtck(1);
		
		eSix.nmyHP(4);
		eSix.nmyAtck(2);
	}
	
	public void intro() {
		System.out.println("\nYou wake up to a knock on your door.");
		System.out.println("As you get out of bed, you see the royal messenger, waitng eagerly outside, with a message in his hands.");
		System.out.println("You open the door.");
		System.out.println("\nMessenger: " + name + "! The King's advisor has been captured! Please help us " + name + ", and in return you will receive all the wealth you could dream of.");
		System.out.println("The messenger runs back into the forest, towards the castle, and you get ready to go on adventure.");
			start();
	}

	public void start() {
		System.out.println("\nWhere do you go?");
		System.out.println("----------------------------");
		System.out.println("1: Into the forest");
		System.out.println("2: Back into your house");
		
		choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("\n" + name + ": Well, into the forest we go!");
					room1();
			break;
			case 2:
				home();
			break;
			default:
				System.out.println("\nThat's not an option. Try again.");
					start();
		}
	}
	
	public void home() {
		System.out.println("\n" + name + ": Ah back home, nice and refreshed.");
		System.out.println("There's nothing to do here and I'm still on a quest anyway.");
		pHP = 5;
		System.out.println("You now have " + pHP + "HP and " + items + " items.");
		System.out.println("You head back outside.");
			start();

	}
	
	public void room1() {
		//Main Forest
		System.out.println("\nAs you enter ther forest you see a path to your right, to Fargo Forest and one to your left, to Ligo Lake.");
		System.out.println("\nWhich way do you go?");
		System.out.println("----------------------------");
		System.out.println("1: Fargo Forest");
		System.out.println("2: Ligo Lake");
		System.out.println("3: Back home");

		choice = scanner.nextInt();

		switch(choice) {
			case 1:
				System.out.println(name + ": I think I'll go to Fargo Forest.");
					room2();
			break;
			case 2:
				System.out.println(name + ": I think I'll go to Ligo Lake.");
					room3();
			break;
			case 3:
				home();
			break;
			default:
				System.out.println("\nThat's not an option. Try again.");
					room1();
		}
	}

	public void room2() {
		//Fargo Forest
		if (wTwo.status==false) {
			System.out.println("You move the plants out of your way and are brought to a small clearing in Fargo Forest.");
			System.out.println("A treasure chest can be seen at the centre of the clearing. Be warned that these chests may contain a helpful item or a dangerous one.");
			System.out.println("\nWhat do you do?");
			System.out.println("----------------------------");
			System.out.println("1: Open the chest");
			System.out.println("2: Ignore the chest");

			choice = scanner.nextInt();

			switch(choice) {
				case 1:
					System.out.println("\nYou approach the chest carefully and slowly open the lid. Inside you find a dagger.");
					System.out.println("\nITEM GAINED: Dagger");
					wTwo.status = true;
					items = items + 1;
						room2();
				break;
				case 2:
					System.out.println("\nYou slowly walk around the chest, and see two signs, one pointing back to where you came from and the other to Metra Mountains.");
					System.out.println("\nWhich way do you go?");
					System.out.println("----------------------------");
					System.out.println("1: Metra Mountains");
					System.out.println("2: Main forest");

					choice = scanner.nextInt();
				
					switch(choice) {
						case 1:
							System.out.println(name + ": Metra Mountains seems like the logical option.");
								room4();
						break;
						case 2:
							System.out.println(name + ": Back to the main forest we go.");
								room1();
						break;
						default:
							System.out.println("\nThat's not an option. Try again.");
								room2();
					}
				break;
				default:
					System.out.println("\nThat's not an option. Try again.");
						room2();
			}
		}
		else {
			System.out.println("\nThe treasure chest has been looted.");
			System.out.println("You now see two signs, one pointing back to the main forest, and the other to Metra Mountains.");
			System.out.println("\nWhich way do you go?");
			System.out.println("----------------------------");
			System.out.println("1: Metra Mountains");
			System.out.println("2: Main forest");

			choice = scanner.nextInt();
		
			switch(choice) {
				case 1:
					System.out.println(name + ": Metra Mountains seems like the logical option.");
						room4();
				break;
				case 2:
					System.out.println(name + ": Back to the main forest we go.");
						room1();
				break;
				default:
					System.out.println("\nThat's not an option. Try again.");
						room2();
			}
		}
	}

	public void room3() {
		//Ligo Lake
	}

	public void room4() {
		//Metra Mountains
		if (eFour.HP>0) {
			System.out.println("\nYou slowly but surely climb up the jagged cliffs of Metra until you finally reach the top.");
			System.out.println("As you look down in between this mountain and the next, you see a small Doblin.");
			System.out.println("A boulder sits in front of you.");
			System.out.println("\nWhich weapon would you like to equip?");

			final String wpnName = scanner.nextLine();

			switch(wpnName) {
				case "dagger":
					if (wTwo.status==true) {
						System.out.println("EQUIPPED WEAPON: Dagger");
						wpnEqp = wTwo;
					}
					else {
						System.out.println("You don't have that weapon.");
							room4();
					}
				break;
				case "catapult":
					if (wThree.status==true) {
						System.out.println("EQUIPPED WEAPON: Catapult");
						wpnEqp = wThree;
					}
					else {
						System.out.println("You don't have that weapon.");
							room4();
					}
				break;
				case "katana":
					if (wTen.status==true) {
						System.out.println("EQUIPPED WEAPON: Katana");
						wpnEqp = wTen;
					}
					else {
						System.out.println("You don't have that weapon.");
							room4();
					}
				break;
				case "bow and arrow":
					if (wEleven.status==true) {
						System.out.println("EQUIPPED WEAPON: Bow and Arrow");
						wpnEqp = wEleven;
					}
					else {
						System.out.println("You don't have that weapon.");
							room4();
					}
				break;
				case "nothing":
					System.out.println("You don't equip a weapon.");
				break;
				default:
					System.out.println("You don't have a weapon called " + wpnName + ". Try again.");
						room4();
			}

			if (wpnEqp==wTwo|wpnEqp==wThree||wpnEqp==wTen||wpnEqp==wEleven) {
				System.out.println("\nWhat do you do?");
				System.out.println("----------------------------");
				System.out.println("1: Get closer and attack to the " + eFour.species + " with your " + wpnName);
				System.out.println("2: Push the boulder in front of you");

				choice = scanner.nextInt();

				switch (choice) {
					case 1:
						System.out.println("You charge down the mountain " + wpnEqp.type + " in hand and you sneak attack the Doblin.");
						eFour.HP = eFour.HP - wpnEqp.dmg;
						System.out.println("The Doblin has " + eFour.HP + "HP.");
						System.out.println("The Doblin turns around in shock, picks up a spear and attacks you.");
						pHP = pHP - eFour.atck;
						System.out.println("You now have " + pHP + "HP.");
						System.out.println("You attack the Doblin again.");
						eFour.HP = eFour.HP - wpnEqp.dmg;
						System.out.println("The Doblin has " + eFour.HP + "HP.");
							room4();
					break;
					case 2:
						System.out.println("\n" + name + ": Yeah, the smart choice would be to push it down, it's not risky for me.");
						System.out.println("You push the boulder down and it continues to roll faster and faster, until it eventually hits the Doblin.");
						eFour.HP = eFour.HP - 2;
						System.out.println("The Doblin has " + eFour.HP + "HP.");
							room4();
					break;
					default:
						System.out.println("\nThat's not an option. Try again.");
							room4();
					break;
				}
			}
		}
		else {
			System.out.println("You defeated the " + eFour.species + ".");
			System.out.println("There is a path onwards to the Galcarres Grasslands. Either that or return to Fargo Forest.");
			System.out.println("\nWhere do you want to go?");
			System.out.println("----------------------------");
			System.out.println("1: Onwards to Galcarres Grasslands");
			System.out.println("2: Back to Fargo Forest");

			choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.println(name + ": Galcarres Grasslands sounds fun, let's do it!");
					room6();
					break;
				case 2:
					System.out.println(name + ": Back to Fargo Forest it is.");
					if (wTwo.status == true) {
						room22();
					}
					else {
						room2();
					}
				break;
				default:
					System.out.println("\nThat's not an option. Try again.");
						room4();
			}
		}
	}

	public void room5() {
		// Tuster Tundra
	}

	public void room6() {
		// Galcarres Grasslands
		if (eSix.HP>0)
			System.out.println("\nThe Grasslands were huge! The sunshine made the fields look even more majestic.");
			System.out.println("As you look around you see two chests lying in the middle of the field. You start to approach it but notice a Tarantos cirlcing and protecting it.");
			System.out.println("\nWhat weapon would you like to equip?");

			final String wpnName = scanner.nextLine();

			switch(wpnName) {
				case "dagger":
					if (wTwo.status==true) {
						System.out.println("EQUIPPED WEAPON: Dagger");
						wpnEqp = wTwo;
					}
					else {
						System.out.println("You don't have that weapon.");
							room6();
					}
				break;
				case "catapult":
					if (wThree.status==true) {
						System.out.println("EQUIPPED WEAPON: Catapult");
						wpnEqp = wThree;
					}
					else {
						System.out.println("You don't have that weapon.");
							room6();
					}
				break;
				case "katana":
					if (wTen.status==true) {
						System.out.println("EQUIPPED WEAPON: Katana");
						wpnEqp = wTen;
					}
					else {
						System.out.println("You don't have that weapon.");
							room6();
					}
				break;
				case "bow and arrow":
					if (wEleven.status==true) {
						System.out.println("EQUIPPED WEAPON: Bow and Arrow");
						wpnEqp = wEleven;
					}
					else {
						System.out.println("You don't have that weapon.");
							room6();
					}
				break;
				case "nothing":
					System.out.println("You don't equip a weapon.");
				break;
				default:
					System.out.println("You don't have a weapon called " + wpnEqp + ".");
						room6();
			}

			System.out.println("\nDo you approach?");
			System.out.println("----------------------------");
			System.out.println("1: Yes");
			System.out.println("2: No");

			choice = scanner.nextInt();

			if (choice==1) {
				System.out.println(name + ": That treasure looks like its worth my time, besides how difficult can this Tarantos be?");
				System.out.println("\nWhat do you do?");
				System.out.println("----------------------------");
				System.out.println("1: Charge in with your " + wpnEqp.type + ".");
				System.out.println("2: Sneak up and attack with your " + wpnEqp.type + ".");

				choice = scanner.nextInt();

				if (choice==1) {
					System.out.println("You run in screaming towards the Tarantos. It whips it head around in confusion and you hit the beast.");
					eSix.HP = eSix.HP - wpnEqp.dmg;
					System.out.println("The " + eSix.species + " now has " + eSix.HP + "HP.");
					System.out.println("It stumbles, but immediately bites back.");
					pHP = pHP - eSix.atck;
					System.out.println("You now have " + pHP + "HP.");
					System.out.println("You use your " + wpnEqp.type + " once again, dealing " + wpnEqp.dmg + " damage.");
					eSix.HP = eSix.HP - wpnEqp.dmg;
					System.out.println("The " + eSix.species + " now has " + eSix.HP + "HP.");
				}
				else if (choice==2) {
					System.out.println("You slowly approach the enemy to execture your sneak attack, but you accidentally step on a branch.");
					System.out.println("The Tarantos hears this and whips around while hissing and biting in your direction.");
				}

				/*if (wpnEqp==wpn2) {
					System.out.println("\nWhat do you do?");
					System.out.println("----------------------------");
					System.out.println("1: Run down the mountain and charge with your" + wpnEqp);
					System.out.println("2: Push the boulder in front of you");

					choice = scanner.nextInt();

					if (choice==1) {
						System.out.println("You charge down the mountain dagger in hand and you sneak attack the Doblin.");
						nmy4 = nmy4 - 1;
						System.out.println("The Doblin turns around in shock, picks up a spear and attacks you.");
						pHP = pHP - 1;
						System.out.println("You now have" + pHP + "HP.");
						System.out.println("You stab the Doblin again.");
						nmy4 = nmy4 - 1;
						System.out.println("The Doblin has " + nmy4 + "HP.");
							room4();
					}
					else if (choice==2) {
						System.out.println("\n" + name + ": Yeah, the smart choice would be to push it down, it's not risky for me.");
						System.out.println("You push the boulder down and it continues to roll faster and faster, until it eventually hits the Doblin.");
						nmy4 = nmy4 - 2;
						System.out.println("The Doblin has " + nmy4 + "HP.");
							room4();
					}
					else {
						System.out.println("\nThat's not an option. Try again.");
							room4();
					}
				}
				else {
					System.out.println("\nYou push the boulder down and it continues to roll faster and faster, until it eventually hits the Doblin.");
					nmy4 = nmy4 - 2;
					System.out.println("The Doblin has " + nmy4 + "HP.");
						room4();
				}*/
			}
			else if (choice==2) {

			}
			else {
				System.out.println("\nThat's not an option. Try again.");
					room6();
			}
		else {
			System.out.println("You finally defeated the "+ eSix.species + ".");
			System.out.println("As you slowly limp away from the beast, you decide which way to go, either back to where the Doblin was or to keep going towards the castle. ");
		}
	}

	public void room7() {
		//Shrewdale Savannah
	}

	public void room8() {
		//Paron Plains
	}

	public void room9() {
		//Aberdeen Alpines
	}

	public void room10() {
		//Wescroft Woodlands
	}

	public void room11() {
		//Dartis Desert
	}

	public void room12() {
		//Redboar Rainforest
	}

	public void room13() {
		//Bandicoot Bog
	}

	public void room14() {
		//Claren Cave
	}

	public void room15() {
		//Jester Jungle
	}

	public void bossRoom() {
		//The Final Boss
	}

	public void room22() {
		//Fargo Forest Chest Open
	}

	public void win() {
		
	}

public void defeated() {
	if (pHP==0) {
		System.out.println("\nGAME OVER");
	}
	else if (eFour.HP<=0) {
		System.out.println("\nYou defeated the " + eFour.species + ".");
	}
	else if (eSix.HP<=0) {
		System.out.println("\nYou defeated the " + eSix.species + ".");
	}
}

	/*public void peaceful() {
		System.out.println("You leave the town in peace.");
			crossroads();
	}
	
	public void guard() {
		System.out.println("1: Try attacking the guard again.");
		System.out.println("2: Back off.");
		
		choice = scanner.nextInt();

		if (choice==1) {
			System.out.println("Guard: Wanna go again?");
			System.out.println("The guard attacks and you lose 10HP.");
			pHP = pHP - 10;
			System.out.println("You now have " + pHP + "HP.");
		}
		else {
			System.out.println("You back off and walk away from the town.");
				crossroads();
		}
	}
	
	public void crossroads() {
		System.out.println("As you walk away from the town, you come across crossroads.");
		System.out.println("There are three ways do go. Which do you choose?");
		System.out.println("----------------------------");
		System.out.println("1: North, to the Fargo Forest.");
		System.out.println("2: East, to the Ligo Lake.");
		System.out.println("3: West, to the Meadow Mountains.");
		
		choice = scanner.nextInt();
		
		if (choice==1) {
			System.out.println(name + ": Okay, Fargo Forest it is.\n");
				forest();
		}
		else if (choice==2) {
			System.out.println(name + ": Okay, Ligo Lake it is.\n");
				lake();
		}
		else {
			System.out.println(name + ": Okay, Metra Mountains it is.");
				mountains();
		}
	}
	
	public void forest() {
		System.out.println("As you approach Fargo Forest, you see a campfire in a clearing.");
		System.out.println("A monster appears out of nowhere and is holding a spear.");
		System.out.println("\nWhat do you do?");
		System.out.println("----------------------------");
		System.out.println("1: Use your " + weaponOne);
		System.out.println("2: Use your " + weaponTwo);
		System.out.println("3: Use your " + weaponThree);
		
		choice = scanner.nextInt();
		
		if (choice==1) {
			fargonHP = fargonHP - 5;
			System.out.println("You got a hit, it did 5 damage. The monster now has " + fargonHP + "HP.");
			fargonHP = fargonHP - 5;
			System.out.println("You hit again. The monster now has " + fargonHP + "HP.");
		}
		else if (choice==2) {
			fargonHP = fargonHP - 2;
			System.out.println("You stab at the monster, it did 2 damage. The monster now has " + fargonHP + "HP.");
			System.out.println("The monster attacks you.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			fargonHP = fargonHP - 2;
			System.out.println("\nYou hit again. The monster now has " + fargonHP + "HP.");
			System.out.println("The monster takes a stab at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
		else {
			fargonHP = fargonHP - 1;
			System.out.println("You got a hit, it did 1 damage. The monster now has " + fargonHP + "HP.");
			System.out.println("The monster attacks you.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			fargonHP = fargonHP - 1;
			System.out.println("\nYou hit again. The monster now has " + fargonHP + "HP");
			System.out.println("The monster takes a stab at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
	}
	
	public void lake() {
		System.out.println("As you approach Ligo Lake, you see a small disturbance in the calm, still water.");
		System.out.println("A monster appears burst through the surface of the lake and spits jets of acid in your direction.");
		System.out.println("\nWhat do you do?");
		System.out.println("----------------------------");
		System.out.println("1: Use your " + weaponOne);
		System.out.println("2: Use your " + weaponTwo);
		System.out.println("3: Use your " + weaponThree);
		
		choice = scanner.nextInt();
		
		if (choice==1) {
			ligonHP = ligonHP - 1;
			System.out.println("You throw your dagger, it did 1 damage. The monster now has " + ligonHP + "HP.");
			System.out.println("A jet of acid hits you.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			ligonHP = ligonHP - 0;
			System.out.println("\nYou have no weapon and are now a sitting duck. The monster still has " + ligonHP + "HP.");
			System.out.println("The monster spits at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
		else if (choice==2) {
			ligonHP = ligonHP - 5;
			System.out.println("You shoot and it pierces the monster, it did 5 damage. The monster now has " + ligonHP + "HP.");
			ligonHP = ligonHP - 5;
			System.out.println("You aimed and shot. It hits again. The monster now has " + ligonHP + "HP.");
		}
		else {
			ligonHP = ligonHP - 0;
			System.out.println("You throw a punch, but the monster is too far away and so it does no damage. The monster still has " + ligonHP + "HP.");
			System.out.println("A jet of acid hits you.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			ligonHP = ligonHP - 1;
			System.out.println("\nYou try throwing a rock and it does 1 damage. The monster now has " + ligonHP + "HP.");
			System.out.println("The monster spits at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
	}
	
	public void mountains() {
		System.out.println("As you climb Metra Mountains, you see a monster down in the valley.");
		System.out.println("A boulder sits in front of you.");
		System.out.println("\nWhat do you do?");
		System.out.println("----------------------------");
		System.out.println("1: Use your " + weaponOne);
		System.out.println("2: Use your " + weaponTwo);
		System.out.println("3: Use your " + weaponThree);
		
		choice = scanner.nextInt();
		
		if (choice==1) {
			metranHP = metranHP - 0;
			System.out.println("You try to stab the boulder but it doesn't budge. The monster still has " + metranHP + "HP.");
			metranHP = metranHP - 0;
			System.out.println("You try stabbing the boulder again and this time you sprain your hand and you howl in pain.");
			System.out.println("The monster hears this noise and looks up. It sees you and shoots an arrow at you");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			System.out.println("\nYou throw the dagger at the monster with your good, but non-dominant, hand and miss, by a lot.");
			metranHP = metranHP - 0;
			System.out.println("The monster still has " + metranHP + "HP.");
			System.out.println("The monster shoots at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
		else if (choice==2) {
			metranHP = metranHP - 0;
			System.out.println("You shoot an arrow but miss by an inch. The monster still has " + metranHP + "HP.");
			System.out.println("The monster hears this noise and looks up. It sees you and shoots an arrow at you");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
			metranHP = metranHP - 0;
			System.out.println("\nYou aim again and let the arrow fly. It hits the monster and does 5 damage. The monster now has " + metranHP + "HP.");
			System.out.println("The monster reacts quickly and shoots at you again.");
			pHP = pHP - 10;
			System.out.println("\nYou have " + pHP + "HP.");
		}
		else {
			metranHP = metranHP - 10;
			System.out.println("You use your bare hands to slowly push the boulder down the mountain");
			System.out.println("The boulder rolls faster and faster down the hill and slams into the monster");
			System.out.println("It did 10 damage. The monster now has " + metranHP + "HP.");
		}
	}
	
	public static void victory() {
		System.out.println("You have been invited to dine with the royal family of Kandaro, for helping their town.");
		System.out.println("\nVICTORY");
	}*/
	
}