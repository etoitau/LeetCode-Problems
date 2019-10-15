package com.etoitau.leetcode.generateparentheses;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionSizeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Solution sol = new Solution();
        int input = 1;
        int expected;

        Method method;
        Class[] cArg = new Class[1];
        cArg[0] = Integer.class;

        method = sol.getClass().getDeclaredMethod("solutionSize", int.class);
        method.setAccessible(true);

        input = 1;
        expected = 1;
        assertEquals(expected, method.invoke(sol, input));

        input = 2;
        expected = 2;
        assertEquals(expected, method.invoke(sol, input));

        input = 3;
        expected = 5;
        assertEquals(expected, method.invoke(sol, input));

        input = 6;
        expected = 132;
        assertEquals(expected, method.invoke(sol, input));
    }

    @Test
    void generateParenthesesTest() {
        Solution sol = new Solution();
        Util u = new Util();
        int input;
        int nExprected;
        List<String> result;

        input = 1;
        nExprected = 1;
        result = sol.generateParenthesis(input);
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));
        assertTrue(u.noRepeats(result));

        input = 2;
        nExprected = 2;
        result = sol.generateParenthesis(input);
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));
        assertTrue(u.noRepeats(result));

        input = 3;
        nExprected = 5;
        result = sol.generateParenthesis(input);
        assertTrue(u.noRepeats(result));
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));

        input = 4;
        nExprected = 14;
        result = sol.generateParenthesis(input);
        assertTrue(u.noRepeats(result));
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));

        input = 5;
        nExprected = 42;
        result = sol.generateParenthesis(input);
        assertTrue(u.noRepeats(result));
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));

        input = 6;
        nExprected = 132;
        result = sol.generateParenthesis(input);
        assertTrue(u.noRepeats(result));
        assertEquals(nExprected, result.size());
        assertTrue(u.areValid(result, input * 2));
    }
}

class Util {
    private Map<Character, Character> parenMap;
    public Util() {
        parenMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) { return true; }
        Stack<Character> stack = new Stack<>();

        // for each character in string
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (parenMap.containsKey(c)) {
                // if c is opening paren of some type, add it's closing paren to stack
                stack.push(parenMap.get(c));
            } else {
                // if c is closing paren or foreign character, check top paren to close matches
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        // if string was balanced, stack will be empty
        return stack.isEmpty();
    }

    public boolean areValid(List<String> strings, int size) {
        for (String s : strings) {
            if (!isValid(s) || s.length() != size) {
                System.out.println(s + " is not valid");
                return false;
            }
        }
        return true;
    }

    public boolean noRepeats(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (strings.get(i).equals(strings.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}