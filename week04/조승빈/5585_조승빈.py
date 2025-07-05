n = int(input())
n= 1000-n
arr = [500, 100, 50, 10, 5,1]
answer = 0
for a in arr:
    if n >=a :
        answer+=n //a 
        n %= a
print(answer)