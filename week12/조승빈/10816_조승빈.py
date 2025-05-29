from collections import Counter
n = int(input())
cards = list(map(int, input().split()))
m = int(input())
arr = list(map(int, input().split()))

counter = Counter(cards)
result = [str(counter[q]) for q in arr]

print(' '.join(result))
