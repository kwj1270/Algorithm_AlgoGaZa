package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할 {
	static int N,M;
	static List<Node> adjList;
	static int parents[];
	
	static class Node implements Comparable<Node>{
		int from,to,cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost); // 비용 적은순으로
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<Node>();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList.add(new Node(from, to, cost));
		}
		
		parents = new int[N+1];
		
		Collections.sort(adjList);
		makeParents();
		int ans = 0;
		int max = 0;
		for (int i = 0; i < adjList.size(); i++) {
			Node now = adjList.get(i);
			if(find(now.from) != find(now.to)) {
				
				union(now.from, now.to);
				ans += now.cost;
				max = now.cost; // 마지막 갱신이 최대비용
			}
			
			
		}
		System.out.println(ans-max);

	}
	
	private static void makeParents() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	//v의 루트 노드 찾기
	private static int find(int v) {
		if(v == parents[v]) {
			return v;
		}
		return parents[v] = find(parents[v]);
	}
	
	//a집합에 b를 흡수
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	

}
