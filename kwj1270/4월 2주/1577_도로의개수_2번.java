import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import static java.lang.Integer.valueOf;

class NoEdge {
	int x1;
	int y1;
	int x2;
	int y2;

	public NoEdge(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public boolean isSame(int x1, int y1, int x2, int y2) {
		return this.x1 == x1 && this.y1 == y1 && this.x2 == x2 && this.y2 == y2;
	}
}

class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static List<NoEdge> list;
	private static long[][] dp;

	private static int n;
	private static int m;

	private static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

		n = valueOf(stringTokenizer.nextToken());
		m = valueOf(stringTokenizer.nextToken());
		count = valueOf(BUFFERED_READER.readLine());

		dp = new long[n + 1][m + 1];
		list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			int x1 = valueOf(stringTokenizer.nextToken());
			int y1 = valueOf(stringTokenizer.nextToken());
			int x2 = valueOf(stringTokenizer.nextToken());
			int y2 = valueOf(stringTokenizer.nextToken());

			if (y1 == y2 && x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}

			if (x1 == x2 && y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			list.add(new NoEdge(x1, y1, x2, y2));
		}

		dp[0][0] = 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {

				if (i - 1 >= 0) {
					boolean flag = true;
					for (NoEdge edge : list) {
						if (edge.isSame(i - 1, j, i, j)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						dp[i][j] += dp[i - 1][j];
					}
				}

				if (j - 1 >= 0) {
					boolean flag = true;
					for (NoEdge edge : list) {
						if (edge.isSame(i, j - 1, i, j)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						dp[i][j] += dp[i][j - 1];
					}
				}

			}
		}
		System.out.println(dp[n][m]);

	}

}
