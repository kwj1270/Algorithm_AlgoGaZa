package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
/*
 * 0~9, + , - 버튼 3종류 
 * 채널 무한대
 * 고장난 버튼 주어짐.
 * N번으로 이동할때 버튼 최소 몇번 눌러야하는지
 * */
	static int N,M;
	static final int MAX = 500000;
	static boolean[] buttons;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		
		buttons = new boolean[10];
		Arrays.fill(buttons, true);
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int broken = Integer.parseInt(st.nextToken());
				buttons[broken] = false;
			}
		}

		System.out.println(solve());


	}
	//500000
	//1 5 -> N에 가까운 수를 만든다 511111(6번) -버튼 (11111번)
	//N자리 정수를 만드는데 1,5이 두가지로 만드는 모든 경우의 수 탐색 
	//N 최대 6자리 M : 10 개 중복순열 n!.. 시간초과나는데..	
	private static int solve() {
		
		//1. +,- 버튼만 눌러서 이동
		int ret = Math.abs(N-100);
		
		//2. 숫자랑 증감버튼 조합으로 이동
		for (int i = 0; i <= 9; i++) {
			if(buttons[i]) {
				ret = Math.min(ret, pressButton(i)+1);
			}
		}
		return ret;
		
	}
	private static int pressButton(int channel) {
		if(channel > MAX*10) return MAX;
		if(channel == N) return 0;
		
		int ret = Math.abs(N-channel);
		
		for (int i = 0; i <= 9; i++) {
			if(channel != 0 && buttons[i]) {
				ret = Math.min(ret, pressButton(channel*10+i)+1);
			}
		}
		return ret;
	}
	
	
	

}
