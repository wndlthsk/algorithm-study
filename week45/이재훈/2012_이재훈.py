import sys
input = sys.stdin.readline

N = int(input())
predict_grade = sorted(int(input()) for _ in range(N))

total = 0
for idx, v in enumerate(predict_grade):
  angry = abs(v - (idx + 1))
  total += angry
print(total)