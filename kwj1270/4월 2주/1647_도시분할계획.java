import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

class Edge implements Comparable<Edge> {
	int from, to, weight;

	public Edge(int form, int to, int weight) {
		super();
		this.from = form;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
	
}


class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	
	
	static int V;
	static int E;
	static int [] parents;
	static Edge[] edgeList;
	
	static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {return false;}
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		V = Integer.parseInt(stringTokenizer.nextToken());
		E = Integer.parseInt(stringTokenizer.nextToken());
		
		
		parents = new int[V+1];
		edgeList = new Edge[E];
		
		for (int i=0; i < E; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			int form = Integer.parseInt(stringTokenizer.nextToken());
			int to = Integer.parseInt(stringTokenizer.nextToken());
			int weight = Integer.parseInt(stringTokenizer.nextToken());
			edgeList[i] = new Edge(form, to, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		int result = 0;
		int count = 0;
		
		for(Edge edge : edgeList) { 
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-2) break;
			}
		}
		System.out.println(result);
		
		
		
	}
	
}
