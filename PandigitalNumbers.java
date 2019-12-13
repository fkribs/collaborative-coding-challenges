// A pandigital number contains all digits (0-9) at least once. Write a function that takes an integer, returning true if the integer is pandigital, and false otherwise.
// isPandigital(98140723568910) ➞ true

// isPandigital(90864523148909) ➞ false
// // 7 is missing.

// isPandigital(112233445566778899) ➞ false

class Result {
    public long ElapsedTime;
    public boolean Succeeded;

    public Result(boolean succeeded, long elapsedTime) {
        this.Succeeded = succeeded;
        this.ElapsedTime = elapsedTime;
    }
}

class OverallResult {
    public boolean ForrestSucceeded;
    public boolean KevinSucceeded;

    public OverallResult() {
    };

    public OverallResult(boolean f, boolean k) {
        ForrestSucceeded = f;
        KevinSucceeded = k;
    }
}

class PandigitalNumbers {
    static int kPassed = 0;
    static int kFailed = 0;
    static int fPassed = 0;
    static int fFailed = 0;

    public static void main(String[] args) {

        TestAggregate("98140723568910", true);
        TestAggregate("112233445566778899", false);
        TestAggregate("123456789", false);
        TestAggregate("1234567890", true);
        TestAggregate("234567890", false);
        TestAggregate("784163509", false);
        TestAggregate("1839725064", true);

        PrintTotalResults();
    }

    private interface IPandigital {
        boolean isPandigital(String input);
    }

    private static boolean ForrestSolution(String input) {
        return false;
    }

    private static boolean KevinSolution(String input) {
        return true;
    }

    private static void TestAggregate(String input, boolean expectedResult) {
        OverallResult r = Test(input, expectedResult);
        if (r.ForrestSucceeded)
            PandigitalNumbers.fPassed++;
        else
            PandigitalNumbers.fFailed++;
        if (r.KevinSucceeded)
            PandigitalNumbers.kPassed++;
        else
            PandigitalNumbers.kFailed++;
    }

    private static OverallResult Test(String input, boolean expectedResult) {
        System.out.println("\nTesting input '" + input + "' with expectedResult '" + expectedResult + "'");
        String label;
        IPandigital method;
        OverallResult overallResult = new OverallResult();
        Result result;
        // Forrest
        label = "Forrest";
        method = (i) -> {
            return ForrestSolution(i);
        };
        result = TimeAndTest(method, input, expectedResult);
        overallResult.ForrestSucceeded = result.Succeeded;
        PrintResult(label, result);

        // Kevin
        label = "Kevin";
        method = (i) -> {
            return KevinSolution(i);
        };
        result = TimeAndTest(method, input, expectedResult);
        overallResult.KevinSucceeded = result.Succeeded;
        PrintResult(label, result);
        return overallResult;
    }

    private static void PrintResult(String label, Result result) {
        String successStatus = result.Succeeded ? "Succeeded" : "Failed";
        String message = "\t" + label + ": " + successStatus + " in " + result.ElapsedTime + " milliseconds";
        System.out.println(message);
    }

    private static void PrintTotalResults(){
        int total = PandigitalNumbers.fPassed + PandigitalNumbers.fFailed;
        System.out.println("ForrestSolution passed " + PandigitalNumbers.fPassed / (double)total * 100 + "% of " + total + "total tests");
        System.out.println("KevinSolution passed " + PandigitalNumbers.kPassed / (double)total * 100 + "% of " + total + "total tests");
    }

    private static Result TimeAndTest(IPandigital method, String input, boolean expectedResult) {
        long startTime = System.currentTimeMillis();
        boolean result = method.isPandigital(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return new Result(result == expectedResult, elapsedTime);
    }
}