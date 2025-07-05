height_list = [int(input()) for _ in range(9)]

nine = sum(height_list)
delete_sum = nine - 100

delete_x = delete_y = 0
for i, x in enumerate(height_list):
  for j, y in enumerate(height_list):
    if x == y:
      continue
    if x + y == delete_sum:
      delete_x = i
      delete_y = j
height_list.remove(delete_x)
height_list.remove(delete_y)

height_list.sort()
for x in height_list:
  print(x)

# 리스트를 순회하면서 동시에 삭제하면 인덱스가 꼬입니다! 
# → IndexError 발생하거나 결과가 잘못 나올 수 있음.

# 안전한 방법
# → "어떤 원소를 삭제할지 찾기만 하고 → 나중에 한꺼번에 삭제"


### 기존 코드 문제	
# for 루프 돌면서 del → index 깨짐
### 수정 코드 해결
# 삭제할 값 찾고 → remove()로 안전하게 삭제