import sys
from collections import deque
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
students = list(map(int, sys.stdin.readline().split()))

photo = {}
order = 0
for i in range(m):
    if students[i] in photo:
        photo[students[i]]['rec'] += 1
    else:
        # print("새로 삽입")
        if len(photo) < n:
            photo[students[i]] = {'rec': 1, 'order': order}
        else:
            min_student = min(photo, key=lambda x: (photo[x]['rec'], photo[x]['order']))
            # print("min_student:", min_student)
            photo.pop(min_student)
            photo[students[i]] = {'rec': 1, 'order': order}
    order += 1

# print(photo)
result = sorted(photo.keys())
print(*result)