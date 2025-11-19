from collections import Counter
import sys
input = sys.stdin.readline

N = int(input())
numbers = [int(input()) for _ in range(N)]

# 1. 평균 (반올림)
avg = round(sum(numbers) / N)

# 2. 중앙값
numbers.sort()
mid = numbers[N // 2]

# 3. 최빈값
counter = Counter(numbers)
modes = counter.most_common()

max_freq = modes[0][1]
candidates = [num for num, freq in modes if freq == max_freq]

# 여러 개면 두 번째로 작은 것
mode = candidates[0] if len(candidates) == 1 else candidates[1]

# 4. 범위
rng = max(numbers) - min(numbers)

print(avg)
print(mid)
print(mode)
print(rng)
