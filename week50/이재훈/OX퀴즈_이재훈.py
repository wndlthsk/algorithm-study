def solution(quiz):
    d = {
        '+': lambda x, y: x + y,
        '-': lambda x, y: x - y,
    }
    
    res = []
    for q in quiz:
        x, op, y, _, z = q.split()
        x, y, z = map(int, [x, y, z])
        if d[op](x, y) == z:
            res.append("O")            
        else:
            res.append("X")
    
    return res
