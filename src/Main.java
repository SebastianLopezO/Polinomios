import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean app=true, appPol=true;
        String option;

        Polinomio PolA = new Polinomio();
        Polinomio PolB = new Polinomio();
        Polinomio PolC = new Polinomio();
        Polinomio PolD = new Polinomio();
        Polinomio PolAns = new Polinomio();

        while(app){
            option = Menu();

            switch (option){
                case "PolA":
                    break;
                case "PolB":
                    break;
                case "PolC":
                    break;
                case "PolD":
                    break;
                case "PolAns":
                    break;
                case "Operaciones":
                    break;
                case "Resetear":
                    break;
                case "Salir":
                    app = false;
                    break;
            }
        }
    }

    public static String Menu(){
        String[] options = {""};
    }
}