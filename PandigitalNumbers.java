// A pandigital number contains all digits (0-9) at least once. Write a function that takes an integer, returning true if the integer is pandigital, and false otherwise.
// isPandigital(98140723568910) ➞ true

// isPandigital(90864523148909) ➞ false
// // 7 is missing.

// isPandigital(112233445566778899) ➞ false
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class PandigitalNumbers {

    private interface IPandigital {
        boolean isPandigital(int input);
    }

    public static void main(String[] args) {
        Test(12345678);
    }

    private static void Test(int input) {

        String label = "Forrest";
        IPandigital forrestSolution = (i) -> {
            return ForrestSolution(i);
        };

        long elapsed = Time(forrestSolution, input);
        System.out.println(label + ": " + elapsed + " milliseconds");

        IPandigital kevinSolution = (i) -> {
            return KevinSolution(i);
        };

        label = "Kevin";
        elapsed = Time(kevinSolution, input);
        System.out.println(label + ": " + elapsed + " milliseconds");
    }

    private static long Time(IPandigital method, int input) {
        long startTime = System.currentTimeMillis();
        method.isPandigital(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return elapsedTime;
    }

    private static boolean UnitTest() {
        return false;
    }

    private static boolean ForrestSolution(int input) {
        return true;
    }

    private static boolean KevinSolution(int input) {
        return true;
    }
}