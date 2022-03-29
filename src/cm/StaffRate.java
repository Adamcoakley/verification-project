package cm;

import java.math.BigDecimal;

public class StaffRate implements ICalculate {

    @Override
    public BigDecimal calculate(BigDecimal cost) {
        BigDecimal maxPayable = new BigDecimal(16);

        if(cost.compareTo(maxPayable) < 0){
            // not over 16 so we return the cost
            return cost;
        } else{
            // return the max payable which is 16
            return maxPayable;
        }
    }

}
