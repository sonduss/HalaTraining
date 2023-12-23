package QA.halaqa;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Started testing the great calculator app");
    }

    @AfterAll
    public static void finishTesting() {
        System.out.println("Finished testing the great calculator app");
    }

    @BeforeEach
    public void startBoringTest() {
        System.out.println("Starting a boring test");
    }

    @AfterEach
    public void finishBoringTest() {
        System.out.println("Finished a boring test");
    }

    @Test
    public void testAddition() {
        double result = Calculator.add(5, 3);
        assertEquals(8, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = Calculator.subtract(10, 2);
        assertEquals(8, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = Calculator.multiply(4, 7);
        assertEquals(28, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = Calculator.divide(15, 3);
        assertEquals(5, result, 0.0001);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(10, 0));
    }
}
