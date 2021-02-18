import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정해진 칼로리는 넘지 않으면서
// 가장 선호하는 햄버거
class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static StringTokenizer stringTokenizer;
    private static int T;
    private static int n;
    private static int m;
    private static int[] array;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(BUFFERED_READER.readLine().trim());

        for(int t=1; t <= T; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[n];
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for(int j=0; j < n; j++){
                array[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            STRING_BUILDER.append(go(0, 0, 0));

            System.out.println(STRING_BUILDER.toString());
        }

    }

    public static int go(int index, int count, int sum){
        if(sum > m){
            return -1;
        }
        if(count == 2) {
            return sum;
        }
        if(index == n){
            return -1;
        }

        int answer = Integer.MIN_VALUE;
        answer = Math.max(answer, go(index+1, count+1, sum+array[index]));
        answer = Math.max(answer, go(index+1, count, sum));
        return answer;
    }

}
