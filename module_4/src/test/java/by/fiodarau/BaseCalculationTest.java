package by.fiodarau;

import org.testng.annotations.BeforeClass;

import com.epam.tat.module4.Calculator;

public class BaseCalculationTest {
    Calculator calculator;

    @BeforeClass
    public void initCalculator() {
        calculator = new Calculator();
    }
}
