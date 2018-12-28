package by.fiodarau;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Converter;

public class SinTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSin")
    public Object[][] dataProviderForSin() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI / 2.0, 1.0},
                {"0", "0"}
        };
    }

    @Test(dataProvider = "dataProviderForSin", groups = "Trigonometry")
    public void testSin(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = getCalculatorInstance().sin(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }
}
