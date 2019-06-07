package interfaces.project_calculator;

public class Addition implements Computation{
    @Override
    public Double compute(Double num1, Double num2) {
        return num1+num2;
    }
}
