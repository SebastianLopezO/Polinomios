import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] polinomios = {
                "x+205+x-18x^4-5x^3+12x+203+x",
                "3x^2 + 2x + 1",
                "x^3 - 5x^2 + 4x - 3",
                "2x^4 + 3x^3 - 6x^2 + x + 2",
                "5x^2 - 7x + 10",
                "x^5 + x^4 + x^3 + x^2 + x + 1",
                "-2x^3 + 4x^2 - 6x + 8",
                "x^2 - 4x + 7",
                "4x^4 - 3x^2 + 2x - 1",
                "-x^3 + 3x^2 - 2x + 1",
                "6x^5 + 5x^4 - 4x^3 + 3x^2 - 2x + 1",
                "1+10x^2+20x^3"
        };
        for (String polinomio : polinomios) {
            System.out.println("Polinomio: "+polinomio);
            Polinomio POL = new Polinomio(polinomio);
            System.out.println();
            System.out.println(Clr.G+"Forma 1: ");
            POL.getF1().Show();
            System.out.println("Forma 1 a Polinomio: "+POL.Assemble(POL.getF1().Assemble())+"\n"+Clr.RT);
            System.out.println(Clr.B+"Forma 2: ");
            POL.getF2().Show();
            System.out.println("Forma 2 a Polinomio: "+POL.Assemble(POL.getF2().Assemble())+"\n"+Clr.RT);
            System.out.println(Clr.R+"Forma 3: ");
            POL.getF3().Show();
            System.out.println("Forma 3 a Polinomio: "+POL.Assemble(POL.getF3().Assemble())+"\n"+Clr.RT);
            System.out.println("----------------------------------------------");
        }

    }
}