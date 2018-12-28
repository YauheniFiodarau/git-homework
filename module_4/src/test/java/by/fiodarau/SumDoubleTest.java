package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSumDouble")
    public Object[][] sumDataProviderForSumDouble() {
        return new Object[][]{
                {1.0, 1.0, 2.0},
                {-1.0, 1, 0.0},
                {0.0, -0, 0.0},
                {"25.5", "25", "50.5"}
        };
    }

    @Test(dataProvider = "dataProviderForSumDouble", groups = "Arithmetic")
    public void testSumDouble(Object aObj, Object bObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double b = Converter.toDouble(bObj);
            double expected = Converter.toDouble(expObj);
            double actual = getCalculatorInstance().sum(a, b);
            Assert.assertEquals(actual, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }
}
