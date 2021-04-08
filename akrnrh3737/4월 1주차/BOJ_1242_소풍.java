package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1242_소풍 {
	static int N,K,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // K번째 퇴장
		M = Integer.parseInt(st.nextToken())-1; //동호 인덱스
		
		int start = 0;
		int cnt=1;
		while(true) {
			int removed = (start+K-1) % N;
			System.out.println("removed : " + removed);
			if(removed == M) {
				break;
			}
			if(removed < M) {
				M-=1;
			}
			start = removed;
			N-=1;
			cnt+=1;
		}
		System.out.println(cnt);
	}

}
