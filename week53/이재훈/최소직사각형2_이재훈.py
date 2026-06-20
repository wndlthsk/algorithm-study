def solution(sizes):
    max_w, max_h = 0, 0
    for w, h in sizes:
        small, big = min(w, h), max(w, h)
        
        max_w = max(max_w, small)
        max_h = max(max_h, big)
    
    return max_w * max_h