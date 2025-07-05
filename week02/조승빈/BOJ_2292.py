N = int(input())
arr = [1]
cnt = 0
val = 1
while True:
    val +=(cnt*6)
    if N <= val:
        print(cnt+1)
        break
    cnt+=1


