def solution(s):
    prev = [-1] * 26
    res = []
    for i, ch in enumerate(s):
        idx = ord(ch) - ord('a')
        if prev[idx] != -1:
            res.append(i - prev[idx])
        else:
            res.append(-1)
        prev[idx] = i

    return res