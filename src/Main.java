import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String polinomio = sc.nextLine();
        Polinomio POL1 = new Polinomio(polinomio);
        System.out.println(POL1.Assemble(POL1.Disassemble(polinomio)));
    }
}