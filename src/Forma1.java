public class Forma1 {
    private int[] Vec;

    public Forma1(int[] vec) {
        this.Vec = Disassemble(vec);
    }

    public int[] getVec() {
        return Vec;
    }

    public void setVec(int[] vec) {
        Vec = vec;
    }

    public int[] Disassemble(int[] data) {
        int grade = Grade(data);
        int[] Vec = new int[grade + 2];
        Vec[0] = grade;
        for (int i = 1; i < Vec.length; i++) {
            for (int j = 1; j < data.length; j += 2) {
                if (data[j] == (grade - i + 1)) {
                    Vec[i] += data[j - 1];
                }
            }
        }
        return Vec;
    }

    public int[] Assemble() {
        int grade = Vec[0];
        int[] data = new int[(grade + 1) * 2];
        for (int i = 1; i < Vec.length; i++) {
            data[i * 2 - 1] = grade - i + 1;
            data[i * 2 - 2] = Vec[i];
        }
        return data;
    }

    public int Grade(int[] data) {
        int max = 0;
        for (int i = 1; i < data.length; i += 2) {
            max = Math.max(data[i], max);
        }
        return max;
    }

    public void Show() {
        for (int num : this.Vec) {
            System.out.print("[" + num + "]");
        }
        System.out.println();
    }

}
