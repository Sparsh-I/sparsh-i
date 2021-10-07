public class Enemy {
    String species;
    //int size;
    int HP;
    int atck;

	public Enemy(String species) {
		this.species = species;
    }
    
    /*public void nmySize(int nmySize) {
        size = nmySize;
    }*/

	public void nmyHP(int nmyHP) {
		HP = nmyHP;
    }
    
    public void nmyAtck(int nmyAtck) {
		atck = nmyAtck;
    }
}