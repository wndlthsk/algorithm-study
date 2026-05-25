def solution(k, m, score):
    box_cnt = len(score) // m
    srt = sorted(score, reverse=True)

    res = 0
    for idx in range(box_cnt):
        s_idx = idx * m
        part = srt[s_idx : s_idx+m]
        res += part[-1] * m
    
    return res