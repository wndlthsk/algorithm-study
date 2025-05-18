def get_victim(memo, time_memo):
    candidates = [
        i for i in range(1, len(memo))
        if memo[i] != 0 and time_memo[i] != 0
    ]
    min_memo_value = min(memo[i] for i in candidates)  
    min_index = min(
        (i for i in candidates if memo[i] == min_memo_value),
        key=lambda x: time_memo[x]
    )
    return min_index




n = int(input())
num = int(input())

arr = list(map(int,input().split(" ")))
frame = set()
memo = [0] * (num+1) #추천 횟수
time_memo = [0] * (num+1) #들어온 시간 검사
idx = 0
time = 1
for a in arr:
    time+=1
    #사진틀에 있으면 memo[a]+=1
    if a in frame:
        memo[a] +=1
        #time_memo[a] = time
        continue
    #사진틀에 없으면     
    if idx >= n:#공간이 없으면 교체(제거)
        victim = get_victim(memo, time_memo)
        #print(victim)
        idx -=1
        frame.remove(victim)
        memo[victim] = 0
        time_memo[victim] = 0

    idx+=1
    frame.add(a)
    memo[a] += 1
    time_memo[a] = time
arr = list(frame)
arr = sorted(arr)
print(*arr)