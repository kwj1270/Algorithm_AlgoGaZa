package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_18429_근손실 {
/**
 * 운동키트 순열로 N일동안 근육량 500이상이 되도록하는 경우의수 찾기
 * 운동키트 모두 다름 -> 순열
 * 하루지날때 근육량 K만큼 감소
 * @throws IOException 
 * */
	static int N;
	static int K;
	static int[] arr;
	static int[] result;
	static int ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		K = Integer.parseInt(init[1]);
		arr = new int[N];
		result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		//순열 생성
		permutation(0, 0);
		System.out.println(ans);
	}
	
	private static void permutation(int cnt, int flag) {
		if(cnt == N) {
			//매일 500이상 중량 되는지 체크
			if(check(result)) ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			result[cnt] = arr[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}
	
	private static boolean check(int result[]) {
		int weight = 500;
		for (int i = 0; i < N; i++) {
			weight -= K;
			weight += result[i];
			if(weight < 500) return false;
		}
		return true;
	}

}
