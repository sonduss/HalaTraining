package seleautomation.com.HalaTraining1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Started testing the great calculator app");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finished testing the great calculator app");
    }

    @Before
    public void beforeTest() {
        System.out.println("Starting a boring test");
    }

    @After
    public void afterTest() {
        System.out.println("Finished a boring test");
    }

    @Test
    public void testAdd() {
        App calculator = new App();
        int result = calculator.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        App calculator = new App();
        int result = calculator.subtract(8, 3);
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        App calculator = new App();
        int result = calculator.multiply(4, 6);
        assertEquals(24, result);
    }

    @Test
    public void testDivide() {
        App calculator = new App();
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        App calculator = new App();
        calculator.divide(10, 0);
    }
}
