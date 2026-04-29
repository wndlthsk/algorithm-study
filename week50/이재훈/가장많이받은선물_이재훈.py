def solution(friends, gifts):
    n = len(friends)
    idx = {name: i for i, name in enumerate(friends)}
    
    gift = [[0]*n for _ in range(n)]
    gift_score = [0]*n
    
    for g in gifts:
        a, b = g.split()
        i, j = idx[a], idx[b]
        gift[i][j] += 1
        gift_score[i] += 1
        gift_score[j] -= 1
    
    res = [0]*n
    
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            
            if gift[i][j] > gift[j][i]:
                res[i] += 1
            elif gift[i][j] < gift[j][i]:
                res[j] += 1
            else:
                if gift_score[i] > gift_score[j]:
                    res[i] += 1
                elif gift_score[i] < gift_score[j]:
                    res[j] += 1
    
    return max(res)