import sys

wheels = []
for _ in range(4):
    wheels.append(list(map(int, sys.stdin.readline().rstrip())))

# print(wheels)

k = int(sys.stdin.readline())
for _ in range(k):
    num, direction = map(int, sys.stdin.readline().rstrip().split())
    num -= 1

    rotation = [0] * 4
    rotation[num] = direction

    # 왼쪽
    for i in range(num - 1, -1, -1):
        if wheels[i][2] != wheels[i + 1][6]:
            rotation[i] = -rotation[i + 1]
        else:
            break

    # 오른쪽
    for i in range(num + 1, 4):
        if wheels[i - 1][2] != wheels[i][6]:
            rotation[i] = -rotation[i - 1]
        else:
            break

    for i in range(4):
        if rotation[i] == 1:
            wheels[i] = [wheels[i][-1]] + wheels[i][:-1]
        elif rotation[i] == -1:
            wheels[i] = wheels[i][1:] + [wheels[i][0]]

score = 0
for i in range(4):
    if wheels[i][0] == 1:
        score += (1 << i)

print(score)