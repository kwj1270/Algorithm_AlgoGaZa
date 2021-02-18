package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14719_빗물 {
/**
 * 
 * 1. 현재위치에서 왼쪽으로 가장 높은 원소
 * 2. 현재위치에서 오른쪽으로 가장 높은 원소
 * 3. 둘중 낮은 높이에서 현재 높이를 뺀다 = 현재위치넓이값
 * 4. 현재위치 (너비가1인 세로막대기) 넓이 계속 누적해간다.
 *
 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		int R = Integer.parseInt(init[0]);
		int C = Integer.parseInt(init[1]);
		int[] height = new int[C];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < C; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		//solve
		for (int i = 1; i < C-1; i++) {
			int left=0, right=0;
			//현재위치 기준 왼쪽에서 가장 높은 원소
			for (int j = 0; j < i; j++) {
				left = Math.max(left, height[j]);
			}
			//현재위치 기준 오른쪽에서 가장 높은 원소
			for (int j = i+1; j < C; j++) {
				right = Math.max(right, height[j]);
			}
			//물 담을 수 있게 파여있을 조건
			if(height[i] < left && height[i] < right) {
				ans += Math.min(left, right) - height[i]*1;
			}
			
		}
		System.out.println(ans);
		
	}

}
