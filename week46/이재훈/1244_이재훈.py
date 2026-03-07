switch_cnt = int(input())
switch_state = list(map(int, input().split()))
std_cnt = int(input())

for _ in range(std_cnt):
  gender, number = map(int, input().split())
  
  if gender == 1:
    for idx in range(number - 1, switch_cnt, number):
      switch_state[idx] = 1 - switch_state[idx]
  
  else:
    idx = number - 1
    left = idx
    right = idx
    
    while left - 1 >= 0 and right + 1 < switch_cnt and switch_state[left - 1] == switch_state[right + 1]:
      left -= 1
      right += 1
    
    for i in range(left, right + 1):
      switch_state[i] = 1 - switch_state[i]

for i in range(switch_cnt):
  print(switch_state[i], end=" ")
  if (i + 1) % 20 == 0:
    print()