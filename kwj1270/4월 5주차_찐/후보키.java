package me.kwj1270.algorithm;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int solution(String[][] relation) {
        List<Integer> answer = new ArrayList<>();
        int n = relation.length;
        int m = relation[0].length;
        for (int i = 1; i < (1 << m); i++) {
            Set<String> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                String now = "";
                for (int k = 0; k < m; k++) {
                    if ((i & (1 << k)) != 0) now += relation[j][k];
                }
                s.add(now);
            }
            if (s.size() == n && possi(answer, i)) answer.add(i);
        }

        return answer.size();
    }

    // 최소성
    boolean possi(List<Integer> answer, int now) {
        for (int i = 0; i < answer.size(); i++) {
            if ((answer.get(i) & now) == answer.get(i)) return false;
        }
        return true;
    }

}




