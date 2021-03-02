package com.study26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_18429_근손실 {
	static int N,K;
	static int[] kit;
	static int[] numbers;
	static boolean isSelected[];

	static int cntNum=0;;
	public static void permutation(int cnt,int weight) {
		//순열이 키트의 개수 만큼 다 만들어진 경우
		if(weight<0) return;
		if(cnt == N) {
			cntNum++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			
			permutation(cnt+1,weight+kit[i]-K);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		numbers= new int[N];
		isSelected= new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			kit[i]= Integer.parseInt(st.nextToken());
		}
		//순열 사용
		permutation(0,0);
		System.out.println(cntNum);
	}
}
