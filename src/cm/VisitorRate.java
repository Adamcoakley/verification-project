package cm;

import java.math.BigDecimal;

public class VisitorRate implements ICalculate {

    @Override
    public BigDecimal calculate(BigDecimal cost) {

        BigDecimal freeAmount = new BigDecimal("10");
        BigDecimal percentage = new BigDecimal("0.5");

        // if the cost is less than or equal to 10, return zero
        if (cost.compareTo(freeAmount) <= 0) {
            return new BigDecimal(0);
        }
        // else, subtract the free amount and multiply the remainder by 0.5
        return cost.subtract(freeAmount).multiply(percentage);
    }
}
