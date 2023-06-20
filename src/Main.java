import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String polinomio = sc.nextLine();
        String[] monomios = polinomio.split("(?=([+-]))");
        for (String mon : monomios) {
            System.out.print(mon + ": ");
            String[] parts = mon.split("([xX]\\^?)");
            for (String pt : parts) {
                System.out.print(pt + " ");
            }
            System.out.println();
        }
    }
}