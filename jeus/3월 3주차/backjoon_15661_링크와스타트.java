package com.study33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_15661_링크와스타트 {
	static int N;
	static int map[][];
	static boolean isSelected[];
	static int numbers[];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		map=new int [N][N];
		isSelected= new boolean[N];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
			
		}
		combination(0, 0);
		System.out.println(min);
		
	}
	public static void combination(int cnt, int target) {
		//공집합은 포함 X
		if(cnt == N) {
			if(target>=1) {
				int sSum=0;
				int lSum=0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(isSelected[i]&&isSelected[j]) {
							sSum += map[i][j];
						}
						if(!isSelected[i]&&!isSelected[j]) {
							lSum += map[i][j];
						}
					}
				}
				min = Math.min(min, Math.abs(sSum-lSum));
			}
			
			return;
		}
		
		
		if(isSelected[cnt]) return;
		
		isSelected[cnt]=true;
		combination(cnt+1, target+1);
		isSelected[cnt]=false;
		combination(cnt+1, target);
	}
}
