import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
}

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int[][] map;
    
    private static int n;
    private static int m;

    
    
    public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		
		n = parseInt(stringTokenizer.nextToken());
		m = parseInt(stringTokenizer.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for(int j=0; j < m; j++) {
				map[i][j] = parseInt(stringTokenizer.nextToken());
			}	
		}

		int round = 0;
		int remain = Integer.MAX_VALUE;
		while (true) {
			if(getReamin() == 0) break;
			remain = getReamin();
			bfs();
			round++;
		}
		
		System.out.println(round);
		System.out.println(remain);
		
	}
    
    private static void bfs() {
    	Queue<Node> q = new LinkedList<Node>();
    	boolean[][] passed = new boolean[n][m];
    	q.offer(new Node(0, 0));
    	passed[0][0] = true;
    	while (!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i < 4; i++) {
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];
				
				if(next_x < 0 || next_x >= n) continue;
				if(next_y < 0 || next_y >= m) continue;
				if(passed[next_x][next_y]) continue;
				
				passed[next_x][next_y] = true;
				
				if(map[next_x][next_y] == 1) {
					map[next_x][next_y] = 0;
					continue;
				}
				q.offer(new Node(next_x, next_y));
				
			}
		}
    	
    }
    
    private static int getReamin() {
		int remain = 0;
    	for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				if(map[i][j] == 1) remain++;
			}	
		}
		return remain;
	}

       
}
    
