package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubLongTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSubLong")
    public Object[][] dataProviderForSubLong() {
        return new Object[][]{
                {1, 1, 0},
                {-1, 1, -2},
                {0, -0, 0},
                {"45", "4", "41"}
        };
    }

    @Test(dataProvider = "dataProviderForSubLong", groups = "Arithmetic")
    public void testSumLong(Object aObj, Object bObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            long b = Converter.toLong(bObj);
            long expected = Converter.toLong(expObj);
            long actual = calculator.sub(a, b);
            Assert.assertEquals(actual, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

}
