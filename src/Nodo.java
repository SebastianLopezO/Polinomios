public class Nodo {
    private int Coe;
    private int Exp;
    private Nodo Liga;

    public int getCoe() {
        return Coe;
    }

    public void setCoe(int coe) {
        Coe = coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }

    public Nodo(int coe, int exp) {
        this.Coe = coe;
        this.Exp = exp;
        this.Liga = null;
    }
    public Nodo(int coe, int exp, Nodo liga) {
        this.Coe = coe;
        this.Exp = exp;
        this.Liga = liga;
    }
    public Nodo() {
        this.Coe = 0;
        this.Exp = 0;
        this.Liga = null;
    }


}
