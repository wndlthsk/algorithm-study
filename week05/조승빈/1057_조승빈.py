n,x,y = map(int,input().split(" "))
answer = 1
while True:
    if x%2 ==1:
        x+=1
    if y%2 ==1:
        y+=1
    if x==y:
        break
    x/=2 
    y/=2
    answer+=1
print(answer)