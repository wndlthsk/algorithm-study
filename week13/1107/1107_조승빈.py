T = input()
digits = [int(c) for c in T]
N = int(T)

M = int(input())
arr = [1] * 10
if M > 0:
    tmp = list(map(int, input().split()))
    for t in tmp:
        arr[t] = 0

def is_valid(channel):
    for c in str(channel):
        if arr[int(c)] == 0:
            return False
    return True

min_press = abs(N - 100)

for channel in range(1000001):
    if is_valid(channel):
        press = len(str(channel)) + abs(channel - N)
        min_press = min(min_press, press)

print(min_press)
