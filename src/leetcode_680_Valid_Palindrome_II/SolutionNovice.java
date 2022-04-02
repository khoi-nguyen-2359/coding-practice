package leetcode_680_Valid_Palindrome_II;

import kotlin.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static java.lang.System.out;

class SolutionNovice {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome(s, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPalindrome(String s, int except) {
        int i = 0, j = s.length() - 1;
        if (i == except) {
            ++i;
        }
        if (j == except) {
            --j;
        }
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
            if (i == except) {
                ++i;
            }
            if (j == except) {
                --j;
            }
        }

        return true;
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            }

            ++i;
            --j;
        }

        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        boolean result = new SolutionNovice().validPalindrome("edee");
        out.println(result);
    }
}

/*
eedede
 */