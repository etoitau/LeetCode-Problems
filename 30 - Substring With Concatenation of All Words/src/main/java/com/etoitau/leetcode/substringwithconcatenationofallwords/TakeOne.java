package com.etoitau.leetcode.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.List;


// works but too slow for case like s = "aaaaaaaa" and words - ["a","a","a","a","a","a","a"]
class SolutionOld {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) { return new ArrayList<>(); }

        List<Integer> result = new ArrayList<>();

        StringSurvey survey = new StringSurvey(s, words);
        for (int i = 0; i < s.length() - survey.getLen() + 1; i++) {
            // try to find concatenation from each starting point in s
            if (!survey.hasAllWordsFromHere(i)) {
                // do all words occur after this point in s? If not, then done
                break;
            }
            if (checkConcat(survey, survey.resetToUse(), i)) {
                // is there some concatenation of all words that occurs at this point in s? if so, log it
                result.add(i);
            }
        }
        return result;
    }

    // recursive check if s from index on has remaining workds in toUse
    private boolean checkConcat(StringSurvey survey, List<Integer> toUse, int index) {
        if(toUse.isEmpty()) {
            return true;
        }
        if (index >= survey.getSLen()) {
            return false;
        }
        List<Integer> wordsAtIndex = survey.wordsAtIndexInS(index);
        if (wordsAtIndex.isEmpty()) {
            return false;
        }
        for (Integer i: wordsAtIndex) {
            if (toUse.contains(i) && checkConcat(survey, survey.toUseWithoutI(toUse, i), index + survey.getLen())) {
                return true;
            }
        }
        return false;
    }



}

class StringSurvey {
    private String s;
    private String[] words;
    private int len;
    private List<List<Integer>> sIndexWords = new ArrayList<>();
    private List<List<Integer>> wordIndexInS = new ArrayList<>();

    public StringSurvey(String s, String[] words) {
        this.s = s;
        this.words = words;
        len = words[0].length();
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < s.length(); i++) {
            sIndexWords.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            wordIndexInS.add(new ArrayList<>());
        }

        words:
        for (int i = 0; i < words.length; i++) {
            int cursor = 0;
            while (cursor + len <= s.length()) {
                // find all word i in s
                int index = s.indexOf(words[i], cursor);
                if (index >= 0) {
                    sIndexWords.get(index).add(i);
                    wordIndexInS.get(i).add(index);
                    cursor = index + 1;
                } else {
                    continue words;
                }
            }
        }
    }

    public List<Integer> resetToUse() {
        List<Integer> result = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> toUseWithoutI(List<Integer> toUse, int toRemove) {
        List<Integer> newToUse = new ArrayList<>();
        for (Integer i: toUse) {
            if (i != toRemove) {
                newToUse.add(i);
            }
        }
        return newToUse;
    }

    public boolean hasAllWordsFromHere(int index) {
        words:
        for (int i = 0; i < words.length; i++) {
            // look for each word
            for (int j = 0; j < wordIndexInS.get(i).size(); j++) {
                // survey all occurrences of word see if any are after index
                if (wordIndexInS.get(i).get(j) >= index) {
                    continue words;
                }
            }
            return false;
        }
        return true;
    }

    public int getLen() {
        return len;
    }

    public List<Integer> wordsAtIndexInS(int index) {
        return sIndexWords.get(index);
    }

    public int getSLen() {
        return s.length();
    }

}
