import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	long node;
	long pt;
	
	public Node(long node, long pt) {
		this.node = node;
		this.pt = pt;
	}
	
	public long getNodeAddOne() {
		return Long.valueOf(String.valueOf(node)+"1");
	}
	
	public long getNodeTwice() {
		return node*2;
	}
	
	public long getPtIncrease() {
		return pt+1;
	}
	
	public boolean isEqual(long end) {
		return node == end;
	}
	
	public boolean isMovable(long end) {
		return node*2 <= end;
	}
	
	public boolean isAddOne(long end) {
		return String.valueOf(node).length() < String.valueOf(end).length();
	}
	
}


public class Main {
	
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	private static long start;
	private static long end;
	private static long[] dp;
	
	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		start =  Long.valueOf(stringTokenizer.nextToken());
		end = Long.valueOf(stringTokenizer.nextToken());
		
		long answer = Long.MAX_VALUE;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 1));
		while (!q.isEmpty()) {
			Node now = q.poll();
			if(now.isEqual(end)) {
				answer = Math.min(answer, now.pt);
				continue;
			}
			if(now.isMovable(end)) {
				q.offer(new Node(now.getNodeTwice(), now.getPtIncrease()));
			}
			if(now.isAddOne(end)) {
				q.offer(new Node(now.getNodeAddOne(), now.getPtIncrease()));
			}
			
		}
		System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
		
	}
}
