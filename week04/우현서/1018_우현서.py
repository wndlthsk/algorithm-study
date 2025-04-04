import sys

def repaint(board, row, col, start, other):
    count = 0
    for i in range(8):
        for j in range(8):
            # 더한 값이 짝수면 start와 같은색, 아니면 반대
            if (i + j) % 2 == 0:
                expect = start
            else:
                expect = other
            if board[row+i][col+j] != expect:
                count += 1
    return count

n, m = map(int, sys.stdin.readline().split())

board = []
for _ in range(n):
    board.append(list(sys.stdin.readline().strip()))
# print(board)

result = float('inf')

for i in range(n-8 + 1):
    for j in range(m-8 + 1):
        start_black = repaint(board, i, j, 'B', 'W')
        start_white = repaint(board, i, j, 'W', 'B')
        minimum = min(start_black, start_white)
        result = min(result, minimum)

print(result)