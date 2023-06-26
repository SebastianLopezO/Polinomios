public class Forma3 {
    private Nodo Punta;

    public Forma3() {
        Punta = null;
    }

    public Forma3(int[] vec) {
        Disassemble(vec);
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    public void Disassemble(int[] data) {
        for (int i = 0; i < data.length; i += 2) {
            Insert(data[i], data[i + 1]);
        }
    }

    public int[] Assemble() {
        int[] data = new int[Len() * 2];
        int pos = 0;
        Nodo aux = Punta;
        while (aux != null) {
            data[pos * 2] = aux.getCoe();
            data[pos * 2 + 1] = aux.getExp();
            aux = aux.getLiga();
        }
        return data;
    }

    public void Insert(int coe, int exp) {
        Nodo P = new Nodo(coe, exp);
        if (Punta == null) {
            Punta = P;
        } else {
            Nodo aux = Punta;
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            aux.setLiga(P);
        }
    }

    public int Len() {
        int count = 0;
        Nodo aux = Punta;
        while (aux != null) {
            count++;
            aux = aux.getLiga();
        }
        return count;
    }

    public void Show() {
        Nodo aux = Punta;
        while (aux != null) {
            System.out.print("[" + aux.getCoe() + "|" + aux.getExp() + "|" + aux.getLiga() + "] -> ");
            aux = aux.getLiga();
        }
        System.out.println();
    }
}
