def solution(bandage, health, attacks):
    atk = {}
    for a, b in attacks:
        atk[a] = b
    
    max_health = health
    t, heal, bonus = bandage
    
    maintence = 0
    cur = 0
    while cur < attacks[-1][0]:
        cur += 1
        
        if cur in atk:
            damage = atk[cur]
            health -= damage

            if health <= 0:
                return -1

            maintence = 0
        else:
            health = min(max_health, health + heal)
            maintence += 1
            
            if maintence == t:
                health = min(max_health, health + bonus)
                maintence = 0
    
    return health