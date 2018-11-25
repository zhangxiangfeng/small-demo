package cn.openread.demo.rpc.v1;

public class CalculatorServiceImpl implements CalculatorService {

    public static void main(String[] args) {
        CalculatorService service = new CalculatorServiceImpl();
        System.out.println(service.add(1.0, 2.0));
    }

    @Override
    public double add(double op1, double op2) {
        return op1 + op2;
    }

    @Override
    public double substract(double op1, double op2) {
        return op1 - op2;
    }

    @Override
    public double multiply(double op1, double op2) {
        return op1 * op2;
    }

}
