#가장 적은 비용을 들이는 여행경로 -> 최소비용 출력
import sys

def dfs(start, now, cost):
    global answer
    #모든 도시를 들렀고 다시 처음으로 돌아오면 비용 갱신하고 리턴
    if start == now and all(visited):
        answer = min(answer, cost)
        return
    else:
        for next_node in range(N):
            if map[now][next_node] > 0 and not visited[next_node]:
                visited[next_node] = True
                dfs(start, next_node, cost + map[now][next_node])
                visited[next_node] = False


if __name__ == "__main__":
    N = int(input())
    # map[i][j] : i -> j 비용
    map = [list(map(int, input().split())) for _ in range(N)]
    visited = [False] * N #방문여부
    answer = sys.maxsize 
    dfs(0, 0, 0)
    print(answer)

