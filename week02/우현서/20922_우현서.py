import sys

n, k = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))

count = {}
left = 0
max_length = 0

for right in range(n):
    if a[right] in count:
        count[a[right]] += 1

        while count[a[right]] > k:
            count[a[left]] -= 1
            left += 1
    else:
        count[a[right]] = 1 # defaultdict 사용하면 키가 없어도 0 반환함 -> if문 체크 불필요해짐

    max_length = max(max_length, right - left + 1)

print(max_length)
