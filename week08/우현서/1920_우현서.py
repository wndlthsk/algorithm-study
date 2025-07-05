import sys

n = int(sys.stdin.readline())
numbers = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
find = list(map(int, sys.stdin.readline().split()))

for x in find:
    if x in numbers:
        print(1)
    else:
        print(0)

# 리스트로 여부 확인 안됨 -> 입력에 음수 있기 때문

# 이분 탐색  사용
# n = int(sys.stdin.readline())
# numbers = list(map(int, sys.stdin.readline().split()))
# m = int(sys.stdin.readline())
# find = list(map(int, sys.stdin.readline().split()))
#
# numbers.sort()
#
# for x in find:
#     left, right = 0, n-1
#     check = False
#     while left <= right:
#         mid = (left + right) // 2
#         if numbers[mid] == x:
#             check = True
#             break
#         elif numbers[mid] < x:
#             left = mid + 1
#         else:
#             right = mid - 1
#
#     if check:
#         print(1)
#     else:
#         print(0)