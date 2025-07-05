import sys

n, c = map(int, sys.stdin.readline().split())
goods = list(map(int, sys.stdin.readline().split()))
goods.sort()

def binarySearch(start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if goods[mid] == target:
            return True
        if goods[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False

# 1개
if binarySearch(0, n - 1, c) is True:
    print("1")
    exit(0)

left = 0
right = n - 1
while left < right:
    total = goods[left] + goods[right]
    # 2개
    if total == c:
        print("1")
        exit(0)
    elif total > c:
        right -= 1
    else:
        target = c - total
        # 3개
        if goods[left] != target and goods[right] != target and binarySearch(left + 1, right -1, target) is True:
            print("1")
            exit(0)
        left += 1

print("0")
