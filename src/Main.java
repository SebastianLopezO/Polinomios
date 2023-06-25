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
                "6x^5 + 5x^4 - 4x^3 + 3x^2 - 2x + 1"
        };
        for (String polinomio : polinomios) {
            Polinomio POL1 = new Polinomio();
            System.out.println(polinomio);
            System.out.println(POL1.Assemble(POL1.Disassemble(polinomio)));
            System.out.println();
        }

    }
}