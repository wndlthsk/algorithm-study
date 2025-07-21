from  itertools import permutations
from collections import deque
def solution(picks, minerals):
    answer = 0
    test= []
    ans= {"diamond":0,"iron":0,"stone":0}  #사용도 체크
    Fatigue={"diamond":{"diamond":1,"iron":1,"stone":1}, #피로도
             "iron":{"diamond":5,"iron":1,"stone":1},
             "stone":{"diamond":25,"iron":5,"stone":1}}
    pickName=["diamond","iron","stone"] #곡괭이 이름
    for pi,pN in zip(picks,pickName):
        ans[pN]=pi*5 
    q=deque()
    for x in pickName:
        if ans [x] != 0:
            q.append((x,answer,0,ans))
    minlen = len(minerals)
    while q:
        pick,a,idx,t=q.popleft()
        tmep = {"diamond":0,"iron":0,"stone":0}
        for x in pickName:
            tmep[x]=t[x]
        ind=0

        for x in range(idx,idx+5):
            if x > (minlen-1):
                test.append(a)
                break
            #try:
            a+=Fatigue[pick][minerals[x]]   #피로도 누적  
            #except:
                #print(x)      
            tmep[pick]-=1  #곡괭이 소모
            ind=x


        flag =1
        for x in pickName:
            if tmep [x]  !=0 and ind <minlen-1:
                q.append((x,a,idx+5,tmep))
                flag =0
        if ind ==minlen-1 or flag ==1:

            test.append(a)

    return min(test)
