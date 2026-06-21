def solution(name, yearning, photo):
    score = {n: y for n, y in zip(name, yearning)}
    
    answer = []
    for p in photo:
        total = 0
        for person in p:
            total += score.get(person, 0)
        answer.append(total)
    
    return answer