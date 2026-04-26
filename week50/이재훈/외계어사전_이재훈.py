def solution(spell, dic):
    for x in dic:
        if sorted(x) == sorted(spell):
            return 1
    
    return 2