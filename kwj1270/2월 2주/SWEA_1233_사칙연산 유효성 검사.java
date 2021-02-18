import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

// 경현님의 코드를 보면서 다시 풀었습니다.
class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int T = 10;
    private static int n;
    private static char[] arr = new char[201];
    private static String[] strArr;
    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= T; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            n = Integer.parseInt(BUFFERED_READER.readLine().trim());

            for (int i = 1; i <= n; i++) {
                strArr = BUFFERED_READER.readLine().split(" ");
                arr[i] = strArr[1].charAt(0);
            }

            STRING_BUILDER.append(go(1));
            System.out.println(STRING_BUILDER.toString());
        }
    }

    public static int go(int node){
        if((node * 2) > n || arr[node*2] == 0){
            if(arr[node] >= '0' && arr[node] <= '9'){
                return 1;
            }
            return 0;
        }
        if(arr[node] >= '0' && arr[node] <= '9'){
            return 0;
        }
        int n1 = go(node*2);
        int n2 = go((node*2)+1);
        return n1 & n2;
    }

}
