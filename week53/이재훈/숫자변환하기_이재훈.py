from collections import deque

def solution(x, y, n):
    q = deque([(x, 0)])
    visited = set([x])

    while q:
        cur, cnt = q.popleft()

        if cur == y:
            return cnt

        for nxt in (cur + n, cur * 2, cur * 3):
            if nxt <= y and nxt not in visited:
                visited.add(nxt)
                q.append((nxt, cnt + 1))

    return -1