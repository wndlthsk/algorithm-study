p, m = map(int, input().split())

rooms = []
for _ in range(p):
  l, n = input().split()
  l = int(l)

  entered = False
  for room in rooms:
    base_level = room[0][0]
    if base_level - 10 <= l <= base_level + 10 and len(room) < m:
      room.append([l, n])
      entered = True
      break

  if not entered:
    rooms.append([[l, n]])

for room in rooms:
  if len(room) == m:
    print("Started!")
  else:
    print("Waiting!")

  room = sorted(room, key=lambda x: x[1])
  for player in room:
    print(*player)