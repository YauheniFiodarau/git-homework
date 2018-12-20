package by.fiodarau.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import by.fiodarau.PowTest;

import by.fiodarau.listener.TestCalcListener;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestListenerAdapter adapter = new TestListenerAdapter();
        TestNG testNG = new TestNG();
        testNG.addListener(adapter);
        testNG.addListener(new TestCalcListener());

        Result result = JUnitCore.runClasses(PowTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Result PowTest is " + result.wasSuccessful());

        XmlSuite suite = new XmlSuite();
        suite.setName("UnitCalcTest");
        List<String> files = new ArrayList<>(new ArrayList<String>() {{
            add("./src/test/resources/suites/CalcTest.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> xmlSuites = new ArrayList<>();
        xmlSuites.add(suite);
        testNG.setXmlSuites(xmlSuites);
        testNG.run();
    }
}
