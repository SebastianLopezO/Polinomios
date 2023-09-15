import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean app=true, appPol=true;
        String optionVal, optionAction, optionShow, optionOpe;

        Polinomio PolA = new Polinomio("PolA");
        Polinomio PolB = new Polinomio("PolB");
        Polinomio PolC = new Polinomio("PolC");
        Polinomio PolD = new Polinomio("PolD");
        Polinomio PolAns = new Polinomio("PolAns");

        //Mapa de Variables
        Map<String, Polinomio> Variables = new HashMap<>();
        Variables.put("PolA", PolA);
        Variables.put("PolB", PolB);
        Variables.put("PolC", PolC);
        Variables.put("PolD", PolD);
        Variables.put("PolAns", PolAns);

        //Puntero
        Polinomio P = null;

        while(app){
            appPol = true;
            optionVal = MenuVal();

            switch (optionVal){
                case "PolA":
                    P = PolA;
                    break;
                case "PolB":
                    P = PolB;
                    break;
                case "PolC":
                    P = PolC;
                    break;
                case "PolD":
                    P = PolD;
                    break;
                case "PolAns":
                    P = PolAns;
                    break;
                case "Operacion entre Polinomios":
                    appPol = false;
                    break;
                case "Vaciar Polinomios":
                    appPol = false;
                    break;
                case "Salir":
                    app = false;
                    appPol = false;
                    break;
            }

            while (appPol){
                optionAction = MenuAction();
                switch (optionAction){
                    case "Definir":
                        String pol = JOptionPane.showInputDialog("Ingrese el polinomio a definir: ");
                        P.Define(pol);
                        break;
                    case "Agregar":
                        System.out.println("Has elegido Agregar.");
                        break;
                    case "Multiplicar":
                        System.out.println("Has elegido Multiplicar.");
                        break;
                    case "Dividir":
                        System.out.println("Has elegido Dividir.");
                        break;
                    case "Evaluar":
                        System.out.println("Has elegido Evaluar.");
                        break;
                    case "Mostrar":
                        P.Show();
                        break;
                    case "Vaciar":
                        System.out.println("Has elegido Vaciar.");
                        break;
                    case "Volver":
                        appPol = false;
                        break;
                }
            }
        }
    }

    public static String MenuVal(){
        String[] Options = {"PolA",
                            "PolB",
                            "PolC",
                            "PolD",
                            "PolAns",
                            "Operacion entre Polinomios",
                            "Vaciar Polinomios",
                            "Salir"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Menu ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuAction() {
        String[] Options = {
                "Definir",
                "Agregar",
                "Multiplicar",
                "Dividir",
                "Evaluar",
                "Mostrar",
                "Vaciar",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Menu ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String[] MenuOpe() {
        JComboBox<String> Var1 = new JComboBox<>(new String[]{"PolA", "PolB", "PolC", "PolD"});
        JComboBox<String> Var2 = new JComboBox<>(new String[]{"PolA", "PolB", "PolC", "PolD"});
        JComboBox<String> Ope = new JComboBox<>(new String[]{"+", "-", "*", "/", "=="});

        Object[] msj = {Var1, Ope, Var2};
        JOptionPane.showConfirmDialog(null, msj, "Operacion a realizar:", JOptionPane.DEFAULT_OPTION);
        String[] Option = {(String) Var1.getSelectedItem(), (String) Ope.getSelectedItem(), (String) Var2.getSelectedItem()};
        return Option;
    }

    public static String MenuShow() {
        String[] Options = {
                "Consola",
                "Panel",
                "Web"
        };
        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una Opcion: ",
                "Mostrar ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    //Método para obtener los valores
    public static int GetNum(String Option) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero a "+Option+ ": "));
                return num;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se ha insertado un numero.");
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }
}