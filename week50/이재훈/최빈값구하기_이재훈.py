def solution(array):
    d = {}
    for x in array:
        d[x] = d.get(x, 0) + 1
    
    srt = sorted(d.items(), key=lambda x: -x[1])
    if len(srt) >= 2 and srt[0][1] == srt[1][1]:
        return -1
    else:
        return srt[0][0]