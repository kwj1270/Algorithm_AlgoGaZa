if __name__ == "__main__":
    N = int(input()) # 사진 틀 개수
    K = int(input()) # 추천 리스트
    students = list(map(int,input().split()))
    result = {} #{학생번호:[추천수,들어온시간]} 시간이작을수록 먼저들어온것

    for i in range(K):
        key = students[i]
        if key in result.keys():
            result[key][0] += 1 #추천수증가
        else:
            if len(result) < N:
                result[key] = [1,i]
            else:
                #꽉차있을때 -> result[key][0] 오름차순 (추천수) -> result[key][1] 오름차순 (시간)
                #x[0]이 key x[1]이 value
                sortedList = sorted(result.items(), key = lambda x : (x[1][0],x[1][1]))
                deleteKey = sortedList[0][0]

                del result[deleteKey]

                result[key] = [1,i]
    
    answer = list(sorted(result.keys()))
    print(*answer)