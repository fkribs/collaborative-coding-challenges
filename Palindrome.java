// A palindrome is a word that is identical forward and backwards.

// mom
// racecar
// kayak
// Given a word, create a function that checks whether it is a palindrome.

// Examples
// checkPalindrome("mom") ➞ true

// checkPalindrome("scary") ➞ false

// checkPalindrome("reviver") ➞ true

// checkPalindrome("stressed") ➞ false
// Notes
// All test input is lower cased.

class Palindrome{
    public static void main(String[] args) {
        String value = "racecar";
        System.out.println(KevinSolution(value));
        System.out.println(ForrestSolution(value));
    }

    public static boolean KevinSolution(String word) {
        if(word.length() == 0) return true;
	    int left = 0;
	    int right = word.length() - 1;
	    while(left < right){
	        if(word.charAt(left) != word.charAt(right)){
	            return false;
	        }
	        left++;
	        right--;
	    }
	    return true;
    }

    public static boolean ForrestSolution(String str) {
        char[] ca = str.toCharArray();
        int length = ca.length - 1;
        for (int i = 0; i < length; i++) {
            if (ca[i] != ca[length - i])
                return false;
        }
        return true;
    }
}


