from itertools import combinations

n = int(input())
garden = []
for _ in range(n):
    garden.append(list(map(int, input().split(" "))))


dx = [0, 0, 0, 1, -1]
dy = [0, 1, -1, 0, 0]


possible = [(i, j) for i in range(1, n-1) for j in range(1, n-1)]

def get_positions(x, y):
    positions = []
    for i in range(5):
        positions.append((x + dx[i], y + dy[i]))
    
    return positions

def is_available(pos_list):
    visited = set()
    for x, y in pos_list:
        for px, py in get_positions(x, y):
            if (px, py) in visited:
                return False
            visited.add((px, py))
    return True

def get_total_cost(pos_list):
    total = 0
    for x, y in pos_list:
        for i in range(5): 
            total += (garden[x + dx[i]][y + dy[i]] )
    return total

answer = 99999999999999999

for comb in combinations(possible, 3):
    if is_available(comb):
        cost = get_total_cost(comb)
        answer = min(answer, cost)

print(answer)
