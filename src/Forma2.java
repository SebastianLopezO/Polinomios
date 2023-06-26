public class Forma2 {
    private int[] Vec;

    public Forma2(int[] vec) {
        this.Vec = Disassemble(vec);
    }

    public int[] getVec() {
        return Vec;
    }

    public void setVec(int[] vec) {
        Vec = vec;
    }

    public int[] Disassemble(int[] data){
        int cont = getVec().length;
        int[] Vec = new int[cont+1];
        Vec[0] = cont;
        for (int i = 1; i < Vec.length; i++) {
            Vec[i]=data[i-1];
        }
        return Vec;
    }

    public int[] Assemble(int[] vec){
        int[] data = new int[vec.length-1];
        for (int i = 0; i < vec.length; i++) {
            data[i]=vec[i+1];
        }
        return vec;
    }

    public void Show() {
        for (int num : this.Vec) {
            System.out.print("[" + num + "]");
        }
        System.out.println();
    }

}
