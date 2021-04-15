import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

import static java.lang.Integer.valueOf;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int test;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        test = valueOf(BUFFERED_READER.readLine());
        for (int t = 1; t <= test; t++) {
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            n = valueOf(stringTokenizer.nextToken());
            m = valueOf(stringTokenizer.nextToken());
            for(int i=0 ; i < m; i++){
                BUFFERED_READER.readLine();
            }
            System.out.println(n-1);
        }

    }

}
