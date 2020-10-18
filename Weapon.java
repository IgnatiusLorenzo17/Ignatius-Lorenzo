public  class Weapon {
    private String nama;
    private String type;
    private String namasenjata;
    private int ammo;

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getNamasenjata() {
        return namasenjata;
    }
    public void setNamasenjata(String namasenjata) {
        this.namasenjata = namasenjata;
    }
    public int getAmmo() {
        return ammo;
    }
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
    public Weapon(String nama, String type, String namasenjata, int ammo) {
        super();
        this.nama = nama;
        this.type = type;
        this.namasenjata = namasenjata;
        this.ammo = ammo;
    }

}
