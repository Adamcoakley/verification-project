package cm;

import java.math.BigDecimal;

public class StudentRate implements ICalculate {

    @Override
    public BigDecimal calculate(BigDecimal cost) {

        BigDecimal limit = new BigDecimal("5.50");
        BigDecimal remainder = cost.subtract(limit);
        BigDecimal threeQuarter = new BigDecimal("0.75");

        // if the cost is > 5.50, multiply the remainder by 0.75 and add the 5.50 back
        if (cost.compareTo(limit) > 0) {
            cost = threeQuarter.multiply(remainder).add(limit);
        }
        return cost;
    }
}
