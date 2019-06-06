package interfaces.project_calculator;

import java.util.Scanner;

public class Calculator {
    private double val1;
    private double val2;


    public static void giveValue(int i, Calculator c) {
        System.out.println("Wprowadź wartość");
        Scanner scan = new Scanner(System.in);
        if (i==1){
            c.setVal1(scan.nextDouble());
        }else {
            c.setVal2(scan.nextDouble());
        }
    }

    public double getVal1() {
        return val1;
    }

    public void setVal1(double val1) {
        this.val1 = val1;
    }

    public double getVal2() {
        return val2;
    }

    public void setVal2(double val2) {
        this.val2 = val2;
    }

    public static void main(String[] args) {
        Calculator calc;
        Computation comput;
        do {
            calc = new Calculator();
            giveValue(1,calc);
            Scanner scan = new Scanner(System.in);
            System.out.println("Wprowadź operator");
            String operator = scan.nextLine();
            switch (operator) {
                case "*":
                    comput = new Multiplication();
                    giveValue(2, calc);
                    System.out.println("Wynik: "+comput.compute(calc.getVal1(), calc.getVal2())+"\n");
                    break;
                case "+":
                    comput = new Addition();
                    giveValue(2, calc);
                    System.out.println("Wynik: "+comput.compute(calc.getVal1(), calc.getVal2())+"\n");
                    break;
                    default:
                        System.out.println("Something went wrong :( Try again and give first value");
            }
        } while (calc.getVal2() != 0 || calc.getVal1() != 0);
    }

}
