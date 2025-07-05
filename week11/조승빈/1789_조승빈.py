N = int(input())
idx = 1
answer = 0
while True:
    answer+=idx
    if answer >  N:
        break
    idx+=1
print(idx-1)
