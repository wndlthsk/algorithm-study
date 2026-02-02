import sys
input = sys.stdin.readline

N = int(input())

cnt = 0
title = 666
while True:
  if '666' in str(title):
    cnt += 1
  
  if cnt == N:
    break
  
  title += 1
print(title)