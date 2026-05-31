def solution(sizes):
    w = 0
    h = 0

    for a, b in sizes:
        a, b = max(a, b), min(a, b)
        w = max(w, a)
        h = max(h, b)

    return w * h