package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

public class MinimumWindowSubstring {

    /**
     * Intuition:
     *  1. substring.length() >= t.length()
     *  2. minimum t.length() and expand until it meets condition
     * 
     *  3. check condition: substring contains all the characters from t
     *  4. if violate condition: expand
     *  5. if meet condition: update min substring and shrink until substring.charCount == t.charCount
     *  6. meet condition: substring.charCount >= t.charCount
     * 
     * Complexity:
     *  1. Time: O(n)
     *  2. Space: O(1)
     */
    public String _v1Solve(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || t.length() > s.length()) return "";

        String sL = s.toLowerCase();
        String tL = t.toLowerCase();

        int[] tF = new int[26];
        int[] sF = new int[26];
        for (int i=0; i<tL.length(); i++) {
            tF[tL.charAt(i)-'a']++;
            sF[sL.charAt(i)-'a']++;
        }
        
        String res = "";
        int l=0, r=tL.length();
        while (r <= sL.length()) {
            boolean[] condition = contains(tF, sF);

            // if condition meet 
            if (condition[0]) {
                // if exactly match, update minimum window substring
                if (condition[1]) {
                    String substring = s.substring(l, r);
                    if (res.isEmpty() || substring.length() < res.length()) res = substring;
                }

                // shrink till condition meet because we need minimum window substring
                sF[sL.charAt(l)-'a']--;
                l++;
            } else {
                // if condition violate, expand
                if (r < sL.length()) sF[sL.charAt(r)-'a']++;
                r++;    
            }
        }

        return res;
    }

    /**
     * index 0 -> true/false: condition meet
     * index 1 -> true/false: exactly match
     */
    private boolean[] contains(int[] tF, int[] sF) {
        boolean[] res = new boolean[2];
        boolean match = true;
        for (int i=0; i<tF.length; i++) {
            if (tF[i] != 0) {
                if (sF[i] < tF[i]) {
                    return res;
                } else if (sF[i] != tF[i]) {
                    match = false;
                }
            }
        }
        res[0] = true;
        res[1] = match;
        return res;
    }

    public boolean _v2Solve(String s, String t) {
        return false;
    }
}
