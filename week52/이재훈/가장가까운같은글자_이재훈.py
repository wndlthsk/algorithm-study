def solution(s):
    pos = {}
    answer = []
    
    for i, ch in enumerate(s):
        if ch in pos:
            answer.append(i - pos[ch])
        else:
            answer.append(-1)
        
        pos[ch] = i
    
    return answer