package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

class CoakleyAdamTestTask2 {

    // Tests from task one
    // rate constructor tests
    @Test
    public void validNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void zeroNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(2);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void invalidNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(2);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void nullNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal reducedRate = new BigDecimal(2);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, null, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void validReducedRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void zeroReducedRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(0);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void invalidReducedRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void nullReducedRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, null, reducedPeriods, normalPeriods));
    }

    @Test
    public void biggerNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void smallerNormalRate(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(6);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void equalRates(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void nullNormalPeriods(){
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, null));
    }

    @Test
    public void nullReducedPeriods(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, null, normalPeriods));
    }

    @Test
    public void reducedPeriodsOverlap(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,7), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(7,12), new Period(10,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void normalPeriodsOverlap(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,7), new Period(5,12)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(12,15), new Period(15,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void bothPeriodsOverlap(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(8,18), new Period(21,24)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void validPeriods(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    // calculate() tests
    @Test
    public void validStartAndEndHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(10), rate.calculate(new Period(12,17)));
    }

    @Test
    public void negativeStartHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate.calculate(new Period(-1,17)));
    }

    @Test
    public void boundaryStartHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        //assuming the periods not listed are free, the return value should be 0 here
        Assertions.assertEquals(new BigDecimal(0), rate.calculate(new Period(0,5)));
    }

    @Test
    public void invalidStartHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate.calculate(new Period(25,17)));
    }

    @Test
    public void negativeEndHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate.calculate(new Period(12,-1)));
    }

    @Test
    public void boundaryEndHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(33), rate.calculate(new Period(12,24)));
    }

    @Test
    public void invalidEndHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate.calculate(new Period(12,25)));
    }

    @Test
    public void greaterStartHour() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate.calculate(new Period(12,8)));
    }

    // task two tests
    // a test with a periods list.size() < 2 needs to be created to increase coverage
    @Test
    public void rateListSizeOfLessThanTwo(){
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10,17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17,24));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    // a test with a periods list.size() > 2 needs to be created to increase coverage
    @Test
    public void rateListSizeOfGreaterThanTwo(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(10,18), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(7,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

}