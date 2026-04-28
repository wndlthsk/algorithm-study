def solution(score):
    avg = [(i, (a + b) / 2) for i, (a, b) in enumerate(score)]
    avg.sort(key=lambda x: -x[1])
    
    res = [0] * len(score)
    rank = 1
    
    for i in range(len(avg)):
        if i > 0 and avg[i][1] == avg[i-1][1]:
            res[avg[i][0]] = res[avg[i-1][0]]
        else:
            res[avg[i][0]] = rank
        rank += 1
    
    return res