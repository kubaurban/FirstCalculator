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
    public Double getValue(int i) {
        return values.get(i);
    }
    public Double getLastValue() {
        return getValue(values.size() - 1);
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
        values.add(scan.nextDouble());
    }
    public void getResult(Computation comput){
        Double result = comput.compute(getValue(values.size()-2), getValue(values.size()-1));
        System.out.println("Wynik: " + result + "\n");
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
                    calc.giveValue();
                    calc.getResult(comput);
                    break;
                case "M":
                    System.out.println(calc.getM());
                    calc.getValues().add(calc.getM());
                    break;
                case "M+":
                    calc.addM(calc.getLastValue());
                    break;
                case "M-":
                    calc.subM(calc.getLastValue());
                    break;
                case "sqrt":
                    System.out.println("Wynik: " + Math.sqrt(calc.getLastValue()));
                    calc.getValues().add(Math.sqrt(calc.getLastValue()));
                    break;
                case "CE":
                    calc.getValues().clear();
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
