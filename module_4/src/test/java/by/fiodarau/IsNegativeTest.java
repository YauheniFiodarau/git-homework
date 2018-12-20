package by.fiodarau;

import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderNegative")
    public Object[][] dataProviderNegative() {
        return new Object[][]{
                {0, false},
                {231, false},
                {-4568, true},
                {"-55", "true"},
        };
    }


    @Test(dataProvider = "dataProviderNegative", groups = "Arithmetic")
    public void testIsNegative(Object aObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            boolean expected = Boolean.valueOf(expObj.toString());
            boolean actualAngle = calculator.isNegative(a);
            Assert.assertEquals(actualAngle, expected);
        } catch (NumberFormatException e) {
            Assert.fail(e.getMessage());
        }
    }

}
