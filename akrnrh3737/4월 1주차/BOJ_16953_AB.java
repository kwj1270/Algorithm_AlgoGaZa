package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16953_AB {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		long A = Integer.parseInt(init[0]);
		long B = Integer.parseInt(init[1]);

		int ans = BFS(A,B);
		if(ans!=-1) {
			System.out.println(ans+1);
		}else {
			System.out.println(ans);
		}

	}
	private static int BFS(long A, long B) {
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Long now = q.poll();
				if(now == B) {
					return cnt;
				}
				if(now*2 <= B) {
					q.add(now*2);
				}
				if(now*10+1 <= B) {
					q.add(now*10+1);
				}
				
			}
			cnt++;
		}
		return -1;
	}
}
