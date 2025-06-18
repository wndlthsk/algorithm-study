N = int(input())

series_number = 666
cnt = 0
while True:
  if '666' in str(series_number):
    cnt += 1
    if cnt == N:
      print(series_number)
      break
  series_number += 1