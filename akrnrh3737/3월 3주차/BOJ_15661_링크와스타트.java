package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15661_링크와스타트 {
	static int N;
	static int[][] map;
	static int[] teamA;
	static int[] teamB;
	static boolean[] isSelected;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N/2; i++) {
			teamA = new int[i];
			teamB = new int[N-i];
			
			solve(0, i, 0);
		}
		System.out.println(ans);
		
	}

	private static void solve(int cnt, int total, int now) {
		//N명중 i명 뽑는 조합 구하기
		if(cnt == total) {
			isSelected = new boolean[N];
			
			//A에 없는게 나머지 팀
			for (int i = 0; i < teamA.length; i++) {
				isSelected[teamA[i]] = true;
			}
			int j=0;
			for (int i = 0; i < N; i++) {
				if(!isSelected[i]) {
					teamB[j++] = i;
				}
			}
			//System.out.println("teamA : "+Arrays.toString(teamA));
			//System.out.println("teamB : "+Arrays.toString(teamB));
			//점수구하기
			int totalA = 0;
			for (int i = 0; i < teamA.length; i++) {
				for (int k = i+1; k < teamA.length; k++) {
					totalA += map[teamA[i]][teamA[k]];
					totalA += map[teamA[k]][teamA[i]];
				}
			}
			int totalB = 0;
			for (int i = 0; i < teamB.length; i++) {
				for (int k = i+1; k < teamB.length; k++) {
					totalB += map[teamB[i]][teamB[k]];
					totalB += map[teamB[k]][teamB[i]];
				}
			}
			int diff = Math.abs(totalA-totalB);
			ans = Math.min(ans, diff);
			return;
		}
		for (int i = now; i < N; i++) {
			teamA[cnt] = i;
			solve(cnt+1, total, i+1);
		}
	}

}
