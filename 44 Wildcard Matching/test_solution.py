# -*- coding: utf-8 -*-

import solution

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_isMatch(self):
        sol = solution.Solution()

        s = "aa"
        p = "a"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "aa"
        p = "*"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "cb"
        p = "?a"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "adceb"
        p = "*a*b"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "acdcb"
        p = "a*c?b"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = ""
        p = "*"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = ""
        p = ""
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = ""
        p = "?"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "something"
        p = ""
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "*****ba*****ab"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "ba*****ab"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "ba*ab"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "baaa?ab"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "ba*a?"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "a*ab"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "a****ab"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "ba*ab****"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "****"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "aa?ab"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "b*b"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "a*a"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "baaabab"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "?baaabab"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "baaabab"
        p = "*baaaba*"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "a"
        p = "a*"
        expected = True
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "a"
        p = "a*a"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)

        s = "mississippi"
        p = "m??*ss*?i*pi"
        expected = False
        result = sol.isMatch(s, p)
        self.assertEqual(expected, result)



if __name__ == '__main__':
    unittest.main()