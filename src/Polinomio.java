public class Polinomio {
    private String Pol;
    private int[] Vec;
    private Forma1 F1;
    private Forma2 F2;
    private Forma3 F3;
    private String Name,Method; //Atributos Extra para Impresion

    public Polinomio(String Name) {
        this.Pol = "";
        this.Vec = null;
        this.F1 = new Forma1();
        this.F2 = new Forma2();
        this.F3 = new Forma3();
        this.Name = Name;
        this.Method = "empty";
    }

    public Polinomio(String Pol, String Name) {
        this.Pol = Pol;
        this.Vec = Disassemble(Pol);
        this.F1 = new Forma1(this.Vec);
        this.F2 = new Forma2(this.Vec);
        this.F3 = new Forma3(this.Vec);
        this.Name = Name;
        this.Method = "empty";
    }

    public String getPol() {
        return Pol;
    }

    public void setPol(String pol) {
        this.Pol = pol;
    }

    public Forma1 getF1() {
        return F1;
    }

    public void setF1(Forma1 f1) {
        F1 = f1;
    }

    public Forma2 getF2() {
        return F2;
    }

    public void setF2(Forma2 f2) {
        F2 = f2;
    }

    public Forma3 getF3() {
        return F3;
    }

    public void setF3(Forma3 f3) {
        F3 = f3;
    }

    public int[] getVec() {
        return Vec;
    }

    public void setVec(int[] vec) {
        Vec = vec;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public void Define(String pol){
        this.Vec = Disassemble(pol);
        this.F1.Define(this.Vec);
        this.F2.Define(this.Vec);
        this.F3.Define(this.Vec);
    }

    public int[] Disassemble(String Pol) {
        String[] monomios = Pol.split("(?=([+-]))");
        int[] vec = new int[monomios.length * 2];
        String tx = "";
        System.out.println("\t" + "Partes: ");
        for (int i = 0; i < monomios.length; i++) {
            String[] parts = monomios[i].replaceAll("\\s+", "").split("(?=([xX]\\^?))");
            if (parts.length == 1) {
                //Coeficiente
                if (parts[0].contains("x^")) {
                    vec[i * 2] = 1;
                    vec[i * 2 + 1] = Integer.parseInt(parts[0].toLowerCase().replace("x^", ""));
                } else if (parts[0].contains("x")) {
                    vec[i * 2] = 1;
                    vec[i * 2 + 1] = 1;
                } else if (parts[0].matches("\\d+") || parts[0].matches("[+-]\\d+")) {
                    vec[i * 2] = Integer.parseInt(parts[0]);
                    vec[i * 2 + 1] = 0;
                }
                tx = parts[0];
            } else if (parts.length == 2) {
                //Coeficiente
                if (parts[0].matches("\\d+") || parts[0].matches("[+-]\\d+")) {
                    vec[i * 2] = Integer.parseInt(parts[0]);
                } else if (parts[0].matches("[+-]")) {
                    if (parts[0].contains("+")) {
                        vec[i * 2] = 1;
                    } else {
                        vec[i * 2] = -1;
                    }
                }

                //Exponente
                if (parts[1].matches("^[xX]\\^\\d+$")) {
                    vec[i * 2 + 1] = Integer.parseInt(parts[1].toLowerCase().replace("x^", ""));
                } else if (parts[1].contains("x") || parts[1].contains("X")) {
                    vec[i * 2 + 1] = 1;
                }
                tx = parts[0] + "/" + parts[1];
            }
            System.out.println("\t• " + monomios[i] + ": " + tx);
        }
        return vec;
    }

    public String Assemble(int[] Vec) {
        String polinomio = "";
        System.out.println("\t" + "Vector: ");
        for (int i = 0; i < Vec.length; i += 2) {
            String parts = "";
            //Coeficiente
            if (Vec[i] != 1 && Vec[i] != -1 && Vec[i] != 0) {
                if (Vec[i] > 0 && i != 0) {
                    parts += "+ " + Vec[i];
                } else if (Vec[i] > 0) {
                    parts += Vec[i];
                } else if (i != 0) {
                    parts += "- " + Math.abs(Vec[i]);
                } else {
                    parts += Vec[i];
                }

            } else if (Vec[i] == 1 && Vec[i + 1] == 0 && i != 0) {
                parts += "+ 1";
            } else if (Vec[i] == 1 && Vec[i + 1] == 0) {
                parts += "1";
            } else if (Vec[i] == 1 && i != 0) {
                parts += "+ ";
            } else if (Vec[i] == -1 && Vec[i + 1] == 0) {
                parts += "- 1";
            } else if (Vec[i] == -1 && i != 0) {
                parts += "- ";
            } else if (Vec[i] == -1) {
                parts += "-";
            }


            //Exponente
            if (Vec[i] != 0) {
                if (Vec[i + 1] == 1) {
                    parts += "x";
                } else if (Vec[i + 1] != 0) {
                    parts += "x^" + Vec[i + 1];
                }
            }
            polinomio += parts + " ";
            System.out.println("\t• [" + Vec[i] + "|" + Vec[i + 1] + "] : " + parts);
        }
        return polinomio;
    }

    public void Show(){
        System.out.println("Forma 1:");
        System.out.println(Assemble(this.F1.Assemble()));
        System.out.println("Forma 2:");
        System.out.println(Assemble(this.F2.Assemble()));
        System.out.println("Forma 3:");
        System.out.println(Assemble(this.F3.Assemble()));
    }
}
