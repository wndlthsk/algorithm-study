def solution(s):
    line = s.split(' ')
    
    res = []
    for word in line:
        if word:
            res.append(word[0].upper() + word[1:].lower())
        else:
            res.append(word)
    
    return ' '.join(res)