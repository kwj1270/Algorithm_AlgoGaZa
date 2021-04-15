package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
/*
 * 가장 적은 종류의 비행기를 타고 모든 국가 여행
 * 중복 방문 가능
 * */
	static int N,M;
	static int[][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 국가의 수
			M = Integer.parseInt(st.nextToken()); // 비행기 종류
			
			adjMatrix = new int[1001][1001];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = adjMatrix[b][a] = 1;
			}
			
			sb.append(solve()).append("\n");
		}
		System.out.println(sb);

	}
	private static int solve() {
		int[] minEdge = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1] = 0; // 임의로 1번부터 시작한다고 하자
		
		int cost = 0; // 최소신장트리만들때 총 비용
		int cnt = 0; // 정점 개수
		
		while(true) {
			int min = Integer.MAX_VALUE;
			int curr = 0;
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && min > minEdge[i]) { // MST에 포함되지 않는 정점중 최소간선비용을 가진 정점 선택
					curr = i;
					min = minEdge[i];
				}
			}
			visited[curr] = true;
			cost += min;
			if(++cnt == N) break;
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[curr][i] == 1 && adjMatrix[curr][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[curr][i];
				}
			}
		}
		return cost;
	}

}
