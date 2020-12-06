package RPG_Game;

import java.util.Scanner;

	public class Main_Game {
		
		static Player player = null;
		
		private static void quickMenu() {			//Choix personnage
			
			@SuppressWarnings("resource")
			Scanner choosePlayer = new Scanner(System.in);
			System.out.println("A : Choose your player : \n\t1. Wizard \n\t2. Liche \n\t3. Zombie \n\t4. Elfe");
			System.out.println("please enter a number : \n");
			String input = choosePlayer.nextLine();
			
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") ) {
				System.out.println("Wrong number ! ");
				System.out.println("please enter a number (1-4) :");
				input = choosePlayer.nextLine();
			} 

			System.out.println("Here is the information about your hero : \n");

			if (input.equals("1")) {
				player = new Player("Wizard");
				player.information_W();
			}
			else if (input.equals("2")) {
				player = new Player("Liche");
				player.information_L();
			}
			else if (input.equals("3")) {
				player = new Player("Zombie");
				player.information_Z();
			}
			else if (input.equals("4")) {
				player = new Player("Elfe");
				player.information_E();
				
			}
		}
		
		
		public static void main(String[] args) {
		
		System.out.println("======================================");
		System.out.println("Welcome to RPG game Created by Dalinda ALOUI");
		System.out.println("======================================");
		
		quickMenu();	//Choix personnage
		
		System.out.println("\n ====================================== \n");
		// Creation de la map 2D
		Map_2D map = new Map_2D(15,15);
		
		map.move(15,1,'P');
		//on place le joueur en bas a gauche et les monstres et obstacles aléatoirement 
		for (int i=0; i<15; i++) {
			
			int lm = (int) (Math.random() * (15 - 1) + 1);
			int cm = (int) (Math.random() * (15 - 1) + 1);
			map.move(lm,cm,'M');
		
			int lo = (int) (Math.random() * (15 - 1) + 1);
			int co = (int) (Math.random() * (15 - 1) + 1);
			map.move(lo,co,'O');
		}
		
		map.move(15,1,'P');
		
		System.out.println("Let's start ! \n");
		System.out.println("P = Player");
		System.out.println("O = Obstacle");
		System.out.println("M = Monster");
		System.out.println("- = Empty \n");
		System.out.println(" \n To win this game you have to go to the top right ! GOOD LUCK !!");
		map.display();
		
		//Menu de choix 
		
		@SuppressWarnings("resource")
		Scanner choice = new Scanner(System.in);
		System.out.println("\nB : What would you like to do ?");
		System.out.println("\t1. Move direction");
		//System.out.println("\t2. Buy a weapon");

		
		String input1 = choice.nextLine();
		
		while (!input1.equals("1") && !input1.equals("2")){
			System.out.println("Wrong number ! ");
			System.out.println("please enter a number (1-2) :");
			input1 = choice.nextLine();
		} 
		
		//achat armes 
		/*if (input1.equals("2")) {
			System.out.println("what kind of weapon you want ? (k : knife / g : gun / h : hammer) ");
			input1 = choice.nextLine().toLowerCase () ;
			switch (input1) {
			case "k" : player.addToInventory("knife");	
			player.showInventory();
			break;
			
			case "g" : player.addToInventory("gun");
			player.showInventory();
			break;
			
			case "h" : player.addToInventory("hammer");
			player.showInventory();
			break;
			}
		}*/
		
		//choix de déplacement
			int i=0;
			while(i<100) {
				System.out.println("Where you want to move ?");
				System.out.println("please enter a direction (f = front, b = back, r = right, l = left) ,(other = o) :");
				
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				String direction = (sc.nextLine()).toLowerCase ();
				
				while (!direction.equals("f") && !direction.equals("b") && !direction.equals("r") && !direction.equals("l") && !direction.equals("o")) {
				System.out.println("Wrong direction ! ");
				System.out.println("please enter a direction : (f = front, b = back, r = right, l = left) or (o : other)");
					
					direction = (sc.nextLine()).toLowerCase () ;			 
				} 
				
				if(direction.equals("f")) {
					map.movementF();
					if (map.movementF() == 1);
					else if (map.movementF() == 2) { //s'il ya un monstre
						   System.out.println("What do you want to do ?(a = attack, r = run away)");
						   String direction1 = (sc.nextLine()).toLowerCase () ;	
						   if (direction1.equals("a")){
								System.out.println("Start fight ! ");
								player.fight();
								player.experience();
								player.information_E();
						   }
					}
					else if (map.movementF() == 3) {	//s'il ya un  obstacle
						   System.out.println("There is an obstacle, please choose another direction : (f = front, b = back, r = right, l = left)");
						   direction = sc.nextLine().toLowerCase () ;	
					}
					
				}
				if(direction.equals("b")) {
					 map.movementB(); 
					 if (map.movementB() == 1);
					 
					 else if (map.movementB() == 2) {
						 System.out.println("What do you want to do ?(a = attack, r = run away)");
						   String direction1 = (sc.nextLine()).toLowerCase () ;	
						   if (direction1.equals("a")){
								System.out.println("Start fight ! ");
								player.fight();
								player.experience();
								player.information_E();
						   }
					   }
					   else if (map.movementB() == 3) {
						   System.out.println("There is an obstacle, please choose another direction : (f = front, b = back, r = right, l = left) ");
						   direction = sc.nextLine().toLowerCase () ;	
					   };
				}
				
				if(direction.equals("l")) {
					map.movementL();
					if (map.movementL() == 1) ; 
					   else if (map.movementL() == 2) {
						   System.out.println("What do you want to do ?(a = attack, r = run away)");
						   String direction1 = (sc.nextLine()).toLowerCase () ;	
						   if (direction1.equals("a")){
								System.out.println("Start fight ! ");
								player.fight();
								player.experience();
								player.information_E();
						   }
					   }
					   else if (map.movementL() == 3) {
						   System.out.println("There is an obstacle, please choose another direction : (f = front, b = back, r = right, l = left)");
						   direction = sc.nextLine().toLowerCase () ;	
					   };
				}
				if(direction.equals("r")) {
					map.movementR();
					if (map.movementR() == 1) ; 
					   else if (map.movementR() == 2) {
						   System.out.println("What do you want to do ?(a = attack, r = run away)");
						   direction = sc.nextLine().toLowerCase () ;	
						   System.out.println("Start fight ! ");
						   player.fight();
						   player.information_E();
					   }
					   else if (map.movementR() == 3) {
						   System.out.println("There is an obstacle, please choose another direction : (f = front, b = back, r = right, l = left)");
						   direction = sc.nextLine().toLowerCase () ;	
					   };
				}
				if(direction.equals("o")) {
						@SuppressWarnings("resource")
						Scanner choice1 = new Scanner(System.in);
						System.out.println("\nB : What would you like to do ?");
						System.out.println("\t1. Buy a weapon");
						System.out.println("\t2. move direction");
						System.out.println("\t3. See information about your hero");
						
						String input2 = choice1.nextLine().toLowerCase () ;
						
						while (!input2.equals("1") && !input2.equals("2") && !input2.equals("3")){
							System.out.println("Wrong number ! ");
							System.out.println("please enter a number (1-3) :");
							input2 = choice1.nextLine();
						} 
						
						
						if (input2.equals("1")) {
							System.out.println("What kind of weapon you want ? (k : knife / g : gun / h : hammer) ");
							input2 = choice1.nextLine().toLowerCase () ;
							
							switch (input2) {
								case "k" : player.addToInventory("knife");	
								player.showInventory();
								break;
								
								case "g" : player.addToInventory("gun");
								player.showInventory();
								break;
								
								case "h" : player.addToInventory("hammer");
								player.showInventory();
								break;
								}
						}
						else if (input2.equals("2")) {
							System.out.println("Continue your adventure !");
						}
						else if (input2.equals("3")) {
							player.information_E();
							for (int j=0; j<100; j++) {
								System.out.println();
							}
						}
				}
				
				/*for (int j=0; j<100; j++) {
					System.out.println();
				}*/
				
				System.out.println("To win this game you have to go to the top right ! GOOD LUCK !!");
				map.display();
				i++;
			}
	}
}

