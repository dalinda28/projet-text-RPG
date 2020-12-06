package RPG_Game;

public class Map_2D {
	
	private int nbLin;
	private int nbCol;
	private char [][] map;
	
	public Map_2D(int n, int p){
		nbLin = n;
		nbCol = p;
		map = new char[nbLin][nbCol];
		
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				map[i][j] = '_';
			}
		
		}
	}
	
	public void display(){	
		System.out.println();
		
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				System.out.print("|" + map[i][j]);
			}
			
			System.out.println("|");
		}
			System.out.println();
	}
	
	
	public void move(int l, int c, char t) {	//placement des objets (P)
		l = l-1;
		c = c-1;
		
		//Test si on se trouve sur la map ou pas
		if (l < 0 || c < 0 || l > nbLin || c > nbCol) {
			System.out.println("Error placement! " + nbLin + nbCol);
			return;
		}
		
		if (map[l][c] == '_') 
			map[l][c] = t;
	}
	
	public int movementF() { //Deplacement vers le haut
		char tmp;
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				if (map[i][j] == 'P') {		//on cherche player
					if (i-1 >= 0 && map[i-1][j] == '_') {
						tmp = map[i][j];
						map[i][j] = '_';
						map[i-1][j] = tmp;
						return 1;
					}
					
					//s'il y a un monstre 
					if (i-1 >= 0 && map[i-1][j] == 'M') {
						System.out.println("OMG !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i-1][j] = tmp;*/
						return 2;
					}
					
					if (i-1 >= 0 && map[i-1][j] == 'O') {
						System.out.println("STOP !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i-1][j] = tmp;*/
						return 3;
					}
				}
			}
		}
		return 0;
	}
	
	public int movementB() { //Deplacement vers le bas
		char tmp;
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				if (map[i][j] == 'P') {		//on cherche player
					if (i+1 <= nbLin && map[i+1][j] == '_') {
						tmp = map[i][j];
						map[i][j] = '_';
						map[i+1][j] = tmp;
						return 1;
					}
					
					//s'il y a un monstre 
					if (i-1 >= 0 && map[i+1][j] == 'M') {
						System.out.println("OMG !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i+1][j] = tmp;*/
						return 2;
					}
					//s'il y a un obstacle 
					if (i-1 >= 0 && map[i+1][j] == 'O') {
						System.out.println("STOP !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i+1][j] = tmp;*/
						return 3;
					}
				}
			}
		}
		return 0;
	}
	public int movementL() {  //Deplacement a gauche
		char tmp;
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				if (map[i][j] == 'P') {		//on cherche player
					if (j-1 >= 0 && map[i][j-1] == '_') {  	//si la cas est sup a 0 et quel contienne _ : on cherche player
						tmp = map[i][j];
						map[i][j] = '_';
						map[i][j-1] = tmp;
						return 1;
					}
					//s'il y a un monstre 
					if (i-1 >= 0 && map[i-1][j] == 'M') {
						System.out.println("OMG !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i][j-1] = tmp;*/
						return 2;
					}
					//s'il y a un obstacle 
					if (i-1 >= 0 && map[i-1][j] == 'O') {
						System.out.println("Stop !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i][j-1] = tmp;*/
						return 3;
					}
				}
			}
		}
		return 0;
	}
	public int movementR() {  //Deplacement à droite
		char tmp;
		for (int i=0; i<nbLin; i++) {
			for (int j=0; j<nbCol; j++) {
				if (map[i][j] == 'P') {		//on cherche player
					if (j+1 <= nbCol && map[i][j+1] == '_') {
						tmp = map[i][j];
						map[i][j] = '_';
						map[i][j+1] = tmp;
						break;
					}

					//s'il y a un monstre 
					if (i-1 >= 0 && map[i][j+1] == 'M') {
						System.out.println("OMG !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i][j+1] = tmp;*/
						return 2;
					}
					//s'il y a un obstacle 
					if (i-1 >= 0 && map[i][j+1] == 'O') {
						System.out.println("Stop !");
						/*tmp = map[i][j];
						map[i][j] = '_';
						map[i][j+1] = tmp;*/
						return 3;
					}
				}
			}
		}
	return 0;
	}	
}
