package turing_strange_baseball_game;

import java.util.Stack;

/**
 * Information of a strange baseball game is given in a list of strings.
 * - Number: record point of a match.
 * - Operator: "C", "D", or "+"
 *  + "D": record new match point as a double of the last match's point.
 *  + "+": record a new match point as a sum of the last two matches' points.
 *  + "C": don't record a new match point but erase the last match point value.
 *
 *  Sum all points of this baseball game.
 *  
 *  Ex: 1 2 C D +     ->     1 2 3      -> result: 6
 */
public class Solution {
    static int calcPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    int popped = stack.pop();
                    result -= popped;
                    break;
                case "D":
                    int doubled = stack.peek() * 2;
                    stack.push(doubled);
                    result += doubled;
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.pop();
                    int sum = first + second;
                    stack.push(sum);
                    result += sum;
                    break;
                default:
                    int point = Integer.parseInt(op);
                    stack.push(point);
                    result += point;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = calcPoints(new String[]{"1", "2", "C", "D", "+"});
        System.out.println(result);
    }
}