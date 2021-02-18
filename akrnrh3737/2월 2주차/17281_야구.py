import sys
# 한 이닝은 공격과 수비로 이루어짐 <- 3 아웃 발생시 종료하고 공격 수비 바꿈
# 우리팀 1번선수를 4번타자로 고정
# 선수가 안타,홈런 등등 뭘할지는 이미 결정되있고 최대값얻는 배치 순서를 결정하면됨
# 가장 많은 득점을 하는 타순을 찾고 그때의 득점 출력

# 타순 : 모든 경우의 수.. 순열 -> 4번타자 빼고 나머지 얘들(8명) 순열구함

def dfs(cnt):
    global answer
    if cnt == 9:
        if(order[3] != 0):
            return
        #만들어진 순열 넣고 모두 돌려서 최대값 찾는다
        answer = max(answer,solve())
        return

    for i in range(9):
        if not visited[i]:
            visited[i] = True
            order[cnt] = i
            dfs(cnt+1)
            visited[i] = False


def solve():
    idx = 0
    score = 0
    for inning in innings:
        outcnt = 0
        #1루 2루 3루
        first, second, third = 0,0,0 
        while outcnt < 3:
            command = inning[order[idx]]
            #아웃일때
            if command == 0:
                outcnt += 1
            #안타일때(타자, 모든 주자 한 루씩 전진)
            elif command == 1:
                score += third
                first, second, third = 1, first, second
            #2루타일때(타자, 모든 주자 두 루씩 전진)
            elif command == 2:
                score += (second + third)
                first, second, third = 0, 1, first
            #3루타일때(타자, 모든 주자 세 루씩 전진)
            elif command == 3:
                score += (first + second + third)
                first, second, third = 0, 0, 1
            #홈런일때
            elif command == 4:
                score += (1 + first + second + third)
                first, second, third = 0, 0, 0
            idx = (idx+1)%9
    return score

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    innings = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    visited = [False]*9
    order = [0]*9
    answer = -1
    dfs(0)
    print(answer)