dy = [0,0,1,-1]
dx = [-1,1,0,0]
pad = [[1,2,3],[4,5,6],[7,8,9],['*',0,'#']]

def getPos(target):
    y,x = 0,0
    for i in range(4):
        for j in range(3):
            if pad[i][j] == target:
                y,x = i,j
                return y,x
            
def getDistance(now,target):
    ty,tx = getPos(target)
    ny,nx = getPos(now)
    return abs(ty-ny)+abs(tx-nx)
    
def solution(numbers, hand):
    answer = ''
    # 왼손 *  오른손 
    # 2580두 엄지손가락의 거리가 같으면 오른손잡이는 오른손
    left,right = '*','#'
    for n in numbers:
        if n in [2,5,8,0]:
            if(getDistance(n,left) > getDistance(n,right)) :
                right = n
                answer += 'R'
            elif (getDistance(n,left) < getDistance(n,right)) :
                left = n
                answer += 'L'
            else:
                if hand == 'right':
                    right = n
                    answer += 'R'
                else:
                    left = n
                    answer += 'L'
                
        elif n in [1,4,7]:
            answer += 'L'
            left = n
        elif n in [3,6,9]:
            answer += 'R'
            right = n
    
    return answer

if __name__ == "__main__":
    numbers = [2,5,8,0]
    hand = 'right'
    print(solution(numbers, hand))