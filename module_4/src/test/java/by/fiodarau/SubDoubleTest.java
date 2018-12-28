package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubDoubleTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSubDouble")
    public Object[][] dataProviderForSubDouble() {
        return new Object[][]{
                {1.0, 1.0, 0.0},
                {-1.0, 1, -2.0},
                {0.0, -0, 0.0},
                {"25.2", "15.1", "10.1"}
        };
    }

    @Test(dataProvider = "dataProviderForSubDouble", groups = "Arithmetic")
    public void testSumDouble(Object aObj, Object bObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double b = Converter.toDouble(bObj);
            double expected = Converter.toDouble(expObj);
            double actual = getCalculatorInstance().sub(a, b);
            Assert.assertEquals(actual, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

}
