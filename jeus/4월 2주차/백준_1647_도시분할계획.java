package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class 백준_1647_도시분할계획 {
	static int N, M;
	static ArrayList<ArrayList<Edge>> list=new ArrayList<>();
	static Edge[] edgeList;
	static int parents[];
	static class Edge implements Comparable<Edge>{
		int weight,from,to;

		public Edge( int from, int to,int weight) {
			this.weight = weight;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		edgeList = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine()," ");
			int from =Integer.parseInt(st.nextToken()); 
			int to =Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] =new Edge (from , to , weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int result = 0;
		int count = 0;
		int max =-1;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { //사이클 발생 x
				result += edge.weight;
				count++;
			}
			if (count == N-2) {
				break;
			}	
		}
		System.out.println(result);
		//System.out.println(result-max);
	}
	static int findSet(int a) {
		//들오온 a가 대표자라면
		if(parents[a]==a) return a;
		
//		return findSet(parents[a]); //path compression 전 
	
		return parents[a] = findSet(parents[a]); //path compression 후 
		
	}
	public static void make() {
		for (int i = 0; i <= N; i++) {
			parents[i]=i;
		}
	}
	public static boolean union(int a , int b) {
			
			int aRoot = findSet(a);
			
			int bRoot = findSet(b);
			
			if(aRoot==bRoot) return false;
			
			parents[bRoot] = aRoot;
			
			return true;
	}
	
}
