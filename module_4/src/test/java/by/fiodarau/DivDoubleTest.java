package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivDoubleTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForDivDouble")
    public Object[][] dataProviderForDivDouble() {
        return new Object[][]{
                {5.0, 5, 1.0},
                {0.0, -1.0, 0.0},
                {5.25, 0.25, 21.0},
                {"33.3", "3.0", "11.1"}
        };
    }

    @Test(dataProvider = "dataProviderForDivDouble", groups = "Arithmetic")
    public void testDivDouble(Object aObj, Object bObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double b = Converter.toDouble(bObj);
            double expected = Converter.toDouble(expObj);
            double delta = 0.0;
            double actual = calculator.div(a, b);
            Assert.assertEquals(actual, expected, delta);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testDivDoubleByZero() {
        Assert.assertTrue(Double.isInfinite(calculator.div(5.25, 0.0)));
    }
}
