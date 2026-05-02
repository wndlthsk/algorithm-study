def solution(score):
    avg_score = []
    for x in score:
        eng, math = x
        avg = sum(x) / 2
        avg_score.append(avg)
    
    d = {}
    # {avg: avg_score 중 avg보다 높은 개수}
    for avg in avg_score:
        plus = 1
        for x in avg_score:
            if avg < x:
                plus += 1
        d[avg] = plus
    
    res = []
    for x in avg_score:
        res.append(d[x])
    
    return res