import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int[][] arr;

    private static int n;
    private static int m;
    private static int k;


    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for(int j=0; j < m; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int mid = (Math.min(n,m)/2);
        for(int i=0; i < mid; i++){
            for(int t=1; t <= k; t++) {
                int now = arr[i][i];
                for(int j=i+1; j < n-i; j++){
                    int temp = arr[j][i];
                    arr[j][i] = now;
                    now = temp;
                }

                for(int j=i+1; j < m-i; j++){
                    int temp = arr[n-1-i][j];
                    arr[n-1-i][j] = now;
                    now = temp;
                }

                for(int j=n-i-2; j >= i; j--){
                    int temp = arr[j][m-i-1];
                    arr[j][m-i-1] = now;
                    now = temp;
                }

                for(int j=m-2-i; j >= i; j--){
                    int temp = arr[i][j];
                    arr[i][j] = now;
                    now = temp;
                }
            }
        }


        print();

    }

    public static void print() {
        STRING_BUILDER.setLength(0);
        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                STRING_BUILDER.append(arr[i][j]).append(" ");
            }
            STRING_BUILDER.append("\n");
        }

        STRING_BUILDER.setLength(STRING_BUILDER.length());
        System.out.println(STRING_BUILDER.toString());
    }


}


/*

6 6 10
1 2 3 4 5 6
7 8 9 10 11 12
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30
31 32 33 34 35 36

6 5 9
1 2 3 4 5
7 8 9 10 11
13 14 15 16 17
19 20 21 22 23
25 26 27 28 29
31 32 33 34 35

2 2 3
1 2
3 4

3 3 1
1 2 3
4 5 6
7 8 9
*/
