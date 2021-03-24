import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] d = new int[1000001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        d[0] = 0;
        d[1] = 0;
        d[2] = 1;
        d[3] = 1;
        for(int i=4; i <= n; i++){
            d[i] = d[i-1]+1;
            if(i%2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
            if(i%3 == 0) d[i] = Math.min(d[i], d[i/3]+1);
        }

        System.out.println(d[n]);

    }
}
