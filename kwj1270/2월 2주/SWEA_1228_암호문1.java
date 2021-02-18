import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 정해진 칼로리는 넘지 않으면서
// 가장 선호하는 햄버거
public class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static StringTokenizer stringTokenizer;
    private static int T;
    private static int n;
    private static int m;
    private static ArrayList<String> keys;
    public static void main(String[] args) throws IOException {
        T = 10;

        for(int t=1; t <= T; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            n = Integer.parseInt(stringTokenizer.nextToken());

            keys = new ArrayList<>();
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for(int i=0; i < n; i++){
                keys.add(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            m = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            while (stringTokenizer.hasMoreTokens()){
                String token = stringTokenizer.nextToken();
                int start = Integer.parseInt(stringTokenizer.nextToken());
                int end = Integer.parseInt(stringTokenizer.nextToken());

                ArrayList<String> tempList = new ArrayList();
                for(int i=0; i < end; i++){
                    tempList.add(stringTokenizer.nextToken());
                }
                keys.addAll(start, tempList);
            }
            for(int i=0; i < 10; i++){
                STRING_BUILDER.append(keys.get(i)).append(" ");
            }

            System.out.println(STRING_BUILDER.toString());
        }

    }

}
