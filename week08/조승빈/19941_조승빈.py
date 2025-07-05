N, K = map(int, input().split())
table = list(input().strip())
eaten = [False] * N
count = 0
for i in range(N):
    if table[i] == 'P':
        left = i - K
        right = i + K
        j = left
        while j <= right:
            if 0 <= j < N and table[j] == 'H' and not eaten[j]:
                eaten[j] = True
                count += 1
                break
            j += 1
print(count)
