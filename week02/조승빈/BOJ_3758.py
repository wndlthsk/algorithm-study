T = int(input())

for _ in range(T):
    n,k,My_ID,m  = map(int,input().split())
    arr = []
    ans = {}
    cnt = [0 for _ in range(n+1)] #각 아이디가 푼 문제 개수 기록
    last = [0 for _ in range(n+1)] #각 아이디가 마지막 문제 푼 시간
    for i in range(n):
        ans[i+1] = [0 for _ in range(k+1)] #각 아이디가 각 문제 푼 최고 점수 기록
    for idx in range(m):
        id,num,score = map(int,input().split())
        ans[id][num] = max(score,ans[id][num])
        cnt[id]+=1
        last[id] = idx #마지막 문제 푼 시간
        
    score = [0 for _ in range(n+1)]
    for i in range(n):
        score[i+1] = sum(ans[i+1])
    
    answer = []
    for i in range(1,n+1):
        answer.append((score[i],cnt[i],last[i],i))
    answer = sorted(answer, key=lambda x:(-x[0],x[1],x[2]) )
 
    for idx in range(n) :
        if answer[idx][3] == My_ID:
            print(idx+1)   
            break
        



        
