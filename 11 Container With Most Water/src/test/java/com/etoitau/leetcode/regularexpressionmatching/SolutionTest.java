package com.etoitau.leetcode.regularexpressionmatching;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class SolutionTest {
    static List<int[]> inputs = new ArrayList<>();
    static List<Integer> outputs = new ArrayList<>();
    Solution sol = new Solution();

    /**
     * Set up library of test arrays
     */
    @BeforeAll
    static void setup() {
        int[] input;

        input = new int[]{4, 8, 9, 0, 0, 5, 7, 4};
        inputs.add(input);
        outputs.add(35);

        input = new int[]{9, 1, 9, 7, 3, 4, 2};
        inputs.add(input);
        outputs.add(21);

        input = new int[]{1,8,6,2,5,4,8,3,7};
        inputs.add(input);
        outputs.add(49);

        input = new int[]{0, 0};
        inputs.add(input);
        outputs.add(0);

        input = new int[]{10, 11, 4, 5, 1, 0};
        inputs.add(input);
        outputs.add(15);

        input = new int[]{18, 20, 4, 5, 1, 0};
        inputs.add(input);
        outputs.add(18);

        input = new int[]{0, 7, 1};
        inputs.add(input);
        outputs.add(1);


    }

    @Test
    void maxArea() {
        int ans;
        for (int i = 0; i < inputs.size(); i++) {
            ans = sol.maxArea(inputs.get(i));
            assertEquals(ans, outputs.get(i),
                    "failed on test: " + i + "\n input: " + Solution.prettyPrint(inputs.get(i)));
        }
    }

    @Test
    void naive() {
        int ans;
        for (int i = 0; i < inputs.size(); i++) {
            ans = sol.naive(inputs.get(i));
            assertEquals(ans, outputs.get(i),
                    "failed on test: " + i + "\n input: " + Solution.prettyPrint(inputs.get(i)));
        }
    }
}