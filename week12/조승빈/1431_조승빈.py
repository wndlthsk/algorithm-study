def digit_sum(s):
    ans = 0 
    for c in s:
        if c.isdigit():
            ans+=int(c) 
    return ans

n = int(input())
serials = []
for _ in range(n):
    serials.append(input().strip())
serials.sort(key=lambda x: (len(x), digit_sum(x), x))

for s in serials:
    print(s)
