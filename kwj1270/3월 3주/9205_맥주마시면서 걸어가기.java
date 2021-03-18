import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int test;
	private static int n;

	private static int[][] map;
	private static List<Point> points;

	public static void main(String[] args) throws NumberFormatException, IOException {
		test = Integer.parseInt(BUFFERED_READER.readLine());

		for (int t = 1; t <= test; t++) {
			STRING_BUILDER.setLength(0);
			points = new ArrayList<Point>();
			n = Integer.parseInt(BUFFERED_READER.readLine());
			n += 2;

			for (int i = 0; i < n; i++) {
				stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());
				points.add(new Point(x, y));
			}

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = 103;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i == j) continue;
					Point start = points.get(i);
					Point next = points.get(j);
					
					int sum = 0;
					sum += Math.abs(start.x - next.x);
					sum += Math.abs(start.y - next.y);
					if(sum <= 1000) map[i][j] = 1;
				}
			}
			
		    for (int k = 0; k < n; ++k) {
		        for (int i = 0; i < n; ++i) {
		            for (int j = 0; j < n; ++j) {
		                if (map[i][j] > map[i][k] + map[k][j]) {
		                    map[i][j] = map[i][k] + map[k][j];
		                }
		            }
		        }
		    }
		    
		    if(map[0][n-1] < 102) {
		    	STRING_BUILDER.append("happy");
		    	System.out.println(STRING_BUILDER.toString());
		    	continue;
		    }
		    
		    STRING_BUILDER.append("sad");
			System.out.println(STRING_BUILDER.toString());
		}

	}

}
