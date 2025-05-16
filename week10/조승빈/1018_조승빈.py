N, M = map(int, input().split())
board = [input() for _ in range(N)]
min_repaint = float('inf')
for x in range(N - 7):
    for y in range(M - 7):
        
        repaint1, repaint2 = 0, 0
        for i in range(8):
            for j in range(8):
                current = board[x + i][y + j]
                if (i + j) % 2 == 0:
                    if current != 'W':
                        repaint1 += 1
                    if current != 'B':
                        repaint2 += 1
                else:
                    if current != 'B':
                        repaint1 += 1
                    if current != 'W':
                        repaint2 += 1
        min_repaint = min(min_repaint, repaint1,repaint2)

print(min_repaint)
