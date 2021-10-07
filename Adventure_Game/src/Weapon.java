public class Weapon {
    String type;
    int dmg;
   //int rng;
    boolean status;

	public Weapon(String type) {
		this.type = type;
    }
    
    public void wpnDmg(int wpnDmg) {
        dmg = wpnDmg;
    }

	/*public void wpnRng(int wpnRng) {
		rng = wpnRng;
    }*/

    public void wpnStatus(boolean wpnStatus) {
        status = wpnStatus;
    }
}
