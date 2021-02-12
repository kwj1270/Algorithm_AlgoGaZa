def groupChecker(s):
    stack = []
    for i,c in enumerate(s):
        if c not in stack:
            stack.append(c)
        else:
            if (i!=0) and (s[i] != s[i-1]):
                return False
    return True

# def groupChecker2(s):
#     stack = []
#     memo = set()
#     for c in s:
#         memo.add(c)
#         if len(stack) > 0 and stack[-1] == c:
#             stack.pop()
#         else:
#             if(c in memo):
#                 return False
#             stack.append(c)
#     return True

if __name__ == "__main__":
    size = int(input())
    cnt=0
    for _ in range(size):
        s = input()
        if(groupChecker(s)):
            cnt+=1
    print(cnt)
        

