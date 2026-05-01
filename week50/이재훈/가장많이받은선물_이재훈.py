def solution(friends, gifts):
    friend_order = friends
    n = len(friends)
    
    d = {i: [[0] * n, 0] for i in range(n)}
    for g in gifts:
        a, b = g.split()
        a_idx, b_idx = friend_order.index(a), friend_order.index(b)
        d[a_idx][1] += 1
        d[b_idx][0][a_idx] += 1
    
    received_gift_cnt = [0] * n
    for i in range(n):
        for j in range(i + 1, n):
            if d[j][0][i] > d[i][0][j]:
                received_gift_cnt[i] += 1
                continue
            elif d[j][0][i] < d[i][0][j]:
                received_gift_cnt[j] += 1
                continue
            
            calc_i = d[i][1] - sum(d[i][0])
            calc_j = d[j][1] - sum(d[j][0])
            if calc_i > calc_j:
                received_gift_cnt[i] += 1
            elif calc_i < calc_j:
                received_gift_cnt[j] += 1
    
    return max(received_gift_cnt)