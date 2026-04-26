def solution(rank, attendance):
    stk = []
    for (idx, r), b in zip(enumerate(rank), attendance):
        if b:
            stk.append((idx, r))
    srt = sorted(stk, key=lambda x: x[1])
    a, b, c = srt[0][0], srt[1][0], srt[2][0]
    
    return a * 10_000 + b * 100 + c