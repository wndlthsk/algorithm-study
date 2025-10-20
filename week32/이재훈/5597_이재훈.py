std_w = [int(input()) for _ in range(28)]
all_std = list(range(1, 31))

for x in all_std:
  if x not in std_w:
    print(x)