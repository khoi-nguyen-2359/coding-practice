package leetcode_242_Valid_Anagram_3;

import java.util.HashMap;

import static java.lang.System.out;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int count = 0;
            if (counterMap.containsKey(c)) {
                count = counterMap.get(s.charAt(i));
            }
            counterMap.put(c, count + 1);
        }

        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            int count = -1;
            if (counterMap.containsKey(c)) {
                count = counterMap.get(c) - 1;
            }

            if (count < 0) {
                return false;
            }

            counterMap.put(c, count);
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        boolean result = new Solution().isAnagram("anagram", "nagaram");
        out.println(result);
    }
}