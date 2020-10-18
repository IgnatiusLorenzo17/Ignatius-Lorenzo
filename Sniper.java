public class Sniper extends Weapon {
    private String Scope;
    public Sniper(String nama, String type, String namasenjata, int ammo, String Scope) {
        super(nama, type, namasenjata, ammo);
        this.Scope = Scope;
    }


    public String getScope() {
        return Scope;
    }


    public void setScope(String scope) {
        Scope = scope;
    }


}
