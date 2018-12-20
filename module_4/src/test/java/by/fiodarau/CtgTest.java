package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForCtg")
    public Object[][] dataProviderForCtg() {
        return new Object[][]{
                {Math.PI / 2, 0.0},
                {Math.PI / 4, 1.0},
                {"3.1415", "2.7474"}
        };
    }

    @Test(dataProvider = "dataProviderForCtg", groups = "Trigonometry")
    public void testCtg(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = calculator.ctg(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }

    }
}
