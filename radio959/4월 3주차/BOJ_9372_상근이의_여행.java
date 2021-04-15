import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,T;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a, b;
		
		T = Integer.parseInt(br.readLine().trim());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			initlist();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			ans=0;
			bfs();
			System.out.println(ans);
			
		}
		
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i : list[temp]) {
				if(!visit[i]) {
					q.add(i);
					visit[i] = true;
//					System.out.println(q.peek());
					ans++;
				}
				if(visitcheck()) return; 
			}
		}
	}
	
	public static void initlist() {
		visit = new boolean [N+1];
		visit[0] = true;
		list = new ArrayList[N+1];
		for(int i=1; i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
	}
	public static boolean visitcheck() {
		for(int i=0; i<=N; i++) {
			if(!visit[i])
				return false;
		}
		return true;
	}

}
