import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// You have given an integer array which contains numbers from 1 to 100 but one number is missing, 
// you need to write a Java program to find that missing number in an array. 
// You cannot use any open source library or Java API method which solves this problem.

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

class MissingInteger {
    static int kPassed = 0;
    static int kFailed = 0;
    static int fPassed = 0;
    static int fFailed = 0;

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++){
            TestAggregate(GenerateInput(100, i), i);
        }
        PrintTotalResults();
    }

    private interface IMissingInteger {
        int getMissingInt(int[] input);
    }

    private static int ForrestSolution(int[] input) {
        int previous = 0;
        for (int i : input) {
            int oneLessThanCurrent = i - 1;
            if (previous != oneLessThanCurrent)
                return oneLessThanCurrent;
            previous = i;
        }
        return -1;
    }

    public static int KevinSolution(int[] input){
        final int One2HundredSum = 5050;
        int actual = 0;
        for(int i : input){
            actual += i;
        }
        return One2HundredSum - actual;
    }

    private static int[] GenerateInput(int inputSize, int missingInteger) {
        int currentInt = 0;
        int[] returnList = new int[inputSize - 1];
        for (int i = 0; i < inputSize - 1; i++) {
            if (++currentInt == missingInteger) {
                i--;
                continue;
            }
            returnList[i] = currentInt;
        }
        return returnList;
    }

    private static void TestAggregate(int[] input, int expectedResult) {
        OverallResult r = Test(input, expectedResult);
        if (r.ForrestSucceeded)
            MissingInteger.fPassed++;
        else
            MissingInteger.fFailed++;
        if (r.KevinSucceeded)
            MissingInteger.kPassed++;
        else
            MissingInteger.kFailed++;
    }

    private static OverallResult Test(int[] input, int expectedResult) {
        int inputSize = input.length;
        System.out.println("\nTesting input of size (" + inputSize + ") with expectedResult '" + expectedResult + "'");
        String label;
        IMissingInteger method;
        OverallResult overallResult = new OverallResult();
        Result result;
        // Forrest
        label = "Forrest";
        method = (i) -> {
            return ForrestSolution(i);
        };
        try {
            result = TimeAndTest(method, input, expectedResult);
        } catch (Exception e) {
            System.out.println("Exception while executing ForrestSolution: '" + e.toString() + "'");
            result = new Result(false, 0);
        }
        overallResult.ForrestSucceeded = result.Succeeded;
        PrintResult(label, result);

        // Kevin
        label = "Kevin";
        method = (i) -> {
            return KevinSolution(i);
        };
        try {
            result = TimeAndTest(method, input, expectedResult);
        } catch (Exception e) {
            System.out.println("Exception while executing KevinSolution: '" + e.toString() + "'");
            result = new Result(false, 0);
        }
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
        int total = MissingInteger.fPassed + MissingInteger.fFailed;
        System.out.println("---------------------------------------------------");
        System.out.println("ForrestSolution passed " + MissingInteger.fPassed / (double) total * 100 + "% of " + total
                + " total tests");
        System.out.println("KevinSolution passed " + MissingInteger.kPassed / (double) total * 100 + "% of " + total
                + " total tests");
    }

    private static Result TimeAndTest(IMissingInteger method, int[] input, int expectedResult) {
        long startTime = System.currentTimeMillis();
        int result = method.getMissingInt(input);
        System.out.println(result);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return new Result(result == expectedResult, elapsedTime);
    }
}