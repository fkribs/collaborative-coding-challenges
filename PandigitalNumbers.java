// A pandigital number contains all digits (0-9) at least once. Write a function that takes an integer, returning true if the integer is pandigital, and false otherwise.
// isPandigital(98140723568910) ➞ true

// isPandigital(90864523148909) ➞ false
// // 7 is missing.

// isPandigital(112233445566778899) ➞ false

class Result{
    public long ElapsedTime;
    public boolean Succeeded;
    public Result(boolean succeeded, long elapsedTime){
        this.Succeeded = succeeded;
        this.ElapsedTime = elapsedTime;
    }
}

class PandigitalNumbers {
    public static void main(String[] args) {
        Test(12345678, false);
        Test(123456789, true);
    }

    private interface IPandigital {
        boolean isPandigital(int input);
    }


    private static boolean ForrestSolution(int input) {
        return false;
    }

    private static boolean KevinSolution(int input) {
        return true;
    }

    private static void Test(int input, boolean expectedResult) {
        System.out.println("\nTesting input '" + input +  "' with expectedResult '" + expectedResult + "'");
        String label;
        IPandigital method;
        Result result;
        // Forrest
        label = "Forrest";
        method = (i) -> {
            return ForrestSolution(i);
        };
        result = TimeAndTest(method, input, expectedResult);
        PrintResult(label, result);

        // Kevin
        label = "Kevin";
        method = (i) -> {
            return KevinSolution(i);
        };
        result = TimeAndTest(method, input, expectedResult);
        PrintResult(label, result);
    }

    private static void PrintResult(String label, Result result){
        String successStatus = result.Succeeded ? "Succeeded" : "Failed";
        String message = "\t" + label + ": " + successStatus + " in " + result.ElapsedTime + " milliseconds";
        System.out.println(message);
    }

    private static Result TimeAndTest(IPandigital method, int input, boolean expectedResult) {
        long startTime = System.currentTimeMillis();
        boolean result = method.isPandigital(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return new Result(result == expectedResult, elapsedTime);
    }
}