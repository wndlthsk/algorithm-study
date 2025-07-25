
from itertools import permutations
def solution(k, dungeons):
    answer = 0
    arr = []
    for i in range(len(dungeons)):
        arr.append(i)
    per = list(permutations(arr,len(dungeons)))
    for p in per:
        cnt = 0
        life = k

        for i in p:
            before,after = dungeons[i]
            if life>= before:
                cnt +=1
                life-=after
        answer = max(cnt, answer)
    return answer