package com.java.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_경주로건설 {
	static int N;
	static int[][] dp;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
    static int ans;
    
    public static class Pos{
		int y,x;
		int dir;
		int cost;
		
		public Pos(int y, int x, int dir, int cost) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", dir=" + dir + ", cost=" + cost + "]";
		}

		
    }
    public static void main(String[] args) {
		int[][] board = {
				{0,0,0},
				{0,0,0},
				{0,0,0},
		};
		System.out.println(solution(board));
	}
    public static int solution(int[][] board) {
        
        N = board.length;
        dp = board;
        ans = Integer.MAX_VALUE;
        
        byBFS(0, 0);
        
        return ans;
    }
    
    public static void byBFS(int y, int x) {
    	Queue<Pos> q = new LinkedList<>();

    	q.add(new Pos(y,x,-1,0));
    	dp[y][x] = 1;
    	
    	while(!q.isEmpty()) {

			Pos now = q.poll();

			int nowY = now.y;
			int nowX = now.x;
			int nowDir = now.dir;
			int nowCost = now.cost;
			
			if(nowY == N-1 && nowX == N-1) {
				if(ans > nowCost) {
					ans = nowCost;
				}
				continue;
			}
			
	    	for (int d = 0; d < 4; d++) {
				int ny = nowY + dy[d];
				int nx = nowX + dx[d];
				
				int nextCost = 0;
				
				if(ny >= N || ny < 0 || nx >= N || nx < 0 || dp[ny][nx] == 1) continue;
				
				if(nowDir == -1 || nowDir == d) {
					nextCost = nowCost + 100;
				}else {
					nextCost = nowCost + 600;
				}
				//처음가는곳이면 큐에 넣어줌
				if(dp[ny][nx] == 0) {
					dp[ny][nx] = nextCost;
					q.add(new Pos(ny, nx, d, nextCost));
				}else if(dp[ny][nx] >= nextCost) {
					dp[ny][nx] = nextCost; // 더 작은 값으로 갱신
					q.add(new Pos(ny, nx, d, nextCost));
				}
				
			}
    		
    	}

    }
}