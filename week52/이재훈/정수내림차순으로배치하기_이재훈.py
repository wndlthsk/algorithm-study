def solution(n):
    srt = sorted(str(n), reverse=True)
    
    return int(''.join(srt))