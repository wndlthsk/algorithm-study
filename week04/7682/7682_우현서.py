import sys

def is_bingo(game, indices):
    a, b, c = indices
    return game[a] != '.' and game[a] == game[b] == game[c]


while True:
    count = 0
    arr = sys.stdin.readline().strip()
    if arr == 'end':
        break
    game = list(arr)
    invalid = 0

    x_count = game.count('X')
    o_count = game.count('O')

    # 최종상태가 아닐 경우 (invalid)

    # o가 x보다 많은 경우
    # X가 O보다 2개이상 많은 경우
    if o_count > x_count or x_count > o_count + 1:
        print("invalid")
        continue

    # 가로 세로 대각선 성공이 2개 이상인 경우
    # 가로 1,2,3 / 세로 1,2,3 / 대각선 1,2
    lines = [
        (0, 1, 2), (3, 4, 5), (6, 7, 8),  # 가로
        (0, 3, 6), (1, 4, 7), (2, 5, 8),  # 세로
        (0, 4, 8), (2, 4, 6)  # 대각선
    ]

    check = 0
    for line in lines:
        if is_bingo(game, line):
            count += 1
            if game[line[0]] == 'X' and x_count <= o_count: # x로 빙고면 o의 개수는 x보다 작아야함
                print("invalid")
                check = 1
                break
            elif game[line[0]] == 'O' and x_count != o_count: # o로 빙고면 x 개수는 o랑 같아야 함
                print("invalid")
                check = 1
                break
    if check:
        continue

    # 가로 세로 대각선 성공이 없는데 빈칸이 있는 경우
    if count == 0 and '.' in game:
        print("invalid")
        continue
    print("valid")
