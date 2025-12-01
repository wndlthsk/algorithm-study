N = int(input())
Xi = list(map(int, input().split()))

srt_Xi = sorted(set(Xi))

# 값 → 압축값 매핑
coord = {x: i for i, x in enumerate(srt_Xi)}

# 원본 순서대로 출력
print(*[coord[x] for x in Xi])
