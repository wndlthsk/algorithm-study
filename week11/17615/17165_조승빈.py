
N = int(input())
balls = input()
total_R = balls.count('R')
total_B = N - total_R 
left_R = left_B = 0
for ball in balls:
    if ball == 'R':
        left_R += 1
    else:
        break
for ball in balls:
    if ball == 'B':
        left_B += 1
    else:
        break
right_R = right_B = 0
for ball in reversed(balls):
    if ball == 'R':
        right_R += 1
    else:
        break
for ball in reversed(balls):
    if ball == 'B':
        right_B += 1
    else:
        break
print(min(total_R - left_R, total_R - right_R, total_B - left_B, total_B - right_B))
