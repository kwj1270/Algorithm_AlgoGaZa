package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int D,W,K;
	static int[][] map;
	static int[] statusByRow; // 각 row별 약품 투약 상태 리스트 (-1 : 투여안함,  0: a 투여,  1 : b 투여)
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			statusByRow = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			ans = Integer.MAX_VALUE;
			dfs(0,0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int row, int cnt) {
		//내가 구한 최소값보다 더 크면 더이상 탐색하지 않음
		if(cnt >= ans) return;
		//맨 마지막에 도달하면 모든 열 연속되있는지 확인하고 답 찾기
		if(row == D) {
			if(isContinue()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		for (int i = -1; i < 2; i++) {
			statusByRow[row] = i;
			if(i == -1) {
				dfs(row+1, cnt);
			}else {
				dfs(row+1, cnt+1);
			}
		}
	}
	
	
	private static boolean isContinue() {
		int now,next;
		for (int x = 0; x < W; x++) {
			int cnt = 1; //연속하는원소 카운트
			for (int y = 0; y < D-1; y++) {
				now = statusByRow[y] == -1 ? map[y][x] : statusByRow[y];
				next = statusByRow[y+1] == -1 ? map[y+1][x] : statusByRow[y+1];
				if(now == next) {
					cnt++;
					if(cnt >= K) break;
					
				}
				else {
					cnt=1;//초기화되서 다시 카운트 시작
				}
				
			}
			if(cnt < K) return false;

		}
		
		return true;
	}
	
	

}
