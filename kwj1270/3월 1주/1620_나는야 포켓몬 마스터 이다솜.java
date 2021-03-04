import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int n;
    private static int m;

    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
	    stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine());
	    n = Integer.parseInt(stringTokenizer.nextToken());
	    m = Integer.parseInt(stringTokenizer.nextToken());

	    for(int i=1; i <= n; i++){
	        String name = BUFFERED_READER.readLine().trim();
            map.put(i+"",name);
            map.put(name, i+"");
        }

	    for(int j=0; j < m; j++){
            System.out.println(map.get(BUFFERED_READER.readLine().trim()));
        }




    }
}
