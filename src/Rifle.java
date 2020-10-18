public class Rifle  extends Weapon{
    private String Artype;

    public Rifle(String nama, String type, String namasenjata, int ammo, String Artype) {
        super(nama, type, namasenjata, ammo);
        this.Artype = Artype;
    }

    public String getArtype() {
        return Artype;
    }
    public void setArtype(String artype) {
        Artype = artype;
    }



}
