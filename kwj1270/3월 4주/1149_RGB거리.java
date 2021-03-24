import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    
    private static int[][] d = new int[10001][3];
    private static int[][] p = new int[10001][3];
    
    public static void main(String[] args) throws NumberFormatException, IOException { 
    	
    	int n = Integer.parseInt(BUFFERED_READER.readLine().trim());
    	
    	for(int i=1;i <=n; i++){
    		StringTokenizer stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
    		for(int j=0; j < 3;j++){
    			p[i][j] = Integer.parseInt(stringTokenizer.nextToken());
    		}
    	}
    	for(int i=1; i <=n; i++){
    		d[i][0] = Math.min(d[i-1][1],d[i-1][2])+p[i][0];
    		d[i][1] = Math.min(d[i-1][0],d[i-1][2])+p[i][1];
    		d[i][2] = Math.min(d[i-1][0],d[i-1][1])+p[i][2];
    	}
    	System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
    	
    }

}
