package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12904_A와B {
	static StringBuilder S, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new StringBuilder(br.readLine());
		T = new StringBuilder(br.readLine());
		//BFS();
		solve();
	}
	private static void solve() {
		int sLen = S.length();
		int tLen = T.length();
		while(sLen < tLen) {
			if(T.charAt(tLen-1) == 'A') {
				T.deleteCharAt(tLen-1);
				tLen--;
			}else {
				T.deleteCharAt(tLen-1); // B제거
				T.reverse(); // 뒤집기
				tLen--;
			}
		}
		if(S.toString().equals(T.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	private static void BFS() {
		
		Queue<StringBuilder> q = new LinkedList<>();
		q.add(S);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				StringBuilder now = q.poll();
				if(now.toString().equals(T.toString())) {
					System.out.println(1);
					return;
				}
				
				StringBuilder next1 = new StringBuilder(now);
				next1.append("A");
				if(next1.length() <= T.length()) {
					q.add(next1);
				}
				
				StringBuilder next2 = new StringBuilder(now);
				next2.reverse().append("B");
				if(next2.length() <= T.length()) {
					q.add(next2);
				}

			}
		}
		System.out.println(0);
	}

}
