package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름_부분집합 {
	static int D,W,K;
	static int[][] map;
	static int[][] copymap;
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
			copymap = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copymap[i][j] = map[i][j];
					
				}
			}
			ans = Integer.MAX_VALUE;
			solve2(0,0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	
	//행을 선택하는 부분집합
	private static void solve2(int row, int cnt) {
		if(cnt >= ans) return;
		if(row == D) {
			if(isContinue2()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		//1.아무것도 투약 안함
		solve2(row+1, cnt);
		
		//2.A투약
		for (int i = 0; i < W; i++) {
			map[row][i] = 0;
		}
		solve2(row+1, cnt+1);
		
		//3.B투약
		for (int i = 0; i < W; i++) {
			map[row][i] = 1;
		}
		solve2(row+1, cnt+1);
		
		//상태배열 원복
		for (int i = 0; i < W; i++) {
			map[row][i] = copymap[row][i];
		}
		
	}
	
	
	private static boolean isContinue2() {
		int now,next;
		for (int x = 0; x < W; x++) {
			int cnt = 1; //연속하는원소 카운트
			for (int y = 0; y < D-1; y++) {
				now = map[y][x];
				next = map[y+1][x];
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
