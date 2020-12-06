package RPG_Game;

public class Player {
	    Inventory inv = new Inventory(20);
	    int health;
	    int attack;
	    int luck;
	    int speed;
	    int speech;
	    String name;
	    int experience;
	    int level;
	    int maxHealth;

	    public Player(String name) {
	        this.name = name;
	        this.health = 10;
	        this.attack = 10;
	        this.luck = 10;
	        this.speech = 10;
	        this.speed = 10;
	        experience = 0;
	        level = 1;
	        maxHealth = 10;
	    }
	    public void information_W(){
	        System.out.println("\tHero name: " + this.name + "\n\tHero level: " + this.level  + "\n\tHero health: " + this.health + 10);
	        System.out.print("\t" + this.experience + 1 + "/" + (this.level*200) + " experience");
	        System.out.print("\t");
	        showInventory();
	    }
	    public void information_L(){
	        System.out.println("\tHero name: " + this.name + "\n\tHero level: " + this.level + 2 + "\n\tHero health: " + this.health + 6);
	        System.out.print("\t" + this.experience + 5 + "/" + (this.level*200) + " experience");
	        System.out.print("\t");
	        showInventory();
	    }
	    public void information_Z(){
	        System.out.println("\tHero name: " + this.name + "\n\tHero level: " + this.level + 3 + "\n\tHero health: " + this.health + 15);
	        System.out.print("\t" + this.experience + 3 + "/" + (this.level*200) + " experience");
	        System.out.print("\t");
	        showInventory();
	    }
	    public void information_E(){
	        System.out.println("\tHero name: " + this.name + "\n\tHero level: " + this.level + 4 + "\n\tHero health: " + this.health + 30);
	        System.out.print("\t" + this.experience + 3 + "/" + (this.level*200) + " experience");
	        System.out.print("\t");
	        showInventory();
	    }

	    public void addToInventory(String item) {
	        inv.addToInventory(item);
	    }

	    public void showInventory() {
	        inv.showInventory();
	    }

	    public void fight() {
	        this.health -= 1;
	        if (this.health == 0) {
	            System.out.println(this.name + " has died.\n");
	        }
	    }

	    public void rest() {
	        System.out.println(this.name + " lies down in the sun and rests for a bit. He feels how his energy slowly regenerates.\n");
	        this.health = maxHealth;
	    }

	    public void experience() {
	        experience += 2;
	        if (experience == (this.level * 10)) {
	            System.out.println(this.name + " has leveled up!");
	            level += 1;
	            experience = 0;
	            maxHealth += 5;
	            this.health = maxHealth;
	        }
	    }
    
    
}
