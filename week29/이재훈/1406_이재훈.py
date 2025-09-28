import sys
input = sys.stdin.readline

left = list(input().rstrip())  # 초기 문자열을 왼쪽 스택에 넣음
right = []  # 오른쪽 스택은 비워둠

M = int(input())  # 명령 개수

for _ in range(M):
  cmd = input().split()

  if cmd[0] == 'L':  # 커서를 왼쪽으로
    if left:
      right.append(left.pop())
  elif cmd[0] == 'D':  # 커서를 오른쪽으로
    if right:
      left.append(right.pop())
  elif cmd[0] == 'B':  # 커서 왼쪽 문자 삭제
    if left:
      left.pop()
  elif cmd[0] == 'P':  # 문자 추가
    left.append(cmd[1])

# 최종 문자열 = 왼쪽 스택 + (오른쪽 스택 뒤집어서)
print(''.join(left + right[::-1]))