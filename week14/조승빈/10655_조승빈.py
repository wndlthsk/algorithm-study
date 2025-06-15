# N = int(input())
# points = [tuple(map(int, input().split())) for _ in range(N)]



# total = sum(manhattan(points[i], points[i + 1]) for i in range(N - 1))
# min_dist = float('inf')

# for i in range(1, N - 1):
#     skip = manhattan(points[i - 1], points[i]) + manhattan(points[i], points[i + 1])
#     direct = manhattan(points[i - 1], points[i + 1])
#     min_dist = min(min_dist, total - skip + direct)

#print(min_dist)


n = int(input())
arr = []
def get_distance(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])
for _ in range(n):
    arr.append(list(map(int,input().split(" "))))
total = sum(get_distance(arr[i], arr[i + 1]) for i in range(n - 1)) 
answer  = 99999999999999
for i in range(1,n-1): 
    skip = get_distance(arr[i - 1], arr[i]) + get_distance(arr[i], arr[i + 1])
    direct = get_distance(arr[i - 1], arr[i + 1])
    answer = min(answer, total - skip + direct)
print(answer)