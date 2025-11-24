N = int(input())
times = [list(map(int, input().split())) for _ in range(N)]

# 1. 끝나는 시간 기준 정렬 (끝나는 시간 같으면 시작 시간 기준)
times.sort(key=lambda x: (x[1], x[0]))

count = 0
end_time = 0

# 2. greedy하게 선택
for s, e in times:
  if s >= end_time:
    count += 1
    end_time = e
print(count)