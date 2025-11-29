A, B = map(int, input().split())
C = int(input())

hour = A
minutes = B + C
if minutes >= 60:
  hour += minutes // 60
  minutes = minutes % 60

if hour >= 24:
  hour = hour % 24

print(hour, minutes)