package by.fiodarau;

import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowTest {

    private double aDouble;
    private double bDouble;
    private double expected;
    private Calculator calculator;

    @Before
    public void initialize() {
        calculator = new Calculator();
    }

    public PowTest(double aDouble, double bDouble, double expected) {
        this.aDouble = aDouble;
        this.bDouble = bDouble;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 1.0},
                {2.5, 3, 15.625},
                {4, 0.5, 2.0},
                {4.0, -1.0, 0.25},
        });
    }

    @Test
    public void testPowCorrect() {
        double delta = 0.0;
        double actual = calculator.pow(aDouble, bDouble);
        Assert.assertEquals(expected, actual, delta);
    }

}
