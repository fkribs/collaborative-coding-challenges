import java.util.*;

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
// Example 1:
// Input: "III"
// Output: 3
// Example 2:
// Input: "IV"
// Output: 4
// Example 3:
// Input: "IX"
// Output: 9
// Example 4:
// Input: "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 5:
// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

class RomanToInt{
    public static void main(String[] args) {

        String romanNumeral = "MXIX";
        HashMap<Character, Integer> map = Initialize();
        System.out.println(map);
        System.out.println(KevinSolution(map, romanNumeral));

        map = Initialize();
        System.out.println(map);
        System.out.println(ForrestSolution(map, romanNumeral));
    }

    private static HashMap<Character, Integer> Initialize() {
        HashMap<Character, Integer> map = new HashMap() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        return map;
    }

    public static int KevinSolution(HashMap<Character, Integer> map, String roman) {
        int res = 0;
        Stack<Integer> stack = new Stack();
        for (char c : roman.toCharArray()) {
            stack.push(map.get(c));
        }
        int current = stack.pop();
        res += current;
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped < current) {
                res -= popped;
                current = popped;
            } else {
                res += popped;
                current = popped;
            }
        }
        return res;
    }

    public static int ForrestSolution(HashMap<Character, Integer> map, String roman) {
        int res = 0;
        List<Integer> items = new ArrayList<Integer>();
        for (char c : roman.toCharArray()) {
            items.add(map.get(c));
        }
        System.out.println(items);
        Integer current;
        Integer next;
        Integer size = items.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1){
                res += items.get(i);
                break;
            }
            current = items.get(i);
            next = items.get(i+1);
            if (next > current){
                res += next - current;
                i++;
            }
            else{
                res += current;
            }
        }
        return res;
    }

}