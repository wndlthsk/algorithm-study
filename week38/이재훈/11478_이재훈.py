S = input()

n = len(S)
dic = set()
for i in range(n):
  for j in range(i, n):
    dic.add(S[i:j + 1])
print(len(dic))