# (목적지, 이전 위치)
def solution(dirs):
    can_go = {
        'U': (0, -1),
        'D': (0, 1),
        'R': (1, 0),
        'L': (-1, 0)
    }
    record = set()
    def dfs(seq, prev_x, prev_y):
        if seq == len(dirs):
            return
        
        ch = dirs[seq]
        
        dx, dy = can_go[ch]
        nx, ny = prev_x + dx, prev_y + dy
        
        if not(-5 <= nx <= 5 and -5 <= ny <= 5):
            dfs(seq + 1, prev_x, prev_y)
        else:
            a = (nx, ny)
            b = (prev_x, prev_y)
            record.add(tuple(sorted((a, b))))
            dfs(seq + 1, nx, ny)
    dfs(0, 0, 0)
    
    return len(record)

# 피드백
# dfs/bfs는 그래프 탐색으로, 현재 위치에서 어떤 방향으로 진행할 지 선택해야 할 때 사용한다.
# 이 문제는 단순 선형 순회. 단순 시뮬레이션.