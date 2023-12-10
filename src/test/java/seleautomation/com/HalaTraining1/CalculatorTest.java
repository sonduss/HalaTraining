package seleautomation.com.HalaTraining1;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class CalculatorTest {
    Calculater calculator;
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Started testing the great calculator app");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing the great calculator app");
    }
    @Before
    public void setUp() {
        System.out.println("Starting a boring test");
        calculator = new Calculater();
    }
    @After
    public void tearDown() {
        System.out.println("Finished a boring test");
    }
    @Test
    public void testAdd() {
        int result = calculator.add(3, 4);
        assertEquals(7, result);
    }
    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 2);
        assertEquals(3, result);
    }
    @Test
    public void testMultiply() {
        int result = calculator.multiply(2, 6);
        assertEquals(12, result);
    }
    @Test
    public void testDivide() {
        int result = calculator.divide(8, 2);
        assertEquals(4, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }
}

