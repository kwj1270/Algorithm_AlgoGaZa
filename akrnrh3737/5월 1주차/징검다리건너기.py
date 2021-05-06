def check(stones, value, k):
    cnt = 0
    for s in stones:
        if s < value: #못건너는곳
            cnt += 1
        else: 
            cnt = 0
        if cnt >= k:
            return False
    return True

def solution(stones,k):
    min_ = 1
    max_ = max(stones) + 1
    while min_ < max_-1 :
        # 건널수있는 사람 수
        mid = (min_ + max_) // 2
        if check(stones, mid, k):
            min_ = mid
        else:
            max_ = mid
    return min_


if __name__ == "__main__":
    stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
    k = 3
    print(solution(stones,k))