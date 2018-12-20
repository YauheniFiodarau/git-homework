package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSqrt")
    public Object[][] dataProviderForSqrt() {
        return new Object[][]{
                {6.25, 2.5},
                {4.0, 2.0},
                {0.0, 0.0},
                {"9", "3"}
        };
    }

    @Test(dataProvider = "dataProviderForSqrt", groups = "Arithmetic")
    public void testSqrtWithPositiveNumber(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = calculator.sqrt(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testSqrtWithNegativeNumber() {
        Assert.assertTrue(Double.isNaN(calculator.sqrt(-4.0)), "Expected NaN!");
    }

}
