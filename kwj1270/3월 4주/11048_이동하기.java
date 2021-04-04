package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int[][] map;
	private static int[][] dp;

	private static int n;
	private static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+ map[i][j]);
				}
				if (j >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+ map[i][j]);
				}
				if (i >= 1 && j >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+ map[i][j]);
				}
			}
		}

		System.out.println(dp[n - 1][m - 1]);

	}

}
