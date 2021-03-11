package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1920_수찾기 {
	static int[] origin;
	static int[] target;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		origin = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		target = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(origin);
		for (int i = 0; i < M; i++) {
			binarySearch(target[i]);
		}
		
	}

	private static void binarySearch(int item) {
		//이분탐색 
		int left=0;
		int right=origin.length-1;

		while (left <= right) {
			int mid = (left+right)/2;
			if(origin[mid] == item) {
				System.out.println(1);
				return;
			}else if(origin[mid] > item) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(0);
		return;
			
		
	}

}
