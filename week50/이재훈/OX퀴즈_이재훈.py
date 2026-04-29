def solution(quiz):
    answer = []
    
    for q in quiz:
        a, op, b, _, c = q.split()
        a, b, c = int(a), int(b), int(c)
        
        if op == '+':
            answer.append("O" if a + b == c else "X")
        else:
            answer.append("O" if a - b == c else "X")
    
    return answer