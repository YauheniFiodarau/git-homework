package by.fiodarau;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Converter;

public class DivLongTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForDivLong")
    public Object[][] dataProviderForDivLong() {
        return new Object[][]{
                {5, 5, 1},
                {0, -1, 0},
                {"11", "11", "1"}
        };
    }

    @Test(dataProvider = "dataProviderForDivLong", groups = "Arithmetic")
    public void testDivLong(Object aObj, Object bObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            long b = Converter.toLong(bObj);
            long expected = Converter.toLong(expObj);
            long actual = calculator.div(a, b);
            Assert.assertEquals(actual, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDivLongByZero() {
        calculator.div(5, 0);
    }

}
