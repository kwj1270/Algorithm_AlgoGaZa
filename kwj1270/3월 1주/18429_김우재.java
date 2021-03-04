import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static final int WEIGHT = 500;

    private static int [] list;
    private static int [] numbers;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
	    stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine());
	    n = Integer.parseInt(stringTokenizer.nextToken());
	    k = Integer.parseInt(stringTokenizer.nextToken());

	    list = new int[n];
	    numbers = new int[n];

        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine());
	    for(int i=0; i < n; i++){
	        list[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(go(0,0));
    }

    private static int go(int cnt, int flag) {
        if(flag == (1 << n)-1){
            if(isAvailable()) return 1;
            return 0;
        }

        int answer = 0;
        for(int i=0;i < n; i++){
            if((flag & (1 << i)) != 0) continue;
            numbers[cnt] = i;
            answer += go(cnt+1, flag | (1 << i));

        }
        return answer;
    }

    private static boolean isAvailable() {
        int weight = WEIGHT;
        for(int i=0; i < n; i++){
            weight += list[numbers[i]];
            weight -= k;
            if(weight < 500) return false;
        }
        return true;
    }

}
