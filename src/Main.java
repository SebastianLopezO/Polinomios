import java.util.HashMap;
import java.util.Map;
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

        //Mapa de Variables
        Map<String, Polinomio> Variables = new HashMap<>();
        Variables.put("PolA", PolA);
        Variables.put("PolB", PolB);
        Variables.put("PolC", PolC);
        Variables.put("PolD", PolD);
        Variables.put("PolAns", PolAns);

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
                case "Operations":
                    break;
                case "Reset":
                    break;
                case "Exit":
                    app = false;
                    break;
            }
        }
    }

    public static String Menu(){
        String[] options = {"PolA",
                            "PolB",
                            "PolC",
                            "PolD",
                            "PolAns",
                            "Operations",
                            "Reset",
                            "Exit"
        };

        return option;
    }
}