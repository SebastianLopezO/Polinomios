public class Forma2 {
    private int[] Vec;

    public Forma2(int[] vec) {
        this.Vec = Disassemble(vec);
    }
    public Forma2() {
        this.Vec = null;
    }

    public int[] getVec() {
        return Vec;
    }

    public void setVec(int[] vec) {
        Vec = vec;
    }

    public void Define(int[] vec){
        this.Vec = Disassemble(vec);
    }

    public int[] Disassemble(int[] data) {
        int cont = data.length;
        int[] Vec = new int[cont + 1];
        Vec[0] = cont/2;
        for (int i = 1; i < Vec.length; i++) {
            Vec[i] = data[i - 1];
        }
        return Vec;
    }

    public int[] Assemble() {
        int monomios = Vec[0];
        int[] data = new int[monomios*2];
        for (int i = 1; i < Vec.length; i++) {
            data[i-1] = Vec[i];
        }
        return data;
    }

    public void Show() {
        for (int num : this.Vec) {
            System.out.print("[" + num + "]");
        }
        System.out.println();
    }

}
