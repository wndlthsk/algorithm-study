import sys
n = int(sys.stdin.readline())
sol = list(map(int, sys.stdin.readline().split()))

left = 0
right = n-1
result1= sol[left]
result2 = sol[right]

while left < right:
    now = sol[left] + sol[right]
    if now == 0:
        print(sol[left], sol[right])
        exit(0)

    if abs(now) < abs(result1 + result2):
        result1 = sol[left]
        result2 = sol[right]

    if now > 0:
        right -= 1
    else:
        left += 1

print(result1, result2)
