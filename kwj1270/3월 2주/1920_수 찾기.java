import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static long [] arr;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
	// write your code here
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        arr = new long[n];
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

        for(int i=0; i < n; i++){
            arr[i] = (Integer.parseInt(stringTokenizer.nextToken()));
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        m = Integer.parseInt(BUFFERED_READER.readLine().trim());
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        for(int i=0; i < m; i++){
            // given
            long findValue = Integer.parseInt(stringTokenizer.nextToken());

            // when
            int left = 0;
            int right = arr.length-1;

            int answer = 0;
            while (left <= right) {
                int mid = (left+right)/2; // StackOverFlow 방지
                if(arr[mid] == findValue){
                    answer = 1;
                    break;
                }
                if(arr[mid] < findValue){
                    left = mid+1;
                }
                if(arr[mid] > findValue){
                    right = mid-1;
                }
            }
            // System.out.println(left+" "+right);
            // then
            System.out.println(answer);
        }
    }
}
