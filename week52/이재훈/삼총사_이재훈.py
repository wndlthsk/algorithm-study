from itertools import combinations

def solution(number):
    cnt = 0
    for comb in combinations(number, 3):
        if sum(comb) == 0:
            cnt += 1
    
    return cnt