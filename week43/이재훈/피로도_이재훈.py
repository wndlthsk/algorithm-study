# 선택 순서에 따라 결과가 달라지고, 조건이 분기됨.
# => 재귀 활용한 백트래킹
def solution(k, dungeons):
    l = len(dungeons)
    visited = [False] * l
    
    res = 0
    def dfs(cnt, cur):
        nonlocal res
        res = max(res, cnt)
        
        for i, (minimum, spent) in enumerate(dungeons):
            if not visited[i]:
                if cur >= minimum:
                    visited[i] = True
                    dfs(cnt + 1, cur - spent)
                    visited[i] = False
    
    dfs(0, k)
    
    return res