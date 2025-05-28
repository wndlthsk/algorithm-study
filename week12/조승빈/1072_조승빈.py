X, Y = map(int, input().split(" "))
Z = (Y * 100) // X

if Z >= 99:
    print(-1)
else:
    left, right = 1, 10**9
    result = -1
    while left <= right:
        mid = (left + right) // 2
        new_Z = ((Y + mid) * 100) // (X + mid)
        if new_Z > Z:
            result = mid
            right = mid - 1
        else:
            left = mid + 1
    print(result)
