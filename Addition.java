package interfaces.project_calculator;

public class Addition implements Computation{
    @Override
    public double compute(double num1, double num2) {
        return num1+num2;
    }
}
