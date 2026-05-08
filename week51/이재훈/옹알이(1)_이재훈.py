def solution(babbling):
    announce = ["aya", "ye", "woo", "ma"]
    
    cnt = 0
    for b in babbling:
        word = b
        while len(word) > 0:
            is_deleted = False
            
            for x in announce:
                if word.startswith(x):
                    word = word[len(x):]
                    is_deleted = True
                    break
            
            if not is_deleted:
                break
        
        if word == '':
            cnt += 1
            
    return cnt