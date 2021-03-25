package com.study38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_20056_마법사상어와파이어볼 {
	static int N,M,K;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; //파이어볼 0~7까지의 이동
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static class fireball{
		int x,y;
		int weight,dir,speed;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
	}

}	
