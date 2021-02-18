import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    private static int n;
    private static int k;


    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        STRING_BUILDER.append("<");
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i <= n; i++){
            q.offer(i);
        }
        ArrayList<Integer> answerList = new ArrayList<>();

        while (!q.isEmpty()){
            for(int i=0; i < k-1; i++){
                q.offer(q.poll());
            }
            answerList.add(q.poll());
        }

        answerList.stream().forEach(i -> STRING_BUILDER.append(i).append(", "));
        STRING_BUILDER.setLength(STRING_BUILDER.length()-2);
        STRING_BUILDER.append(">");
        System.out.println(STRING_BUILDER.toString());
    }

}
