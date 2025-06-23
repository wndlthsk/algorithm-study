from itertools import combinations
def solution(n, q, ans):
    answer = 0
    arr = [i for i in range(1,n+1)]
    arr = list(combinations(arr,5))
    for a in arr:
        tmp = []
        for q1 in q:
            cnt =0
            for idx in range(5):
                
                if q1[idx] in a:
                    cnt+=1
            tmp.append(cnt) 
        flag = 0
        #print(tmp)
        for i in range(len(q)):
            if ans[i] != tmp[i]:
                #print( ans[i] ,tmp[i])
                flag = 1
                break
        if flag ==0 :
            answer+=1
    return answer