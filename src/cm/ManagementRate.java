package cm;

import java.math.BigDecimal;

public class ManagementRate implements ICalculate {

    @Override
    public BigDecimal calculate(BigDecimal cost) {

        BigDecimal minimumPayable = new BigDecimal("4");

        // if the cost is less than 4, return the minimum payable (4)
        if (cost.compareTo(minimumPayable) < 0) {
            return minimumPayable;
        }
        // else return cost
        return cost;

    }
}
