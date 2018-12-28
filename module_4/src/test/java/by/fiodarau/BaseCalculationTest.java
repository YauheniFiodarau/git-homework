package by.fiodarau;

import com.epam.tat.module4.Calculator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaseCalculationTest {

    private static Calculator calculatorInstance;
    private static Lock lock = new ReentrantLock();
    
	public static Calculator getCalculatorInstance() {
		if (calculatorInstance == null) {
			lock.lock();
			calculatorInstance = new Calculator();
			lock.unlock();
		}
		return calculatorInstance;
	}

}
