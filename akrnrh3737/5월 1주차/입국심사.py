def solution(n, times):
    answer = 0
    left,right = 1, max(times)*n 
    
    if n == 1:
        return left

    while(left <= right):
        mid = (left + right) // 2
        # mid시간동안 심사가능한 인원수
        total = 0
        for x in times:
            total += (mid // x)
        # mid시간동안 심사한 인원이 n명보다 적으면 최소값을 mid+1만큼 늘린다
        if total < n:
            left = mid+1
        # mid시간동안 심사한 인원이 n명보다 크면 최대값을 mid-1만큼 줄여본다
        elif total >= n:
            right = mid-1
            answer = mid
        

    return answer