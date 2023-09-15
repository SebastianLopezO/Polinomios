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

    public void Define(int[] vec){
        Disassemble(vec);
    }

    public void Disassemble(int[] data) {
        for (int i = 0; i < data.length; i += 2) {
            InsertOrder(data[i], data[i + 1]);
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
            pos +=1;
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

    public void InsertStart(int coe, int exp) {
        Nodo X = new Nodo(coe, exp);
        if (this.Punta == null) {
            this.Punta = X;
        } else {
            X.setLiga(this.Punta);
            this.Punta = X;
        }
    }

    public void InsertEnd(int coe, int exp) {
        Nodo X = new Nodo(coe, exp);

        if (this.Punta == null) {
            this.Punta = X;
        } else {
            Nodo P = this.Punta;
            while (P.getLiga() != null) {
                P = P.getLiga(); //Avance de Liga
            }
            P.setLiga(X);
        }

    }

    public void InsertOrder(int coe, int exp) {
        Orderby();
        if (this.Punta == null) {
            InsertEnd(coe, exp);
        } else if (this.Punta.getExp() > exp) {
            InsertStart(coe, exp);
        } else {
            Nodo P = this.Punta;
            Boolean Find = true;
            while (P != null && Find) {
                if (P.getExp() <= exp && P.getLiga() == null) {
                    InsertEnd(coe, exp);
                    Find = false;
                } else if (P.getExp() <= exp && (P.getLiga()).getExp() >= exp) {
                    Nodo X = new Nodo(coe, exp);
                    X.setLiga(P.getLiga());
                    P.setLiga(X);
                    Find = false;
                }
                P = P.getLiga();
            }
        }
        Orderby();
    }

    public void Orderby() {
        if (this.Punta != null) { //Si esta vacia
            if (this.Punta.getLiga() != null) {//Si solo tiene un Elemento
                for (int K = 0; K < Len(); K++) {
                    Nodo A = null, P = this.Punta, S = P.getLiga();
                    while (S != null) {
                        if (P.getExp() < S.getExp()) {
                            if (P == Punta) {
                                Punta = S;
                            } else {
                                A.setLiga(S);
                            }
                            P.setLiga(S.getLiga());
                            S.setLiga(P);
                            A = S;
                            S = P.getLiga();
                        } else {
                            A = P;
                            P = S;
                            S = S.getLiga();
                        }
                    }
                }
            }
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
