import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

import static java.lang.Integer.parseInt;

class FireBall {

	private final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	int x;
	int y;
	int mugae;
	int dir;
	int speed;

	public FireBall(int x, int y, int mugae, int dir, int speed) {
		this.x = x;
		this.y = y;
		this.mugae = mugae;
		this.dir = dir;
		this.speed = speed;
	}

	public void move(final int n) {

		int nx = x + dx[dir] * speed;
		int ny = y + dy[dir] * speed;

		if (nx > n)
			nx = nx % n;
		if (nx < 1)
			nx = n - Math.abs(nx) % n;
		if (ny > n)
			ny = ny % n;
		if (ny < 1)
			ny = n - Math.abs(ny) % n;

		x = nx;
		y = ny;
	}

}

class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static ArrayList<FireBall> map[][];
	private static ArrayList<FireBall> fireBalls;

	private static int n;
	private static int m;
	private static int k;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		k = Integer.parseInt(stringTokenizer.nextToken());

		map = new ArrayList[n + 1][n + 1];
		fireBalls = new ArrayList<FireBall>();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());

			int mugae = Integer.parseInt(stringTokenizer.nextToken());
			int speed = Integer.parseInt(stringTokenizer.nextToken());
			int dir = Integer.parseInt(stringTokenizer.nextToken());

			FireBall fireBall = new FireBall(x, y, mugae, dir, speed);
			map[x][y].add(fireBall);
			fireBalls.add(fireBall);
		}

		for (int i = 0; i < k; i++) {
			for (FireBall fireBall : fireBalls) {
				map[fireBall.x][fireBall.y].remove(fireBall);
				fireBall.move(n);
				map[fireBall.x][fireBall.y].add(fireBall);
			}
			for (int h = 0; h < n + 1; h++) {
				for (int w = 0; w < n + 1; w++) {
					if(map[h][w].size() <= 1) continue;
					int sumMugae = 0;
					int sumSpeed = 0;
					int oddCount = 0;
					int pairCount = 0;
					int fireballSize = map[h][w].size();
					for (FireBall fireBall : map[h][w]) {
						sumMugae += fireBall.mugae;
						sumSpeed += fireBall.speed;
						if(fireBall.dir % 2 == 0) pairCount++; 
						else oddCount++;
						fireBalls.remove(fireBall);
					}		
					map[h][w] = new ArrayList<FireBall>();
					
					int newMugae = sumMugae/5;
					if(newMugae == 0) continue;
					int newSpeed = sumSpeed/fireballSize;
					int newStartDir = (oddCount == fireballSize || pairCount == fireballSize) ? 0 : 1;
					
					for(int make=0; make < 4; make++) {
						FireBall newFireBall = new FireBall(h, w, newMugae, newStartDir, newSpeed);
						newStartDir+=2;
						map[h][w].add(newFireBall);
						fireBalls.add(newFireBall);
					}
				}	
			}
		}
		
		int answer = fireBalls.stream().mapToInt(fireBall -> fireBall.mugae).sum();
		System.out.println(answer);

	}

}
