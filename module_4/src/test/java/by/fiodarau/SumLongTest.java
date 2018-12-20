package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumLongTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSumLong")
    public Object[][] sumDataProviderForSumLong() {
        return new Object[][]{
                {1, 1, 2},
                {-1, 1, 0},
                {0, -0, 0},
                {"25", "25", "50"}
        };
    }

    @Test(dataProvider = "dataProviderForSumLong", groups = "Arithmetic")
    public void testSumLong(Object aObj, Object bObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            long b = Converter.toLong(bObj);
            long expected = Converter.toLong(expObj);
            long actual = calculator.sum(a, b);
            Assert.assertEquals(actual, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }
}
