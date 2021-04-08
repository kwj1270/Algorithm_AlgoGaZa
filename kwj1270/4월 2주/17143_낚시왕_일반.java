import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.valueOf;

class Shark implements Comparable<Shark> {

	private static final int dx[] = { 0, -1, 1, 0, 0 };
	private static final int dy[] = { 0, 0, 0, 1, -1 };

	int x;
	int y;
	int s;
	int d;
	int z;

	public Shark(int x, int y, int s, int d, int z) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	public void move(final int n, final int m) {
		int nx = x;
		int ny = y;

		for (int i = 0; i < s; i++) {
			nx = nx + dx[d];
			ny = ny + dy[d];

			if (nx == -1) {
				nx = 1;
				d = 2;
			}
			if (nx == n) {
				nx = n - 2;
				d = 1;
			}

			if (ny == -1) {
				ny = 1;
				d = 3;
			}
			if (ny == m) {
				ny = m - 2;
				d = 4;
			}

		}

		x = nx;
		y = ny;
	}

	@Override
	public String toString() {
		return "Shark [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
	}

	@Override
	public int compareTo(Shark o) {
		return o.z - this.z;
	}

}

public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static List<Shark> sharks;
	private static List<Shark>[][] map;
	private static List<Shark> catchSharks;

	private static int n;
	private static int m;
	private static int count;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

		n = valueOf(stringTokenizer.nextToken());
		m = valueOf(stringTokenizer.nextToken());
		count = valueOf(stringTokenizer.nextToken());

		sharks = new ArrayList<>();
		map = new ArrayList[n][m];
		catchSharks = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < count; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

			int x = valueOf(stringTokenizer.nextToken());
			int y = valueOf(stringTokenizer.nextToken());
			int s = valueOf(stringTokenizer.nextToken());
			int d = valueOf(stringTokenizer.nextToken());
			int z = valueOf(stringTokenizer.nextToken());
			x -= 1;
			y -= 1;
			Shark shark = new Shark(x, y, s, d, z);
			sharks.add(shark);
			map[x][y].add(shark);
		}

		for (int person = 0; person < m; person++) {
			findAndRemove(person);
			sharkMove();
			removeSharkByMap();
		}
		answer = catchSharks.stream().mapToInt(shark -> shark.z).sum();
		System.out.println(answer);
	}

	private static void removeSharkByMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j].size() <= 1)
					continue;
				Collections.sort(map[i][j]);
				Shark remain = map[i][j].get(0);
				map[i][j].remove(remain);

				for (Shark removeShark : map[i][j]) {
					sharks.remove(removeShark);
				}
				map[i][j] = new ArrayList<Shark>();
				map[i][j].add(remain);
			}
		}

	}

	private static void sharkMove() {
		sharks.stream().peek(shark -> map[shark.x][shark.y].remove(shark)).peek(shark -> shark.move(n, m))
				.forEach(shark -> map[shark.x][shark.y].add(shark));
	}

	private static void findAndRemove(int m) {
		for (int i = 0; i < n; i++) {
			if (map[i][m].size() != 0) {
				Shark catchedShark = map[i][m].get(0);
				catchSharks.add(catchedShark);
				map[i][m].remove(catchedShark);
				sharks.remove(catchedShark);
				return;
			}
		}
	}

}
