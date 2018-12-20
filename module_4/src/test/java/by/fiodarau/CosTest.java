package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForCos")
    public Object[][] dataProviderForCos() {
        return new Object[][]{
                {0.0, 1.0},
                {Math.PI, -1.0},
                {"0", "1"}
        };
    }

    @Test(dataProvider = "dataProviderForCos", groups = "Trigonometry")
    public void testCos(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = calculator.cos(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

}
