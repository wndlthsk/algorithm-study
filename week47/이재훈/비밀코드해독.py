from itertools import combinations

def solution(n, q, ans):
    number = list(range(1, n + 1))
    combs = []
    for comb in combinations(number, 5):
        combs.append(list(comb))
    
    cnt = 0
    for i, c in enumerate(combs):
        valid = True
        for idx, x in enumerate(q):
            # 교집합 개수 계산
            match = 0
            for num in c:
                if num in x:
                    match += 1

            if match != ans[idx]:
                valid = False
                break
    
        if valid:
            cnt += 1
    
    return cnt