package com.algorithm.ch3dp;

import com.algorithm.StringUtils;

/**
 *
 * 存在以下DNA序列
 * S1 = ACCGGTCGAGTGCGCGGAAGCCGGCCGAA
 * S2 = GTCGTTCGGAATGCCGTTGCTCTGTAAA
 * answer = GTCGTCGGAAGCCGGCCGAA
 * Created By Have
 * 2023/3/26 10:42
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        String target = "GTCGTCGGAAGCCGGCCGAA";
        LCS lcs = new LCS();
        int longestCommonSubsequence = lcs.findLongestCommonSubsequence(s1, s2);
        System.out.println(longestCommonSubsequence == target.length());
    }

    /**
     * define f[1...m, 1...n]
     *
     *            0                          if i == 0 or j == 0
     * f[i,j] =   f[i-1, j-1] + 1            if s1[i] == s2[j]
     *            Max(f[i-1, j], f[i][j-1])  if s1[i] != s2[j]
     * @param s1
     * @param s2
     * @return
     */
    public int findLongestCommonSubsequence(String s1, String s2) {
        if (StringUtils.isEmpty(s1) || StringUtils.isEmpty(s2)) {
            return 0;
        }
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i-1][j-1] + 1;
                } else {
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                }
            }
        }

        return f[m][n];
    }
}
