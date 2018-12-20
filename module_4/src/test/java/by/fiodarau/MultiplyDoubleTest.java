package by.fiodarau;

import org.testng.Assert;
import util.Converter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyDoubleTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForDoubleMultiply")
    public Object[][] dataProviderForDoubleMultiply() {
        return new Object[][]{
                {1.0, 1.0, 1.0},
                {1.0, 0, 0.0},
                {-2.5, 2.5, -6.25},
                {"25", "2", "50"}
        };
    }

    @Test(dataProvider = "dataProviderForDoubleMultiply", groups = "Arithmetic")
    public void testMultiplyDouble(Object aObj, Object bObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double b = Converter.toDouble(bObj);
            double expected = Converter.toDouble(expObj);
            double delta = 0.0;
            double actual = calculator.mult(a, b);
            Assert.assertEquals(expected, actual, delta);
        } catch (NumberFormatException e) {
            org.testng.Assert.fail(e.getMessage());
        }

    }
}
