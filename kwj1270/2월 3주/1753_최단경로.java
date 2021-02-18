import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정해진 칼로리는 넘지 않으면서
// 가장 선호하는 햄버거

class Node implements Comparable<Node> {
    int place;
    int worth;

    public Node(int place, int worth){
        this.place = place;
        this.worth = worth;
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return worth - o.worth;
    }

}
class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int v;
    private static int e;
    private static int startNode;
    private static ArrayList<Node>[] list;
    private static int [] dist;
    private static PriorityQueue<Node> q;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList[v+1];
        for(int i=0; i < v+1; i++){
            list[i] = new ArrayList<>();
        }
        startNode = Integer.parseInt(BUFFERED_READER.readLine());

        for(int i=0; i < e; i++){
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            list[u].add(new Node(v, w));
        }

        q = new PriorityQueue<>();
        dist[startNode] = 0;
        q.offer(new Node(startNode, 0));

        while (!q.isEmpty()){
            Node node = q.poll();
            if(dist[node.place] < node.worth) continue;
            for(int i=0; i < list[node.place].size(); i++){
                int next = list[node.place].get(i).place;
                int next_value = node.worth+list[node.place].get(i).worth;
                if(dist[next] > next_value){
                    dist[next] = next_value;
                    q.offer(new Node(next, next_value));
                }
            }
        }

        for(int i=1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }



}
