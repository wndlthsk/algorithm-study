def solution(s):
    words = s.split(' ')
    
    for i in range(len(words)):
        temp = ""
        
        for j in range(len(words[i])):
            if j % 2 == 0:
                temp += words[i][j].upper()
            else:
                temp += words[i][j].lower()
                
        words[i] = temp
        
    return ' '.join(words)