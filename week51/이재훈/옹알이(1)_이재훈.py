def solution(babbling):
    words = ["aya", "ye", "woo", "ma"]
    answer = 0
    
    for b in babbling:
        temp = b
        
        for w in words:
            temp = temp.replace(w, " ")
        
        if temp.strip() == "":
            answer += 1
    
    return answer