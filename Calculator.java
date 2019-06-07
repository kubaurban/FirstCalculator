package interfaces.project_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Double> values;
    private Double M;

    public Calculator() {
        values = new ArrayList<>();
        M = (double) 0;
    }
    public List<Double> getValues() {
        return values;
    }
    public void clear(){values.clear();}
    public Double getValue(int i) {
        return values.get(i);
    }
    public Double getM() {
        return M;
    }
    public void addM(Double M) {
        this.M = this.M + M;
    }
    public void subM(Double M) {
        this.M = this.M - M;
    }
    public void giveValue() {
        System.out.println("Wprowadź wartość");
        Scanner scan = new Scanner(System.in);
        try {
            values.add(scan.nextDouble());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Błędna wartość");
            giveValue();
        }
    }
    public void getResult(Computation comput){
        Double result = comput.compute(getValue(0), getValue(1));
        System.out.println("Wynik: " + result + "\n");
        clear();
        getValues().add(result);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Computation comput;
        calc.giveValue();
        String operator;
        do {
            System.out.println("Wybierz opcję:" + "\n" +
                    "  dodawanie     +" + "\n" +
                    "  odejmowanie   -" + "\n" +
                    "  mnożenie      *" + "\n" +
                    "  dzielenie     /" + "\n" +
                    "  pierwiastek   sqrt"+ "\n" +
                    "  M             M" + "\n" +
                    "  dodaj do M    M+"+ "\n" +
                    "  odejmij od M  M-"+ "\n" +
                    "  Usuń pamięć   CE"+ "\n" +
                    "  Wyjście       END");
            Scanner scan = new Scanner(System.in);
            operator = scan.nextLine();
            switch (operator) {
                case "+":
                    comput = new Addition();
                    calc.giveValue();
                    calc.getResult(comput);
                    break;
                case "-":
                    comput = new Subtruction();
                    calc.giveValue();
                    calc.getResult(comput);
                    break;
                case "*":
                    comput = new Multiplication();
                    calc.giveValue();
                    calc.getResult(comput);
                    break;
                case "/":
                    comput = new Division();
                    try {
                        calc.giveValue();
                    } catch (ArithmeticException e) {
                        System.out.println("Błąd! Dzielenie przez zero");
                        calc.giveValue();
                    }
                    calc.getResult(comput);
                    break;
                case "M":
                    System.out.println(calc.getM());
                    calc.clear();
                    calc.getValues().add(calc.getM());
                    break;
                case "M+":
                    calc.addM(calc.getValue(0));
                    break;
                case "M-":
                    calc.subM(calc.getValue(0));
                    break;
                case "sqrt":
                    if (calc.getValue(0)>=0){
                        double sqrt = Math.sqrt(calc.getValue(0));
                        System.out.println("Wynik: " + sqrt);
                        calc.clear();
                        calc.getValues().add(sqrt);
                    }else{
                        System.out.println("Błąd! Nieprawidłowe użycie funkcji. Spróbuj ponownie.");
                    }
                    break;
                case "CE":
                    calc.clear();
                    System.out.println("Pamięć usunięta" + "\n");
                    calc.giveValue();
                    break;
                case "END":
                    System.out.println("Koniec programu. Dzięki za wspólną pracę :)");
                    break;
                    default:
                        System.out.println("Coś poszło nie tak !!! Spróbuj jeszcze raz."+"\n");
            }
        } while (!operator.equals("END"));
    }

}
