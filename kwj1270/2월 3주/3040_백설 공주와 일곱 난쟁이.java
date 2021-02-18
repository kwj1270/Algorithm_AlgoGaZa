import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final int N = 9;
    private static final int LIMIT = 100;

    private static int[] nanjangi;
    private static int sum = 0;;
    private static int diff;

    public static void main(String[] args) throws IOException {
        nanjangi = new int[9];
        for(int i=0; i < N; i++){
            nanjangi[i] = Integer.parseInt(BUFFERED_READER.readLine().trim());
            sum += nanjangi[i];
        }
        diff = sum - LIMIT;
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(i == j) continue;
                if(nanjangi[i] + nanjangi[j] == diff) {
                    for(int k=0; k < N; k++){
                        if(k == i || k == j) continue;
                        System.out.println(nanjangi[k]);
                    }
                    return ;
                }
            }
        }
    }
}
