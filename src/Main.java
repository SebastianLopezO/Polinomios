import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String polinomio = sc.nextLine();
        //polinomio = "x+205+x-18x^4-5x^3+12x+203+x";
        Polinomio POL1 = new Polinomio(polinomio);
        System.out.println(POL1.Assemble(POL1.Disassemble(polinomio)));
    }
}