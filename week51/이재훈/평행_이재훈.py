def solution(dots):
    srt = sorted(dots)
    
    lines = []
    for i in range(1, 4):
        a, b = srt[0], srt[i]
        remain = list(set(range(4)) - set((0, i)))
        c, d = srt[remain[0]], srt[remain[1]]
        
        dx1 = b[0] - a[0]
        dy1 = b[1] - a[1]
        dx2 = d[0] - c[0]
        dy2 = d[1] - c[1]
        if dy1 * dx2 == dy2 * dx1:
            return 1
    
    return 0