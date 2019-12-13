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
        TestAggregate("1839725064", true);
        TestAggregate(CreateLongString("12345678","9",100000), true);
        TestAggregate(CreateLongString("12345678","9",100000000), true);
        TestAggregate(CreateLongString("12345678","0",100000000), false);
        TestAggregate(CreateLongString("123456789","0",100000000), true);
        PrintTotalResults();
    }

    private interface IPandigital {
        boolean isPandigital(String input);
    }

    private static boolean ForrestSolution(String input) {
        String digits = "1234567890";
        for (int i = 0; i < input.length(); i++) {
            if (digits.length() == 0) 
                break;
            char c = input.charAt(i);
            int digitsIndexOfC = digits.indexOf(c);
            if (digitsIndexOfC != -1)
                digits = digits.substring(0, digitsIndexOfC) + digits.substring(digitsIndexOfC + 1);
        }
        return digits.length() == 0;
    }

    private static boolean KevinSolution(String input) {
        return true;
    }

    private static String CreateLongString(String beginning, String end, int numZeroes){
        StringBuffer sb = new StringBuffer(numZeroes);
        sb.append(beginning);
        for (int i = 0; i < numZeroes; i++){
            sb.append("0");
        }
        sb.append(end);
        return sb.toString();
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
        String printableInput = input.length() > 50 ? input.substring(0,50) + "..." + input.substring(input.length()-1) : input;
        System.out.println("\nTesting input '" + printableInput + "' with expectedResult '" + expectedResult + "'");
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

    private static void PrintTotalResults() {
        int total = PandigitalNumbers.fPassed + PandigitalNumbers.fFailed;
        System.out.println("---------------------------------------------------");
        System.out.println("ForrestSolution passed " + PandigitalNumbers.fPassed / (double) total * 100 + "% of "
                + total + " total tests");
        System.out.println("KevinSolution passed " + PandigitalNumbers.kPassed / (double) total * 100 + "% of " + total
                + " total tests");
    }

    private static Result TimeAndTest(IPandigital method, String input, boolean expectedResult) {
        long startTime = System.currentTimeMillis();
        boolean result = method.isPandigital(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return new Result(result == expectedResult, elapsedTime);
    }
}